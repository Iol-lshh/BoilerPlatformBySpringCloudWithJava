package com.chunjae.assignservice.domain.dto.request;

import lombok.Data;

@Data
public class SourceDto {
    Long sourceId;
    String sourceName;

    //학교급
    String schoolDegree;
    //학년
    String grade;

    //유입 경로
    String funnel;

    //소스 상태 (신청/체험/결제/회수)
    String state;

    //지역
    String district;

    //mgm
        //형제 회원 존재
        //지인 추천
        //교사 추천
    String mgmType;
    String mgmTeacherId;
}
