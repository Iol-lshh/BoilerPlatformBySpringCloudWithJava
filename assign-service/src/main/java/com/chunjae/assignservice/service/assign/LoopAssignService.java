package com.chunjae.assignservice.service.assign;

import com.chunjae.assignservice.domain.dto.request.CreateLoopAssignDto;
import com.chunjae.assignservice.domain.dto.request.UpdateLoopAssignDto;
import com.chunjae.assignservice.domain.dto.response.LoopAssignResultDto;
import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.LoopAssign;

import java.util.List;

public interface LoopAssignService {

    // # get
    List<LoopAssignResultDto> getAll();

    //
    LoopAssign getLoopAssignById(Long assignId);
    LoopAssignResultDto getLoopAssignDtoById(Long assignId);

    // ## 배정 정책으로 검색
    List<LoopAssign> getLoopAssignListByAssignRole(AssignRole assignRole);

    // ### 첫번째 loopAssign 조회
    LoopAssign getFirstLoopAssignByAssignRole(AssignRole assignRole);

    // ### 마지막 배정받은 loopAssign 조회
    LoopAssign getLastReceivedLoopAssignByAssignRole(AssignRole assignRole);

    // ### 다음 loopAssign 조회
    LoopAssign getNextLoopAssignByAssignRole(AssignRole assignRole);


    // --------------------------------------------------------------------------------------
    // # set
    LoopAssign setLoopAssign(LoopAssign loopAssign);

    // ## create
    LoopAssign setLoopAssign(CreateLoopAssignDto loopAssignDto);
    LoopAssignResultDto setLoopAssignReturnLoopAssignDto(CreateLoopAssignDto loopAssignDto);

    // ## update
    LoopAssign setLoopAssign(UpdateLoopAssignDto loopAssignDto);
    LoopAssignResultDto setLoopAssignReturnLoopAssignDto(UpdateLoopAssignDto loopAssignDto);


    // --------------------------------------------------------------------------------------
    // # delete
    // ## soft delete
    LoopAssign softDeleteLoopAssignById(LoopAssign loopAssign);
    LoopAssignResultDto softDeleteLoopAssignByIdReturnLoopAssignDto(LoopAssign loopAssign);

}