package com.chunjae.practice6.service.source;

import com.chunjae.practice6.domain.entity.Funnel;
import com.chunjae.practice6.domain.entity.Source;

import java.util.List;

public interface SourceService {
    //1. 소스 쓰기
    Source saveSource(Source source);

    //1-1. 가입경로 추가 기입
    Source saveSource(Source source, Funnel funnel);

    //2. 소스 전체 조회
    List<Source> getAll();
}
