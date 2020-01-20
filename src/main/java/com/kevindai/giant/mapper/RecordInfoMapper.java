package com.kevindai.giant.mapper;

import com.kevindai.giant.model.RecordInfo;
import com.kevindai.giant.model.RecordInfoExample;
import com.kevindai.giant.model.RecordInfoWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RecordInfoMapper {
    int countByExample(RecordInfoExample example);

    int deleteByExample(RecordInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RecordInfoWithBLOBs record);

    int insertSelective(RecordInfoWithBLOBs record);

    List<RecordInfoWithBLOBs> selectByExampleWithBLOBs(RecordInfoExample example);

    List<RecordInfo> selectByExample(RecordInfoExample example);

    RecordInfoWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RecordInfoWithBLOBs record, @Param("example") RecordInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") RecordInfoWithBLOBs record, @Param("example") RecordInfoExample example);

    int updateByExample(@Param("record") RecordInfo record, @Param("example") RecordInfoExample example);

    int updateByPrimaryKeySelective(RecordInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecordInfoWithBLOBs record);

    int updateByPrimaryKey(RecordInfo record);
}