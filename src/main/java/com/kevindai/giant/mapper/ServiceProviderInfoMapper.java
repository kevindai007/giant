package com.kevindai.giant.mapper;

import com.kevindai.giant.model.ServiceProviderInfo;
import com.kevindai.giant.model.ServiceProviderInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ServiceProviderInfoMapper {
    int countByExample(ServiceProviderInfoExample example);

    int deleteByExample(ServiceProviderInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServiceProviderInfo record);

    int insertSelective(ServiceProviderInfo record);

    List<ServiceProviderInfo> selectByExample(ServiceProviderInfoExample example);

    ServiceProviderInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServiceProviderInfo record, @Param("example") ServiceProviderInfoExample example);

    int updateByExample(@Param("record") ServiceProviderInfo record, @Param("example") ServiceProviderInfoExample example);

    int updateByPrimaryKeySelective(ServiceProviderInfo record);

    int updateByPrimaryKey(ServiceProviderInfo record);
}