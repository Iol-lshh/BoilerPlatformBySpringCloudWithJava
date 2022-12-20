package com.chunjae.assignservice.domain.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateLoopAssignDto {
    private Long loopAssignId;
    private String teacherId;
    private int orderNo;
    private int addPoint;
    private String isUse;
    private String registerId;

    private Long assignRoleId;

    //null은 반영하지 않도록.
}
