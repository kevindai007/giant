package com.kevindai.giant.service;

import com.kevindai.giant.model.ServiceConfigInfoWithBLOBs;
import com.kevindai.giant.pojo.GiantResponseInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author daiwenkai
 * @Date 10/01/2020 16:42
 **/
public interface RequestService {
    GiantResponseInfo request(ServiceConfigInfoWithBLOBs serviceConfigInfo,HttpServletRequest request);
}
