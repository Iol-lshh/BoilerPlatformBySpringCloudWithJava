package com.chunjae.practice6.service.source;

import com.chunjae.practice6.domain.entity.Funnel;
import com.chunjae.practice6.domain.entity.Source;
import com.chunjae.practice6.domain.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    SourceRepository repos;

    @Override
    public Source saveSource(Source source) {
        source.setLastUpdated(LocalDateTime.now());
        return repos.save(source);
    }

    @Override
    public Source saveSource(Source source, Funnel funnel) {
        source.setLastUpdated(LocalDateTime.now());
        //funnel 의존성 검사? => 없다면, 에러발생
        source.setFunnel(funnel);
        return repos.save(source);
    }

    @Override
    public List<Source> getAll(){
        return repos.findAll();
    }
}
