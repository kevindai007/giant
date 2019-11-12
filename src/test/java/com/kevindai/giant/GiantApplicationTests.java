package com.kevindai.giant;

import com.kevindai.giant.config.InterfaceConfig;
import com.kevindai.giant.pojo.InterfaceInfo;
import com.kevindai.giant.utils.JacksonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GiantApplicationTests {
    @Autowired
    private InterfaceConfig interfaceConfig;

    @Test
    public void contextLoads() {
        Map<String, InterfaceInfo> interfaceInfoMap = interfaceConfig.getInterfaceInfoMap();
        System.out.println(JacksonUtils.obj2Str(interfaceInfoMap));
    }


    @Test
    public void jsonTest(){
        InputStream inputStream = InterfaceConfig.class.getResourceAsStream("/interfaceConfig.json");
        List<Map<String,String>> list = JacksonUtils.stream2Obj(inputStream, List.class);
        for (Map<String, String> stringStringMap : list) {
            InterfaceInfo interfaceInfo = new InterfaceInfo();
            interfaceInfo.setInterfaceId(stringStringMap.get("interfaceId"));
            interfaceInfo.setServiceType(stringStringMap.get("serviceType"));
            interfaceInfo.setUrl(stringStringMap.get("url"));
            interfaceInfo.setBasicAuthUser(stringStringMap.get("basicAuthUser"));
            interfaceInfo.setBasicAuthPass(stringStringMap.get("basicAuthPass"));
            interfaceInfo.setTimeout(stringStringMap.get("timeout"));
        }

        System.out.println(list);
    }
}
