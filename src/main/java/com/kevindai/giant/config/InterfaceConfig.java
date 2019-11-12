package com.kevindai.giant.config;

import com.kevindai.giant.pojo.InterfaceInfo;
import com.kevindai.giant.utils.JacksonUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author daiwenkai
 * @Date 11/11/2019 11:03
 **/
@Slf4j
@Setter
@Getter
@Component
public class InterfaceConfig {
    private static final String CONFIG_PATH = "/interfaceConfig.json";
    private Map<String, InterfaceInfo> interfaceInfoMap = new HashMap<>();

    @PostConstruct
    public void init() {
        try {
            InputStream inputStream = InterfaceConfig.class.getResourceAsStream(CONFIG_PATH);
            List<Map<String, String>> list = JacksonUtils.stream2Obj(inputStream, List.class);
            for (Map<String, String> stringStringMap : list) {
                InterfaceInfo interfaceInfo = new InterfaceInfo();
                interfaceInfo.setInterfaceId(stringStringMap.get("interfaceId"));
                interfaceInfo.setServiceType(stringStringMap.get("serviceType"));
                interfaceInfo.setUrl(stringStringMap.get("url"));
                interfaceInfo.setBasicAuthUser(stringStringMap.get("basicAuthUser"));
                interfaceInfo.setBasicAuthPass(stringStringMap.get("basicAuthPass"));
                interfaceInfo.setTimeout(stringStringMap.get("timeout"));

                interfaceInfoMap.put(stringStringMap.get("interfaceId"), interfaceInfo);
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("can't find interfaceConfig.json");
            System.exit(1);
        }
    }

}
