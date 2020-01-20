package com.kevindai.giant.service;

import com.kevindai.giant.model.ServiceConfigInfoWithBLOBs;

import java.util.List;

/**
 * @Author daiwenkai
 * @Date 09/01/2020 14:09
 **/
public interface ServiceConfigService {
    List<ServiceConfigInfoWithBLOBs> findByServiceCode(String serviceCode);
}
