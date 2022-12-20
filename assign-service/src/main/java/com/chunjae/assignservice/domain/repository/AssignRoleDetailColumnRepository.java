package com.chunjae.assignservice.domain.repository;

import com.chunjae.assignservice.domain.entity.AssignRoleDetailColumn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignRoleDetailColumnRepository  extends JpaRepository<AssignRoleDetailColumn, Long> {
    List<AssignRoleDetailColumn> findByColumnName(String columnName);
}
