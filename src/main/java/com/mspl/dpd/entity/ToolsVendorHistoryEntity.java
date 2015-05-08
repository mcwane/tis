package com.mspl.dpd.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by r.ramprakash on 12/27/2014.
 */

@Entity
@Table(name = "toolsvendorhistory")
public class ToolsVendorHistoryEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "toolsvendorhistoryid")
    private Integer toolsVendorHistoryId;

    @Column(name = "toolmasterid")
    private Integer toolMasterId;

    @Column(name = "vendormasterid")
    private Integer vendorMasterId;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createdon")
    private Date createdOn;

    @Column(name = "lastupdatedby")
    private String lastupdatedBy;

    @Column(name = "lastupdatedon")
    private Date lastupdatedOn;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getToolsVendorHistoryId() {
        return toolsVendorHistoryId;
    }

    public void setToolsVendorHistoryId(Integer toolsVendorHistoryId) {
        this.toolsVendorHistoryId = toolsVendorHistoryId;
    }

    public Integer getToolMasterId() {
        return toolMasterId;
    }

    public void setToolMasterId(Integer toolMasterId) {
        this.toolMasterId = toolMasterId;
    }

    public Integer getVendorMasterId() {
        return vendorMasterId;
    }

    public void setVendorMasterId(Integer vendorMasterId) {
        this.vendorMasterId = vendorMasterId;
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
}
