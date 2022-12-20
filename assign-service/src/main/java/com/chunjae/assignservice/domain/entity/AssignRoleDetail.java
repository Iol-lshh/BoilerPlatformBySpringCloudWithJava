package com.chunjae.assignservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AssignRoleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AssignRoleDetailId;

    @Column(nullable = false)
    private String value;

    @ManyToOne(targetEntity = AssignRole.class, fetch = FetchType.LAZY)
    @JoinColumn(name="assign_id")
    private AssignRole assignRole;

    @ManyToOne(targetEntity = AssignRoleDetailColumn.class, fetch = FetchType.LAZY)
    @JoinColumn(name="assign_role_detail_column_id")
    private AssignRoleDetailColumn assignRoleDetailColumn;
}
