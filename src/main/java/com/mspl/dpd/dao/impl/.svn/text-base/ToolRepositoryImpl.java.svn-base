package com.mspl.dpd.dao.impl;

import com.mspl.dpd.dao.repository.ToolRepository;
import com.mspl.dpd.entity.ToolMasterEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by r.ramprakash on 7/28/2014.
 */

@Repository
public class ToolRepositoryImpl implements ToolRepository {

    @PersistenceContext
    private EntityManager  entityManager;

    @Override
    public List<ToolMasterEntity> listAllTools(){
        EntityManager em = this.getEntityManager();
        return em.createQuery("FROM ToolMasterEntity as tm left join fetch tm.toolsVendorMapEntity as tvm left join fetch tvm.vendorMasterEntity group by tm.toolMasterId", ToolMasterEntity.class).getResultList();
    }

    @Override
    public ToolMasterEntity getToolById(Integer toolId) {
        EntityManager em = this.getEntityManager();
        String sql = "from ToolMasterEntity tme where tme.toolMasterId = "+toolId;
        return (ToolMasterEntity) em.createQuery(sql).getSingleResult();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
