package com.mspl.controller;

import com.mspl.dpd.bo.service.VendorService;
import com.mspl.dto.VendorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by naveen.krishnan on 28-07-2014.
 */

@RestController
@RequestMapping( "/vendors" )
public class VendorsController {

    private final VendorService vendorService;

    @Autowired
    public VendorsController(VendorService vendorService){
        this.vendorService = vendorService;
    }

    @RequestMapping ( value="/names", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public @ResponseBody List<VendorDTO> getVendorUniqueNames ( ) {
        return vendorService.getVendorsList();
    }



}
