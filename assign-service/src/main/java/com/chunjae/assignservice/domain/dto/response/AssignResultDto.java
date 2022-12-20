package com.chunjae.assignservice.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AssignResultDto {
    //배정 요청 소스 아이디
    private Long SourceId;

    //배정 결과 교사 아이디
    private String teacherId;

    //처리 전 소스 상태 (신청/체험/결제/회수)
    private String fromSourceState;

    //처리 후 소스 상태
    private String toSourceState;
}
