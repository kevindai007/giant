package com.kevindai.giant.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author daiwenkai
 * @Date 11/11/2019 11:05
 **/
@Getter
@Setter
public class InterfaceInfo {
    private String interfaceId;
    private String serviceType;
    private String url;
    private String basicAuthUser;
    private String basicAuthPass;
    private String timeout;
}
