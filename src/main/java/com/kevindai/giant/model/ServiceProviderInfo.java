package com.kevindai.giant.model;

import java.util.Date;

public class ServiceProviderInfo {
    private Long id;

    private String name;

    private String code;

    private Integer status;

    private String type;

    private String contractNo;

    private String operateByUserName;

    private String operateByUserId;

    private Date gmtCreate;

    private Date gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
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
}