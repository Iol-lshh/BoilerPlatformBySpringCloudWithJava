package com.chunjae.practice6.service.funnel;

import com.chunjae.practice6.domain.entity.Funnel;

import java.util.List;

public interface FunnelService {

    //1. 전체 유입 경로 조회
    List<Funnel> getAllFunnel();
}
