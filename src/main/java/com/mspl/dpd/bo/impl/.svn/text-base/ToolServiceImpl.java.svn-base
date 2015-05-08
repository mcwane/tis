package com.mspl.dpd.bo.impl;

import com.mspl.dpd.bo.service.ToolService;
import com.mspl.dpd.dao.repository.ToolRepository;
import com.mspl.dpd.entity.ToolMasterEntity;
import com.mspl.dpd.entity.ToolsVendorMapEntity;
import com.mspl.dto.ToolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ToolServiceImpl implements ToolService {

    private final ToolRepository toolRepository;

    @Autowired
    public ToolServiceImpl(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public List<ToolDTO> listAllTools() {
        List<ToolMasterEntity> toolEntityList = toolRepository.listAllTools();
        List<ToolDTO> toolResponceDTO = new ArrayList<ToolDTO>();
        Integer index = 1;
        for (ToolMasterEntity aToolEntityList : toolEntityList) {
            ToolDTO toolDTO = new ToolDTO();
            toolDTO.setSerialNo(index++);
            toolDTO.setToolId(aToolEntityList.getToolMasterId());
            toolDTO.setToolNumber(aToolEntityList.getToolNumber());
            toolDTO.setToolName(aToolEntityList.getToolName());
            toolDTO.setPatternMaterial(aToolEntityList.getPtdMaterial());
            toolDTO.setPatternCavity(aToolEntityList.getPtdCavity());
            toolDTO.setPatternQuantity(aToolEntityList.getPtdQuantity());
            toolDTO.setCbMaterial(aToolEntityList.getCbMaterial());
            toolDTO.setCbCavity(aToolEntityList.getCbCavity());
            toolDTO.setCbQuantity(aToolEntityList.getCbQuantity());
            toolDTO.setPlateMaterial(aToolEntityList.getMbMaterial());
            toolDTO.setPlateCavity(aToolEntityList.getMbCavity());
            toolDTO.setPatternQuantity(aToolEntityList.getMbQuantity());
            toolDTO.setToolingCost(aToolEntityList.getToolingCost());
            toolDTO.setProductGroup(aToolEntityList.getProductGroup());
            List<ToolsVendorMapEntity> ts = aToolEntityList.getToolsVendorMapEntity();
            for (ToolsVendorMapEntity t : ts){
                if(t.getActive()) {
                    toolDTO.setIsAssigned(true);
                    toolDTO.setVendor(t.getVendorMasterEntity().getVendorName());
                } else {
                    toolDTO.setIsAssigned(false);
                }
            }
            toolResponceDTO.add(toolDTO);
        }
        return toolResponceDTO;
    }
}
