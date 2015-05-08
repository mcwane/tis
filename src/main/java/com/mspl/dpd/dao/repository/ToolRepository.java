package com.mspl.dpd.dao.repository;

import com.mspl.dpd.entity.ToolMasterEntity;

import java.util.List;

/**
 * Created by r.ramprakash on 7/28/2014.
 */
public interface ToolRepository {

    /**
     *
     *
     * @return empty arraylist when no match found.
     */
    public List<ToolMasterEntity> listAllTools();

    public ToolMasterEntity getToolById(Integer toolId);
}
