package com.chunjae.assignservice.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoopAssignResultDto {

    private Long loopAssignId;

    private String teacherId;

    private int orderNo;

    //배정 가산 비율
    private int addPoint;

    //비활성 여부
    private String isUse;

    //마지막 받은 플래그
    private String isLastReceiver;

    //마지막 받은 날짜
    private LocalDateTime lastReceived;

    //등록인
    private String registerId;

    //등록날짜
    private LocalDateTime created;

    //배정 정책 이름
    private Long assignRoleId;
}
