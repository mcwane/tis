package com.mspl.dpd.dao.impl;

import com.mspl.dpd.dao.repository.ToolVendorMapRepo;
import com.mspl.dpd.entity.ToolsVendorMapEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by r.ramprakash on 8/7/2014.
 */

@Repository
public class ToolVendorMapRepoImpl implements ToolVendorMapRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveToolVendorMapping(ToolsVendorMapEntity toolsVendorMapEntity) {
        this.getEntityManager().persist(toolsVendorMapEntity);
    }

    @Override
    public void deactivatePreviousToolVendorMapping(Integer toolId) {
       //this.getEntityManager().createQuery("update ToolsVendorMapEntity tvm set tvm.active = false where tvm.toolMasterEntity.toolMasterId = :toolId and tvm.active = true ").setParameter("toolId",toolId).executeUpdate();
         this.getEntityManager().createQuery("delete FROM ToolsVendorMapEntity tvm where tvm.toolMasterEntity.toolMasterId = :toolId").setParameter("toolId", toolId).executeUpdate();
    }

    @Override
    public ToolsVendorMapEntity getMappedVendorForTool(Integer toolId) {
        try {
            return this.getEntityManager().createQuery("FROM ToolsVendorMapEntity tvm where tvm.toolMasterEntity.toolMasterId = :toolId",ToolsVendorMapEntity.class).setParameter("toolId", toolId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
