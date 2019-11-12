package com.kevindai.giant.factory;

import com.kevindai.giant.service.ThirdCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Author daiwenkai
 * @Date 11/11/2019 16:45
 **/
@Component
public class ThirdCommonServiceFactory {
    @Autowired
    @Qualifier("bDTransService")
    private ThirdCommonService bdTransService;


    public ThirdCommonService createService(String interfaceId) {
        switch (interfaceId){
            case "BDtrans":
                return bdTransService;
        }
        return null;
    }
}
