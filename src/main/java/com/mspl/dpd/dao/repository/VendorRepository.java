package com.mspl.dpd.dao.repository;

import com.mspl.dpd.entity.VendorMasterEntity;

import java.util.List;

/**
 * Created by r.ramprakash on 8/5/2014.
 */
public interface VendorRepository {
    List<VendorMasterEntity> getVendorsList();

    VendorMasterEntity getVendorById(Integer vendorId);
}
