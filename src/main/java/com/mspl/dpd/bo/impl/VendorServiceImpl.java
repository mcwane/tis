package com.mspl.dpd.bo.impl;

import com.mspl.dpd.bo.service.VendorService;
import com.mspl.dpd.dao.repository.VendorRepository;
import com.mspl.dpd.entity.VendorMasterEntity;
import com.mspl.dto.VendorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r.ramprakash on 8/5/2014.
 */

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<VendorDTO> getVendorsList() {
        List<VendorMasterEntity> vendorMasterEntityList = this.vendorRepository.getVendorsList();
        List<VendorDTO> vendorDTOList = new ArrayList<VendorDTO>();
        for (VendorMasterEntity vendor : vendorMasterEntityList){
            VendorDTO vendorDTO = new VendorDTO();
            vendorDTO.setVendorId(vendor.getVendorMasterId());
            vendorDTO.setVendorName(vendor.getVendorName());
            vendorDTOList.add(vendorDTO);
        }
        return vendorDTOList;
    }
}
