package com.chunjae.assignservice.service.assign;

import com.chunjae.assignservice.domain.dto.request.CreateLoopAssignDto;
import com.chunjae.assignservice.domain.dto.request.UpdateLoopAssignDto;
import com.chunjae.assignservice.domain.dto.response.LoopAssignResultDto;
import com.chunjae.assignservice.domain.entity.AssignRole;
import com.chunjae.assignservice.domain.entity.LoopAssign;
import com.chunjae.assignservice.domain.factory.LoopAssignFactory;
import com.chunjae.assignservice.domain.repository.AssignRoleRepository;
import com.chunjae.assignservice.domain.repository.LoopAssignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoopAssignServiceImpl implements LoopAssignService{

    @Autowired
    LoopAssignRepository loopAssignRepository;
    @Autowired
    AssignRoleRepository assignRoleRepository;

    //전체 조회
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public List<LoopAssignResultDto> getAll(){
        return loopAssignRepository.findAll().stream().map(entity -> LoopAssignFactory.createLoopAssignDtoByEntity(entity)).toList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public LoopAssign getLoopAssignById(Long assignId) {
        return loopAssignRepository.findById(assignId).get();
    }

    @Override
    public LoopAssignResultDto getLoopAssignDtoById(Long assignId) {
        return LoopAssignFactory.createLoopAssignDtoByEntity(loopAssignRepository.findById(assignId).get());
    }

    //배정 정책으로 검색
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public List<LoopAssign> getLoopAssignListByAssignRole(AssignRole assignRole){
        return loopAssignRepository.findAllByAssignRole(assignRole);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public LoopAssign getNextLoopAssignByAssignRole(AssignRole assignRole){
        LoopAssign result = loopAssignRepository.findTop1ByAssignRoleAndIsUseAndOrderNoIsGreaterThanOrderByOrderNo(assignRole, "Y", getLastReceivedLoopAssignByAssignRole(assignRole).getOrderNo());
        return result == null ? getFirstLoopAssignByAssignRole(assignRole) : result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public LoopAssign getFirstLoopAssignByAssignRole(AssignRole assignRole) {
        return loopAssignRepository.findTop1ByAssignRoleAndIsUseOrderByOrderNo(assignRole, "Y");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public LoopAssign getLastReceivedLoopAssignByAssignRole(AssignRole assignRole) {
        return loopAssignRepository.findTop1ByAssignRoleAndIsLastReceiverOrderByOrderNo(assignRole, "Y");
    }

    @Override
    public LoopAssignResultDto setLoopAssignReturnLoopAssignDto(CreateLoopAssignDto loopAssignDto) {
        LoopAssign loopAssign = LoopAssignFactory.createEntityByLoopAssignDtoAndAssignRole(loopAssignDto
                , assignRoleRepository.getReferenceById(loopAssignDto.getAssignRoleId()));
        return LoopAssignFactory.createLoopAssignDtoByEntity(loopAssignRepository.save(loopAssign));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public LoopAssign setLoopAssign(LoopAssign loopAssign){
        return loopAssignRepository.save(loopAssign);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public LoopAssign setLoopAssign(CreateLoopAssignDto loopAssignDto){
        LoopAssign loopAssign = LoopAssignFactory.createEntityByLoopAssignDtoAndAssignRole(loopAssignDto
                    , assignRoleRepository.getReferenceById(loopAssignDto.getAssignRoleId()));
        return loopAssignRepository.save(loopAssign);
    }

    @Override
    public LoopAssignResultDto setLoopAssignReturnLoopAssignDto(UpdateLoopAssignDto loopAssignDto) {
        LoopAssign loopAssign = LoopAssignFactory.updateEntityByLoopAssignDtoAndAssignRole(loopAssignDto
                , assignRoleRepository.getReferenceById(loopAssignDto.getAssignRoleId()));
        return LoopAssignFactory.createLoopAssignDtoByEntity(loopAssignRepository.save(loopAssign));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public LoopAssign setLoopAssign(UpdateLoopAssignDto loopAssignDto) {
        LoopAssign loopAssign = LoopAssignFactory.updateEntityByLoopAssignDtoAndAssignRole(loopAssignDto
                , assignRoleRepository.getReferenceById(loopAssignDto.getAssignRoleId()));
        return loopAssignRepository.save(loopAssign);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public LoopAssign softDeleteLoopAssignById(LoopAssign loopAssign) {
        loopAssign.setIsUse("N");
        return loopAssignRepository.save(loopAssign);
    }

    @Override
    public LoopAssignResultDto softDeleteLoopAssignByIdReturnLoopAssignDto(LoopAssign loopAssign) {
        loopAssign.setIsUse("N");
        return LoopAssignFactory.createLoopAssignDtoByEntity(loopAssignRepository.save(loopAssign));
    }

}
