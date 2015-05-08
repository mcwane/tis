package com.mspl.dpd.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by r.ramprakash on 7/22/2014.
 */
public class EntityPersistanceImpl {

    private static EntityManager entityManager;

    public static EntityManagerFactory getEntityManagerFactory(String persistanceUnitName){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistanceUnitName);
            return entityManagerFactory;
    }

    public static EntityManager getToolingEntityManager(){
        entityManager = getEntityManagerFactory("toolinginventory").createEntityManager();
        return entityManager;
    }
}
