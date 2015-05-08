package com.mspl.dpd.bo.service;

import com.mspl.dpd.entity.ToolsVendorMapEntity;

/**
 * Created by r.ramprakash on 8/7/2014.
 */
public interface ToolVendorMapService {

    String mapVendorToTool(Integer toolId,Integer vendorId);

    void removeVendorAssignment(Integer toolId);

    public ToolsVendorMapEntity getMappedVendorForTool(Integer toolId );

}
