package com.mspl.dpd.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by r.ramprakash on 7/22/2014.
 */

@Entity
@Table(name = "toolmaster")
public class ToolMasterEntity implements Serializable {

    private static final long serialVersionUID = 6924778359234015439L;

    @Id
    @GeneratedValue
    @Column(name = "toolmasterid")
    private Integer toolMasterId;

    @Column(name = "toolnumber")
    private String toolNumber;

    @Column(name = "toolname")
    private String toolName;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createdon")
    private Date createdOn;

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "lastupdatedon")
    private Date lastUpdatedOn;

    @Column(name = "ptdmaterial")
    private String ptdMaterial;

    @Column(name = "ptdcavity")
    private Integer ptdCavity;

    @Column(name = "ptdquantity")
    private Integer ptdQuantity;

    @Column(name = "cbmaterial")
    private String cbMaterial;

    @Column(name = "cbcavity")
    private Integer cbCavity;

    @Column(name = "cbquantity")
    private Integer cbQuantity;

    @Column(name = "mbplate")
    private String mbMaterial;

    @Column(name = "mbcavity")
    private Integer mbCavity;

    @Column(name = "mbquantity")
    private Integer mbQuantity;

    @Column(name = "productgroup")
    private String productGroup;

    @Column(name = "toolsize")
    private String toolSize;

    @Column(name = "toolingcost")
    private Double toolingCost;

    @OneToMany(mappedBy="toolMasterEntity")
    private List<ToolsVendorMapEntity> toolsVendorMapEntity;

    public List<ToolsVendorMapEntity> getToolsVendorMapEntity() {
        return toolsVendorMapEntity;
    }

    public void setToolsVendorMapEntity(List<ToolsVendorMapEntity> toolsVendorMapEntity) {
        this.toolsVendorMapEntity = toolsVendorMapEntity;
    }

    public Integer getToolMasterId() {
        return toolMasterId;
    }

    public void setToolMasterId(Integer toolMasterId) {
        this.toolMasterId = toolMasterId;
    }

    public String getToolNumber() {
        return toolNumber;
    }

    public void setToolNumber(String toolNumber) {
        this.toolNumber = toolNumber;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
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

    public String getPtdMaterial() {
        return ptdMaterial;
    }

    public void setPtdMaterial(String ptdMaterial) {
        this.ptdMaterial = ptdMaterial;
    }

    public Integer getPtdCavity() {
        return ptdCavity;
    }

    public void setPtdCavity(Integer ptdCavity) {
        this.ptdCavity = ptdCavity;
    }

    public Integer getPtdQuantity() {
        return ptdQuantity;
    }

    public void setPtdQuantity(Integer ptdQuantity) {
        this.ptdQuantity = ptdQuantity;
    }

    public String getCbMaterial() {
        return cbMaterial;
    }

    public void setCbMaterial(String cbMaterial) {
        this.cbMaterial = cbMaterial;
    }

    public Integer getCbCavity() {
        return cbCavity;
    }

    public void setCbCavity(Integer cbCavity) {
        this.cbCavity = cbCavity;
    }

    public Integer getCbQuantity() {
        return cbQuantity;
    }

    public void setCbQuantity(Integer cbQuantity) {
        this.cbQuantity = cbQuantity;
    }

    public String getMbMaterial() {
        return mbMaterial;
    }

    public void setMbMaterial(String mbMaterial) {
        this.mbMaterial = mbMaterial;
    }

    public Integer getMbCavity() {
        return mbCavity;
    }

    public void setMbCavity(Integer mbCavity) {
        this.mbCavity = mbCavity;
    }

    public Integer getMbQuantity() {
        return mbQuantity;
    }

    public void setMbQuantity(Integer mbQuantity) {
        this.mbQuantity = mbQuantity;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getToolSize() {
        return toolSize;
    }

    public void setToolSize(String toolSize) {
        this.toolSize = toolSize;
    }

    public Double getToolingCost() {
        return toolingCost;
    }

    public void setToolingCost(Double toolingCost) {
        this.toolingCost = toolingCost;
    }
}
