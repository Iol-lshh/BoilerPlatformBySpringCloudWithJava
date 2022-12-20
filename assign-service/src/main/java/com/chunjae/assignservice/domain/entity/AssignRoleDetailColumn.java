package com.chunjae.assignservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AssignRoleDetailColumn {

    @Id
    @Column(name = "assign_role_detail_column_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignRoleDetailColumnId;

    @Column
    private String columnName;

    @OneToMany(mappedBy = "assignRoleDetailColumn")
    private List<AssignRoleDetail> assignRoleDetailList  = new ArrayList<AssignRoleDetail>();
}
