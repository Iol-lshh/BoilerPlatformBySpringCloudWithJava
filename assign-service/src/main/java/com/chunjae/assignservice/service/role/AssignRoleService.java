package com.chunjae.assignservice.service.role;

import com.chunjae.assignservice.domain.dto.request.SourceDto;
import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.AssignRoleDetail;
import com.chunjae.assignservice.domain.entity.AssignRoleDetailColumn;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public interface AssignRoleService {

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    default AssignRole getAssignRoleBySourceDto(SourceDto sourceDto) {
        //AssignRole 1:n AssignRoleDetail m:1 AssignRoleDetailColumn

        // 1. 소스에서 조건이 될 것들을 columnName String type 으로 발라낸다.
        Map<String, String> columnNameMap = getColumnNameMapBySourceDto(sourceDto);

        // 1. 일치하는 세부 조건들을 찾아온다.
        Map<AssignRoleDetailColumn, String> assignRoleDetailColumnMap = getAssignRoleDetailColumnMapBySourceDto(columnNameMap);

        // 2. 우선 순위로 첫번째 배정 세부 조건들에 맞는 배정 정책을 찾는다.
        return getAssignRoleByAssignRoleDetailColumnList(assignRoleDetailColumnMap);
    }

    // 일치하는 세부 조건들을 찾아온다.
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    default Map<AssignRoleDetailColumn, String> getAssignRoleDetailColumnMapBySourceDto(Map<String, String> columnNameMap){

        List<AssignRoleDetailColumn> assignRoleDetailColumnList = new ArrayList<>();
        columnNameMap.keySet().forEach( columnName -> assignRoleDetailColumnList.addAll(findAssignRoleDetailColumnListByColumnName(columnName)));
        Map<AssignRoleDetailColumn, String> assignRoleDetailMap = new HashMap<>();
        assignRoleDetailColumnList.stream().forEach(column -> assignRoleDetailMap.put(column, columnNameMap.get(column.getColumnName())));
        return assignRoleDetailMap;
    }

    // assignRoleDetailRepository 에서 detailColumn의 detail들에서, 확인해야한다.
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    default AssignRole getAssignRoleByAssignRoleDetailColumnList(Map<AssignRoleDetailColumn, String> assignRoleDetailColumnMap) {
        // assignRoleDetailRepository 에서 detailColumn의 detail들에서, 확인해야한다.
        // 조건 1. 가입경로 * detailColumn을 전부 확인되어야 한다.
        // 조건 2. 우선순위 가장 맨 위의 것만 가져와야 한다.

        // 1. 맞는 조건의 detail을 모은다.
        List<AssignRoleDetail> assignRoleDetails = new ArrayList<>();
        assignRoleDetailColumnMap.entrySet()
                .forEach(detailColumn -> assignRoleDetails.addAll(
                        detailColumn.getKey()
                                .getAssignRoleDetailList()
                                .stream()
                                .filter(detail -> detail.getValue().equals(detailColumn.getValue())) // 동일한 값 확인,
                                .toList()
                ));
        // 2. assign set 특정하기
        Set<AssignRole> finalAssignRoles = new HashSet<>();
        assignRoleDetails.stream().forEach(detail -> finalAssignRoles.add(detail.getAssignRole()));

        // 3. 하나라도, 값이 틀린 detail이 있다면, 그 assign을 제외해야한다..
        List<AssignRole> assignList =  finalAssignRoles.stream().filter(role -> role.getAssignRoleDetailList().size()
                        == assignRoleDetails.stream().filter(detail->detail.getAssignRole().getAssignId().equals(role.getAssignId())).count())
                .sorted(Comparator.comparingInt(AssignRole::getPriority)).toList();
        return assignList.get(assignList.size()-1);
    }

    //  AssignRoleDetailColumnList를 찾아온다.
    List<AssignRoleDetailColumn> findAssignRoleDetailColumnListByColumnName(String columnName);

//  소스에서 조건이 될 것들을 columnName String type 으로 발라낸다.
    Map<String, String> getColumnNameMapBySourceDto(SourceDto sourceDto);
}
