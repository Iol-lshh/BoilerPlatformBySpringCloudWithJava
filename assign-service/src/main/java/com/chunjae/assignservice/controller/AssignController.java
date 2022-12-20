package com.chunjae.assignservice.controller;

import com.chunjae.assignservice.domain.dto.response.AssignResultDto;
import com.chunjae.assignservice.domain.dto.request.SourceDto;
import com.chunjae.assignservice.service.assign.AssignService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assign")
public class AssignController {
    @Autowired
    private AssignService assignService;

    @Operation(summary = "assgin Source", description = "assign Source listening")
    @PostMapping ("")
    public AssignResultDto assginSource(@RequestBody SourceDto sourceDto){
        return assignService.assignSource(sourceDto);
    }
}
