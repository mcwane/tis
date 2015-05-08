package com.mspl.dpd.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by r.ramprakash on 7/24/2014.
 */

@Entity
@Table(name = "vendormaster")
public class VendorMasterEntity implements Serializable {

    private static final long serialVersionUID = -2186923282875110086L;

    @Id
    @GeneratedValue
    @Column(name = "vendormasterid")
    private Integer vendorMasterId;

    @Column(name = "vendorname")
    private String vendorName;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createdon")
    private Date createdOn;

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "lastupdatedon")
    private Date lastUpdatedOn;

    @OneToMany(mappedBy = "vendorMasterEntity")
    private List<ToolsVendorMapEntity> toolsVendorMapEntity;

    public List<ToolsVendorMapEntity> getToolsVendorMapEntity() {
        return toolsVendorMapEntity;
    }

    public void setToolsVendorMapEntity(List<ToolsVendorMapEntity> toolsVendorMapEntity) {
        this.toolsVendorMapEntity = toolsVendorMapEntity;
    }

    public Integer getVendorMasterId() {
        return vendorMasterId;
    }

    public void setVendorMasterId(Integer vendorMasterId) {
        this.vendorMasterId = vendorMasterId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }
}

