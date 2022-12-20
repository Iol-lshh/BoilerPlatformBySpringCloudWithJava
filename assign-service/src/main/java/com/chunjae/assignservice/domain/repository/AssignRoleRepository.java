package com.chunjae.assignservice.domain.repository;

import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.AssignRoleDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignRoleRepository extends JpaRepository<AssignRole, Long> {

}
