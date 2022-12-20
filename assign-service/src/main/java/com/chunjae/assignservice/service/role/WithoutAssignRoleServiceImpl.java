package com.chunjae.assignservice.service.role;

import com.chunjae.assignservice.domain.dto.request.SourceDto;
import org.springframework.stereotype.Service;

@Service
public class WithoutAssignRoleServiceImpl implements WithoutAssignRoleService {
    @Override
    public boolean validateWithoutAssignRole(SourceDto sourceDto) {

        return false;
    }
}
