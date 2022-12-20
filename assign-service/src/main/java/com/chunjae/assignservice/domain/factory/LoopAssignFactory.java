package com.chunjae.assignservice.domain.factory;

import com.chunjae.assignservice.domain.dto.request.CreateLoopAssignDto;
import com.chunjae.assignservice.domain.dto.request.UpdateLoopAssignDto;
import com.chunjae.assignservice.domain.dto.response.LoopAssignResultDto;
import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.LoopAssign;

import java.time.LocalDateTime;

public class LoopAssignFactory {
    public static LoopAssign createEntityByLoopAssignDtoAndAssignRole(CreateLoopAssignDto dto, AssignRole assignRole){
        return LoopAssign.builder()
                .teacherId(dto.getTeacherId())
                .addPoint(1)
                .isUse("Y")
                .isLastReceiver("N")
                .lastReceived(null)
                .registerId(dto.getRegisterId())
                .created(LocalDateTime.now())
                .assignRole(assignRole)
                .build();
    }

    public static LoopAssign updateEntityByLoopAssignDtoAndAssignRole(UpdateLoopAssignDto dto, AssignRole assignRole) {
        return LoopAssign.builder()
                .loopAssignId(dto.getLoopAssignId())
                .teacherId(dto.getTeacherId())
                .addPoint(dto.getAddPoint())
                .isUse(dto.getIsUse())
                .registerId(dto.getRegisterId())
                .created(LocalDateTime.now())
                .assignRole(assignRole)
                .build();
    }

    public static LoopAssignResultDto createLoopAssignDtoByEntity(LoopAssign loopAssign) {
        return LoopAssignResultDto.builder()
                .loopAssignId(loopAssign.getLoopAssignId())
                .teacherId(loopAssign.getTeacherId())
                .orderNo(loopAssign.getOrderNo())
                .addPoint(loopAssign.getAddPoint())
                .isUse(loopAssign.getIsUse())
                .isLastReceiver(loopAssign.getIsLastReceiver())
                .lastReceived(loopAssign.getLastReceived())
                .registerId(loopAssign.getRegisterId())
                .created(loopAssign.getCreated())
                .assignRoleId(loopAssign.getAssignRole().getAssignId())
                .build();

    }
}