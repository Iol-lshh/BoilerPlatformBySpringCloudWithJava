package com.chunjae.assignservice.controller;

import com.chunjae.assignservice.domain.dto.request.CreateLoopAssignDto;
import com.chunjae.assignservice.domain.dto.request.UpdateLoopAssignDto;
import com.chunjae.assignservice.domain.dto.response.LoopAssignResultDto;
import com.chunjae.assignservice.service.assign.LoopAssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loop-assign")
public class LoopAssignController {
//  3. 교사 배정
    @Autowired
    private LoopAssignService loopAssignService;

    @GetMapping("/")
    public String test(){
        return "hello world!";
    }

    @GetMapping("/all")
    public List<LoopAssignResultDto> getAll(){
        return loopAssignService.getAll();
    }

//		- crud
    @PostMapping("/create")
    public LoopAssignResultDto createLoopAssign(@RequestBody CreateLoopAssignDto loopAssignDto){
        return loopAssignService.setLoopAssignReturnLoopAssignDto(loopAssignDto);
    }

    @GetMapping("/{id}")
    public LoopAssignResultDto readLoopAssignById(@PathVariable Long id){
        return loopAssignService.getLoopAssignDtoById(id);
    }

    @PostMapping("/update")
    public LoopAssignResultDto updateLoopAssign(@RequestBody UpdateLoopAssignDto loopAssignDto){
        return loopAssignService.setLoopAssignReturnLoopAssignDto(loopAssignDto);
    }

    @DeleteMapping("/{id}")
    public LoopAssignResultDto deleteLoopAssign(@PathVariable Long id){
        return loopAssignService.softDeleteLoopAssignByIdReturnLoopAssignDto(loopAssignService.getLoopAssignById(id));
    }

}
