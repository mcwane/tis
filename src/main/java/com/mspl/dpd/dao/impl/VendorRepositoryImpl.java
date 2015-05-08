package com.mspl.dpd.dao.impl;

import com.mspl.dpd.dao.repository.VendorRepository;
import com.mspl.dpd.entity.VendorMasterEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

/**
 * Created by r.ramprakash on 8/5/2014.
 */

@Repository
public class VendorRepositoryImpl implements VendorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VendorMasterEntity> getVendorsList() {
        EntityManager em = this.getEntityManager();
        return em.createQuery("FROM VendorMasterEntity vm", VendorMasterEntity.class).getResultList();
    }

    @Override
    public VendorMasterEntity getVendorById(Integer vendorId) {
        EntityManager em = this.getEntityManager();
        String sql = "from VendorMasterEntity vme where vme.vendorMasterId = "+vendorId;
        return (VendorMasterEntity) em.createQuery(sql).getSingleResult();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
