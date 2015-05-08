package com.mspl.dpd.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by r.ramprakash on 7/24/2014.
 */

@Entity
@Table(name = "toolsvendormap")
public class ToolsVendorMapEntity implements Serializable {

    private static final long serialVersionUID = 3797487284974618363L;

    @Id
    @GeneratedValue
    @Column(name = "toolvendormapid")
    private Integer toolVendorMapId;

    @Column(name = "createdby",insertable = false)
    private String createdBy;

    @Column(name = "createdon",insertable = false)
    private Date createdOn;

    @Column(name = "lastupdatedby")
    private String lastupdatedBy;

    @Column(name = "lastupdatedon")
    private Date lastupdatedOn;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "active",insertable = false)
    private Boolean active;

    @ManyToOne
    @JoinColumn(name="toolmasterid", nullable=false)
    private ToolMasterEntity toolMasterEntity;

    public VendorMasterEntity getVendorMasterEntity() {
        return vendorMasterEntity;
    }

    public void setVendorMasterEntity(VendorMasterEntity vendorMasterEntity) {
        this.vendorMasterEntity = vendorMasterEntity;
    }

    @ManyToOne
    @JoinColumn(name="vendormasterid", nullable=false)
    private VendorMasterEntity vendorMasterEntity;

    public Integer getToolVendorMapId() {
        return toolVendorMapId;
    }

    public void setToolVendorMapId(Integer toolVendorMapId) {
        this.toolVendorMapId = toolVendorMapId;
    }

    public ToolMasterEntity getToolMasterEntity() {
        return toolMasterEntity;
    }

    public void setToolMasterEntity(ToolMasterEntity toolMasterEntity) {
        this.toolMasterEntity = toolMasterEntity;
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

    public String getLastupdatedBy() {
        return lastupdatedBy;
    }

    public void setLastupdatedBy(String lastupdatedBy) {
        this.lastupdatedBy = lastupdatedBy;
    }

    public Date getLastupdatedOn() {
        return lastupdatedOn;
    }

    public void setLastupdatedOn(Date lastupdatedOn) {
        this.lastupdatedOn = lastupdatedOn;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
