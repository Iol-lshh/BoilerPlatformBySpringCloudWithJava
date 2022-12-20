package com.chunjae.practice6.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Funnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funnelId;

    // 유입경로 명
    @Column
    private String funnelName;

    // 유입경로 타입
    @Column
    private String funnelType;
    // 특정 지역(지사)
    // 마케팅 구분 등..

    // 소스
    @OneToMany(mappedBy = "funnel" )
    private List<Source> sourceList = new ArrayList<Source>();
}
