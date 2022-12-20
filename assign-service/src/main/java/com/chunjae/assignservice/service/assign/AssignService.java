package com.chunjae.assignservice.service.assign;

import com.chunjae.assignservice.domain.dto.response.AssignResultDto;
import com.chunjae.assignservice.domain.dto.request.SourceDto;
import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.LoopAssign;
import com.chunjae.assignservice.domain.entity.PreemptiveAssign;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface AssignService {

    // 배정 (템플릿 메서드 패턴)
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    default AssignResultDto assignSource(SourceDto sourceDto){
//      1. 배정 제외 정책 확인 r
        if(validateWithoutAssignRole(sourceDto)){
            return null;    // #todo 제외 항목을 어떻게 처리할까?
        }

//		2. 배정 정책서 확인 r
        AssignRole assignRole = getAssignRole(sourceDto);

//      3. 배정 자동 / 수동 구분
        switch(assignRole.getAssignType()){
            case "A":
                break;
            // mgm 관계 회원
            case "R":
                //결과 반환
                return getSourceDtoByMgmAssignRole(assignRole);
            // 에듀센터 지사 - 수동으로 할 것인지?
            case "E":
                //결과 반환
                return getSourceDtoByEduAssignRole(assignRole);
        }

//      4. 보정 대기열 확인
        PreemptiveAssign preemptiveAssign = getNextPreemptiveAssignByAssignRole(assignRole);
        if(preemptiveAssign != null){
            //사용으로 변경
            preemptiveAssign.setIsNotUsed("N");
            preemptiveAssign.setAssigned(LocalDateTime.now());

            //결과 반환
            return AssignResultDto.builder()
                    .SourceId(sourceDto.getSourceId())
                    .teacherId(preemptiveAssign.getTeacherId())
                    .fromSourceState(assignRole.getFromSourceState())
                    .toSourceState(assignRole.getToSourceState())
                    .build();
        }

//		5. 순차 배정 : 다음 배정 교사 반영 r => u
//        5-1. 이전 교사 반영
        LoopAssign preLoopAssign = getLastReceivedLoopAssignByAssignRole(assignRole);
        preLoopAssign.setIsLastReceiver("N");
        setLoopAssign(preLoopAssign);
//        5-2. 다음 교사 반영
        LoopAssign nextLoopAssign = getNextLoopAssignByAssignRole(assignRole);
        nextLoopAssign.setIsLastReceiver("Y");
        nextLoopAssign.setLastReceived(LocalDateTime.now());
        setLoopAssign(nextLoopAssign);

        //결과 반환
        return AssignResultDto.builder()
                .SourceId(sourceDto.getSourceId())
                .teacherId(nextLoopAssign.getTeacherId())
                .fromSourceState(assignRole.getFromSourceState())
                .toSourceState(assignRole.getToSourceState())
                .build();
    }

    //에듀센터 소스
    AssignResultDto getSourceDtoByEduAssignRole(AssignRole assignRole);
    // mgm 관계 회원
    AssignResultDto getSourceDtoByMgmAssignRole(AssignRole assignRole);
    PreemptiveAssign getNextPreemptiveAssignByAssignRole(AssignRole assignRole);
    boolean validateWithoutAssignRole(SourceDto sourceDto);
    AssignRole getAssignRole(SourceDto sourceDto);
    LoopAssign getLastReceivedLoopAssignByAssignRole(AssignRole assignRole);
    LoopAssign getNextLoopAssignByAssignRole(AssignRole assignRole);
    LoopAssign setLoopAssign(LoopAssign loopAssign);
}
