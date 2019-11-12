package com.kevindai.giant.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author daiwenkai
 * @Date 12/11/2019 11:34
 **/
public interface IMapper<T> extends Mapper<T>, MySqlMapper<T> {
}

