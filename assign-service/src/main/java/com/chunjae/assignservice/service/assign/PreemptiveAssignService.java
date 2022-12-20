package com.chunjae.assignservice.service.assign;

import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.PreemptiveAssign;

public interface PreemptiveAssignService {
    PreemptiveAssign getNextPreemptiveAssignByAssignRole(AssignRole assignRole);
}
