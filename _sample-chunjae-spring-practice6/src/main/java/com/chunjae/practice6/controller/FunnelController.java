package com.chunjae.practice6.controller;

import com.chunjae.practice6.domain.entity.Funnel;
import com.chunjae.practice6.service.funnel.FunnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funnel")
public class FunnelController {

    @Autowired
    FunnelService funnelService;

    //가입경로 조회
    @GetMapping("/all")
    public List<Funnel> getAllFunnel(){
        return funnelService.getAllFunnel();
    }
}
