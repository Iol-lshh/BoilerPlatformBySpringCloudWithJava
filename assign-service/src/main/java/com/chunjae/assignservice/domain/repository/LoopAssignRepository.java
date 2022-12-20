package com.chunjae.assignservice.domain.repository;

import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.LoopAssign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoopAssignRepository extends JpaRepository<LoopAssign, Long> {
    List<LoopAssign> findAllByAssignRole(AssignRole assignRole);

    //assign의 lastReceiver의 다음 loopAssign 출력
    LoopAssign findTop1ByAssignRoleAndIsUseAndOrderNoIsGreaterThanOrderByOrderNo(AssignRole assignRole, String use, int orderNo);

    //최초 orderNo
    LoopAssign findTop1ByAssignRoleAndIsUseOrderByOrderNo(AssignRole assignRole, String isUse);

    //마지막 배정받은 row
    LoopAssign findTop1ByAssignRoleAndIsLastReceiverOrderByOrderNo(AssignRole assignRole, String isLastReceiver);
}

