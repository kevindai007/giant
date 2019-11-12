package com.kevindai.giant.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "giant_record_info")
public class GiantRecordInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 合作方标示
     */
    @Column(name = "partner_code")
    private String partnerCode;

    /**
     * 接口标示
     */
    @Column(name = "interface_id")
    private String interfaceId;

    /**
     * 身份证号码
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 姓名
     */
    private String name;

    /**
     * 数据源名称
     */
    @Column(name = "source_name")
    private String sourceName;

    /**
     * 结果状态码
     */
    @Column(name = "reason_code")
    private String reasonCode;

    /**
     * 查询结果
     */
    private String result;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modify")
    private Date gmtModify;

    /**
     * 扩展字段
     */
    @Column(name = "extend_value")
    private String extendValue;

    /**
     * 三方返回结果
     */
    @Column(name = "origin_result")
    private String originResult;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取合作方标示
     *
     * @return partner_code - 合作方标示
     */
    public String getPartnerCode() {
        return partnerCode;
    }

    /**
     * 设置合作方标示
     *
     * @param partnerCode 合作方标示
     */
    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    /**
     * 获取接口标示
     *
     * @return interface_id - 接口标示
     */
    public String getInterfaceId() {
        return interfaceId;
    }

    /**
     * 设置接口标示
     *
     * @param interfaceId 接口标示
     */
    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    /**
     * 获取身份证号码
     *
     * @return id_number - 身份证号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置身份证号码
     *
     * @param idNumber 身份证号码
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取数据源名称
     *
     * @return source_name - 数据源名称
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     * 设置数据源名称
     *
     * @param sourceName 数据源名称
     */
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    /**
     * 获取结果状态码
     *
     * @return reason_code - 结果状态码
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * 设置结果状态码
     *
     * @param reasonCode 结果状态码
     */
    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    /**
     * 获取查询结果
     *
     * @return result - 查询结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置查询结果
     *
     * @param result 查询结果
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取修改时间
     *
     * @return gmt_modify - 修改时间
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModify 修改时间
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * 获取扩展字段
     *
     * @return extend_value - 扩展字段
     */
    public String getExtendValue() {
        return extendValue;
    }

    /**
     * 设置扩展字段
     *
     * @param extendValue 扩展字段
     */
    public void setExtendValue(String extendValue) {
        this.extendValue = extendValue;
    }

    /**
     * 获取三方返回结果
     *
     * @return origin_result - 三方返回结果
     */
    public String getOriginResult() {
        return originResult;
    }

    /**
     * 设置三方返回结果
     *
     * @param originResult 三方返回结果
     */
    public void setOriginResult(String originResult) {
        this.originResult = originResult;
    }
}