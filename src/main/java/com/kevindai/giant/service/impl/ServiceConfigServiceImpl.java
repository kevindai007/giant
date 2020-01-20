package com.kevindai.giant.service.impl;

import com.kevindai.giant.mapper.ServiceConfigInfoMapper;
import com.kevindai.giant.model.ServiceConfigInfoExample;
import com.kevindai.giant.model.ServiceConfigInfoWithBLOBs;
import com.kevindai.giant.service.ServiceConfigService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author daiwenkai
 * @Date 09/01/2020 14:11
 **/
@Getter
@Setter
@Slf4j
@Service
public class ServiceConfigServiceImpl implements ServiceConfigService {

    @Autowired
    private ServiceConfigInfoMapper serviceConfigInfoMapper;

    @Override
    public List<ServiceConfigInfoWithBLOBs> findByServiceCode(String serviceCode) {
        ServiceConfigInfoExample example = new ServiceConfigInfoExample();
        ServiceConfigInfoExample.Criteria criteria = example.createCriteria();
        criteria.andServiceCodeEqualTo(serviceCode);
        return serviceConfigInfoMapper.selectByExampleWithBLOBs(example);
    }
}
