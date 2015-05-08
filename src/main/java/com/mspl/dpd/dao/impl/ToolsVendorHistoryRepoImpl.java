package com.mspl.dpd.dao.impl;

import com.mspl.dpd.dao.repository.ToolsVendorHistoryRepo;
import com.mspl.dpd.entity.ToolsVendorHistoryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by r.ramprakash on 12/27/2014.
 */
@Repository
public class ToolsVendorHistoryRepoImpl implements ToolsVendorHistoryRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveToolVendorHistory(ToolsVendorHistoryEntity toolsVendorMapEntity) {
        System.out.println("IN");
        System.out.println(toolsVendorMapEntity);
        System.out.println("OUT");
        this.getEntityManager().persist(toolsVendorMapEntity);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


}
