package com.chunjae.assignservice.domain.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateLoopAssignDto {
    private String teacherId;
    private String registerId;
    private Long assignRoleId;
}
