package com.chunjae.practice6.service.funnel;

import com.chunjae.practice6.domain.entity.Funnel;
import com.chunjae.practice6.domain.repository.FunnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunnelServiceImpl implements FunnelService{
    @Autowired
    FunnelRepository repos;
    @Override
    public List<Funnel> getAllFunnel() {
        return repos.findAll();
    }
}
