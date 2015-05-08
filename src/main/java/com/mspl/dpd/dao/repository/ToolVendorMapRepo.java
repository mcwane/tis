package com.mspl.dpd.dao.repository;

import com.mspl.dpd.entity.ToolsVendorMapEntity;

/**
 * Created by r.ramprakash on 8/7/2014.
 */
public interface ToolVendorMapRepo {

    void saveToolVendorMapping(ToolsVendorMapEntity toolsVendorMapEntity);

    void deactivatePreviousToolVendorMapping(Integer toolId);

    ToolsVendorMapEntity getMappedVendorForTool(Integer toolId);

}
