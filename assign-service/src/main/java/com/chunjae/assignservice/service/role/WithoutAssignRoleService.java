package com.chunjae.assignservice.service.role;

import com.chunjae.assignservice.domain.dto.request.SourceDto;

public interface WithoutAssignRoleService {
    boolean validateWithoutAssignRole(SourceDto sourceDto);
}
