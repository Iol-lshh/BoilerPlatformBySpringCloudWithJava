package com.chunjae.assignservice.service.role;

import com.chunjae.assignservice.domain.dto.request.SourceDto;
import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.AssignRoleDetail;
import com.chunjae.assignservice.domain.entity.AssignRoleDetailColumn;
import com.chunjae.assignservice.domain.repository.AssignRoleDetailColumnRepository;
import com.chunjae.assignservice.domain.repository.AssignRoleDetailRepository;
import com.chunjae.assignservice.domain.repository.AssignRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AssignRoleServiceImpl implements AssignRoleService{
    @Autowired
    AssignRoleDetailColumnRepository assignRoleDetailColumnRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public List<AssignRoleDetailColumn> findAssignRoleDetailColumnListByColumnName(String columnName) {
        return assignRoleDetailColumnRepository.findByColumnName(columnName);
    }

    @Override
    public Map<String, String> getColumnNameMapBySourceDto(SourceDto sourceDto){
        Map<String, String> columnNameMap = new HashMap<>();
        // 정책적인 부분
        // #todo - 고민
        return columnNameMap;
    }
}
