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
public class LoopAssign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loopAssignId;

    @Column(nullable = false)
    private String teacherId;

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderNo;

    //배정 가산 비율
    @Column
    private int addPoint;

    //비활성 여부
    @Column(length = 1)
    private String isUse;

    //마지막 받은 플래그
    @Column(length = 1)
    private String isLastReceiver;

    //마지막 받은 날짜
    @Column
    private LocalDateTime lastReceived;

    //등록인
    @Column
    private String registerId;

    //등록날짜
    @Column
    private LocalDateTime created;

    @ManyToOne(targetEntity = AssignRole.class, fetch = FetchType.LAZY)
    @JoinColumn(name="assign_id")
    private AssignRole assignRole;
}
