package com.kevindai.giant.model;

import java.util.Date;

public class ServiceConfigInfo {
    private Long id;

    private String serviceCode;

    private String serviceName;

    private Long providerId;

    private Integer serviceType;

    private String methodType;

    private String contentType;

    private String url;

    private String billingServiceCode;

    private String operateByUserName;

    private String operateByUserId;

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;

    private String billingConfig;

    private String timeout;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode == null ? null : serviceCode.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType == null ? null : methodType.trim();
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getBillingServiceCode() {
        return billingServiceCode;
    }

    public void setBillingServiceCode(String billingServiceCode) {
        this.billingServiceCode = billingServiceCode == null ? null : billingServiceCode.trim();
    }

    public String getOperateByUserName() {
        return operateByUserName;
    }

    public void setOperateByUserName(String operateByUserName) {
        this.operateByUserName = operateByUserName == null ? null : operateByUserName.trim();
    }

    public String getOperateByUserId() {
        return operateByUserId;
    }

    public void setOperateByUserId(String operateByUserId) {
        this.operateByUserId = operateByUserId == null ? null : operateByUserId.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBillingConfig() {
        return billingConfig;
    }

    public void setBillingConfig(String billingConfig) {
        this.billingConfig = billingConfig == null ? null : billingConfig.trim();
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
}