package com.chunjae.assignservice.service.assign;

import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.PreemptiveAssign;
import com.chunjae.assignservice.domain.repository.PreemptiveAssignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreemptiveAssignServiceImpl implements PreemptiveAssignService{
    @Autowired
    PreemptiveAssignRepository preemptiveAssignRepository;

    @Override
    public PreemptiveAssign getNextPreemptiveAssignByAssignRole(AssignRole assignRole) {
        return preemptiveAssignRepository.findFirstByAssignRoleAndIsNotUsedOrderByCreatedAsc(assignRole, "Y");
    }
}
