package com.mspl.dto;

/**
 * Created by naveen.krishnan on 23-07-2014.
 */
public class ToolDTO {

    private Integer serialNo;
    private Integer toolId ;
    private String toolNumber;
    private String toolName ;
    private String productGroup ;
    private String toolSize ;
    private String patternMaterial ;
    private Integer patternCavity ;
    private Integer patternQuantity ;
    private String cbMaterial ;
    private Integer cbCavity;
    private Integer cbQuantity ;
    private String plateMaterial ;
    private Integer plateCavity ;
    private Integer plateQuantity ;
    private String vendor ;
    private Double toolingCost;
    private String effectiveFrom ;
    private String expiryOn ;
    private Boolean isAssigned;

    public Boolean getIsAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(Boolean isAssigned) {
        this.isAssigned = isAssigned;
    }

    public String getToolNumber() {
        return toolNumber;
    }

    public void setToolNumber(String toolNumber) {
        this.toolNumber = toolNumber;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }


    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
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

    public String getPatternMaterial() {
        return patternMaterial;
    }

    public void setPatternMaterial(String patternMaterial) {
        this.patternMaterial = patternMaterial;
    }

    public Integer getPatternCavity() {
        return patternCavity;
    }

    public void setPatternCavity(Integer patternCavity) {
        this.patternCavity = patternCavity;
    }

    public Integer getPatternQuantity() {
        return patternQuantity;
    }

    public void setPatternQuantity(Integer patternQuantity) {
        this.patternQuantity = patternQuantity;
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

    public String getPlateMaterial() {
        return plateMaterial;
    }

    public void setPlateMaterial(String plateMaterial) {
        this.plateMaterial = plateMaterial;
    }

    public Integer getPlateCavity() {
        return plateCavity;
    }

    public void setPlateCavity(Integer plateCavity) {
        this.plateCavity = plateCavity;
    }

    public Integer getPlateQuantity() {
        return plateQuantity;
    }

    public void setPlateQuantity(Integer plateQuantity) {
        this.plateQuantity = plateQuantity;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getToolingCost() {
        return toolingCost;
    }

    public void setToolingCost(Double toolingCost) {
        this.toolingCost = toolingCost;
    }

    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public String getExpiryOn() {
        return expiryOn;
    }

    public void setExpiryOn(String expiryOn) {
        this.expiryOn = expiryOn;
    }
}
