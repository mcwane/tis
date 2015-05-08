package com.mspl.dpd.bo.impl;

import com.mspl.dpd.bo.service.ToolVendorMapService;
import com.mspl.dpd.dao.impl.ToolsVendorHistoryRepoImpl;
import com.mspl.dpd.dao.repository.ToolRepository;
import com.mspl.dpd.dao.repository.ToolVendorMapRepo;
import com.mspl.dpd.dao.repository.ToolsVendorHistoryRepo;
import com.mspl.dpd.dao.repository.VendorRepository;
import com.mspl.dpd.entity.ToolMasterEntity;
import com.mspl.dpd.entity.ToolsVendorHistoryEntity;
import com.mspl.dpd.entity.ToolsVendorMapEntity;
import com.mspl.dpd.entity.VendorMasterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by r.ramprakash on 8/7/2014.
 */

@Service
@Transactional
public class ToolVendorMapServiceImpl implements ToolVendorMapService {

    private final ToolRepository toolRepository;

    private final VendorRepository vendorRepository;

    private ToolVendorMapRepo toolVendorMapRepo;

    private ToolsVendorHistoryRepo  toolsVendorHistoryRepo;

    @Autowired
    public ToolVendorMapServiceImpl(ToolRepository toolRepository, VendorRepository vendorRepository, ToolVendorMapRepo toolVendorMapRepo,ToolsVendorHistoryRepo toolsVendorHistoryRepo){
        this.toolRepository = toolRepository;
        this.vendorRepository = vendorRepository;
        this.toolVendorMapRepo = toolVendorMapRepo;
        this.toolsVendorHistoryRepo = toolsVendorHistoryRepo;
    }

    @Override
    public String mapVendorToTool(Integer toolId, Integer vendorId) {
        createToolsVendorHistory(toolId);
        toolVendorMapRepo.deactivatePreviousToolVendorMapping(toolId);
        ToolsVendorMapEntity toolsVendorMapEntity = new ToolsVendorMapEntity();
        toolsVendorMapEntity.setToolMasterEntity(toolRepository.getToolById(toolId));
        toolsVendorMapEntity.setVendorMasterEntity(vendorRepository.getVendorById(vendorId));
        toolVendorMapRepo.saveToolVendorMapping(toolsVendorMapEntity);
        return "success";
    }

    @Override
    public void removeVendorAssignment(Integer toolId ){
        createToolsVendorHistory(toolId);
        toolVendorMapRepo.deactivatePreviousToolVendorMapping(toolId);
    }

    @Override
    public ToolsVendorMapEntity getMappedVendorForTool(Integer toolId ){
        return toolVendorMapRepo.getMappedVendorForTool(toolId);
    }

    public void createToolsVendorHistory(Integer toolId){
        ToolsVendorMapEntity toolsVendorMapEntity = getMappedVendorForTool(toolId);
        if(toolsVendorMapEntity != null) {
            ToolsVendorHistoryEntity toolsVendorHistoryEntity = new ToolsVendorHistoryEntity();
            toolsVendorHistoryEntity.setToolMasterId(toolId);
            toolsVendorHistoryEntity.setVendorMasterId(toolsVendorMapEntity.getVendorMasterEntity().getVendorMasterId());
            toolsVendorHistoryEntity.setStartDate(toolsVendorMapEntity.getCreatedOn());
            toolsVendorHistoryEntity.setEndDate(new Date());
            toolsVendorHistoryRepo.saveToolVendorHistory(toolsVendorHistoryEntity);
        }
    }
}
