package com.mspl.controller;

import com.mspl.dpd.bo.service.ToolService;
import com.mspl.dpd.bo.service.ToolVendorMapService;
import com.mspl.dto.ToolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ( "/tools" )
public class ToolsController {

    private final ToolService toolService;

    private final ToolVendorMapService toolVendorMapService;

    @Autowired
    public ToolsController(ToolService toolService,ToolVendorMapService toolVendorMapService) {
        this.toolService = toolService;
        this.toolVendorMapService = toolVendorMapService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ToolDTO> getAllTools () {
        List<ToolDTO> toolDTOs = toolService.listAllTools();
        return toolDTOs;
    }

    @RequestMapping(value = "/{toolid}/vendor/{vendorid}", method = RequestMethod.PUT)
    public String assignToolToVendor (@PathVariable Integer toolid, @PathVariable Integer vendorid){
        String updatedToolID = toolVendorMapService.mapVendorToTool(toolid,vendorid);
            if (updatedToolID != null) {
                return updatedToolID;
            }
        return null;
    }

    @RequestMapping(value = "/{toolid}", method = RequestMethod.PUT)
    public void removeVendorAssignment(@PathVariable(value = "toolid") Integer toolId){
        toolVendorMapService.removeVendorAssignment(toolId);
    }

}