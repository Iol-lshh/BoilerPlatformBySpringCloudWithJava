package com.chunjae.practice6.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long sourceId;

    // 학습생 이름
    @Column(nullable = false)
    String userName;

    // 연락처
    @Column(nullable = false)
    String phoneNumber;

    // 생성일
    @Column
    private LocalDateTime created;

    // 마지막 수정일
    @Column
    private LocalDateTime lastUpdated;

    // 수정인
    @Column
    private String registerId;

    //소스 상태
    @Column(length = 2)
    private String status;
    // A : 배정 대기, C : 상담 대기, E : 완료, S : 배정 정지

    // 배정 받은 교사
    @Column
    private String assignedEmployeeId;

    //사용 여부
    @Column(length = 1)
    private String isUse;
    // Y, N

    // 매핑된 학습생 계정
    @Column
    private String userId;

    // 기타 메모
    @Column(columnDefinition = "TEXT")
    private String memo;


    //유입 경로
    @ManyToOne(targetEntity = Funnel.class, fetch = FetchType.LAZY)
    @JoinColumn(name="funnel_Id")
    private Funnel funnel;
}