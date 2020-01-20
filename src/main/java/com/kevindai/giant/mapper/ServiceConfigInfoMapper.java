package com.kevindai.giant.mapper;

import com.kevindai.giant.model.ServiceConfigInfo;
import com.kevindai.giant.model.ServiceConfigInfoExample;
import com.kevindai.giant.model.ServiceConfigInfoWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ServiceConfigInfoMapper {
    int countByExample(ServiceConfigInfoExample example);

    int deleteByExample(ServiceConfigInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServiceConfigInfoWithBLOBs record);

    int insertSelective(ServiceConfigInfoWithBLOBs record);

    List<ServiceConfigInfoWithBLOBs> selectByExampleWithBLOBs(ServiceConfigInfoExample example);

    List<ServiceConfigInfo> selectByExample(ServiceConfigInfoExample example);

    ServiceConfigInfoWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServiceConfigInfoWithBLOBs record, @Param("example") ServiceConfigInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ServiceConfigInfoWithBLOBs record, @Param("example") ServiceConfigInfoExample example);

    int updateByExample(@Param("record") ServiceConfigInfo record, @Param("example") ServiceConfigInfoExample example);

    int updateByPrimaryKeySelective(ServiceConfigInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ServiceConfigInfoWithBLOBs record);

    int updateByPrimaryKey(ServiceConfigInfo record);
}