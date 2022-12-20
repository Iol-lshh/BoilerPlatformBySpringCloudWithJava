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
public class AssignRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignId;

    @Column(nullable = false)
    private String assignName;

    //우선순위
    @Column
    private int priority;

    //대상 소스 상태 (신청a/체험e/결제p/회수r)
    @Column
    private String fromSourceState;

    //처리 후 소스 상태
    @Column
    private String toSourceState;

    @Column
    private String isUse;

    // 자동 / 수동 구분
    @Column
    private String assignType;

    //설명
    @Column
    private String details;

    //순차 대기열
    @OneToMany(mappedBy = "assignRole" )
    private List<LoopAssign> loopAssignList  = new ArrayList<LoopAssign>();

    //보정 대기열
    @OneToMany(mappedBy = "assignRole" )
    private List<PreemptiveAssign> preemptiveAssignList  = new ArrayList<PreemptiveAssign>();

    @OneToMany(mappedBy = "assignRole" )
    private List<AssignRoleDetail> assignRoleDetailList  = new ArrayList<AssignRoleDetail>();

}
