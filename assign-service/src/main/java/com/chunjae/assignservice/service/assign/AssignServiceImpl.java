package com.chunjae.assignservice.service.assign;

import com.chunjae.assignservice.domain.dto.request.SourceDto;
import com.chunjae.assignservice.domain.dto.response.AssignResultDto;
import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.LoopAssign;
import com.chunjae.assignservice.domain.entity.PreemptiveAssign;
import com.chunjae.assignservice.service.role.AssignRoleService;
import com.chunjae.assignservice.service.role.WithoutAssignRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignServiceImpl implements AssignService{
    @Autowired
    WithoutAssignRoleService withoutAssignRoleService;
    @Autowired
    AssignRoleService assignRoleService;
    @Autowired
    LoopAssignService loopAssignService;
    @Autowired
    PreemptiveAssignService preemptiveAssignService;

    @Override
    public AssignResultDto getSourceDtoByEduAssignRole(AssignRole assignRole) {
        // #todo
        return null;
    }

    @Override
    public AssignResultDto getSourceDtoByMgmAssignRole(AssignRole assignRole) {
        // #todo
        return null;
    }

    @Override
    public PreemptiveAssign getNextPreemptiveAssignByAssignRole(AssignRole assignRole) {
        return preemptiveAssignService.getNextPreemptiveAssignByAssignRole(assignRole);
    }

    @Override
    public boolean validateWithoutAssignRole(SourceDto sourceDto) {
        return withoutAssignRoleService.validateWithoutAssignRole(sourceDto);
    }

    @Override
    public AssignRole getAssignRole(SourceDto sourceDto) {
        return assignRoleService.getAssignRoleBySourceDto(sourceDto);
    }

    @Override
    public LoopAssign getLastReceivedLoopAssignByAssignRole(AssignRole assignRole) {
        return loopAssignService.getLastReceivedLoopAssignByAssignRole(assignRole);
    }

    @Override
    public LoopAssign getNextLoopAssignByAssignRole(AssignRole assignRole) {
        return loopAssignService.getNextLoopAssignByAssignRole(assignRole);
    }

    @Override
    public LoopAssign setLoopAssign(LoopAssign loopAssign) {
        return loopAssignService.setLoopAssign(loopAssign);
    }
}
