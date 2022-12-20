package com.chunjae.assignservice.domain.repository;


import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.PreemptiveAssign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreemptiveAssignRepository extends JpaRepository<PreemptiveAssign, Long> {
    PreemptiveAssign findFirstByAssignRoleAndIsNotUsedOrderByCreatedAsc(AssignRole assignRole, String isNotUsed);
}
