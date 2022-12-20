package com.chunjae.assignservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PreemptiveAssign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loopAssignId;

    // 보정 대상
    @Column(nullable = false)
    private String teacherId;

    @ManyToOne(targetEntity = AssignRole.class, fetch = FetchType.LAZY)
    @JoinColumn(name="assign_id")
    private AssignRole assignRole;

    // 보정 여부
    @Column(length = 1)
    private String isNotUsed;

    // 생성일
    @Column
    private LocalDateTime created;

    // 최종 변경일
    @Column
    private LocalDateTime updated;

    @Column
    private LocalDateTime assigned;

    // 등록자
    @Column
    private String registerId;
}
