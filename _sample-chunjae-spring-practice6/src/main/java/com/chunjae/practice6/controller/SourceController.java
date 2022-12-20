package com.chunjae.practice6.controller;

import com.chunjae.practice6.domain.entity.Source;
import com.chunjae.practice6.service.source.SourceService;
import com.chunjae.practice6.service.source.dto.DefaultSourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/source")
public class SourceController {

    @Autowired
    SourceService sourceService;

    @GetMapping("/")
    public String getHelloworld(){
        return "hello world";
    }

    //체험 신청
    @PostMapping("/apply")
    public Source applyFreeExperience(Source source){
        return sourceService.saveSource(source);
    }

    //체험 신청 + 가입경로
    @PostMapping("/apply/funnel")
    public Source applyFreeExperience(DefaultSourceDto sourceDto){
        return sourceService.saveSource(sourceDto.getSource(), sourceDto.getFunnel());
    }

    //리스트 조회
    @GetMapping("/allList")
    public List<Source> getAllList(){
        return sourceService.getAll();
    }
}
