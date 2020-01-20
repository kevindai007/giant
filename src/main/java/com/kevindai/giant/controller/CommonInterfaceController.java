package com.kevindai.giant.controller;

import com.kevindai.giant.enums.ErrorCode;
import com.kevindai.giant.model.ServiceConfigInfoWithBLOBs;
import com.kevindai.giant.pojo.GiantResponseInfo;
import com.kevindai.giant.service.RequestService;
import com.kevindai.giant.service.ServiceConfigService;
import com.kevindai.giant.utils.ParamCheckUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author daiwenkai
 * @Date 06/12/2019 11:32
 **/
@Setter
@Getter
@Slf4j
@RestController
public class CommonInterfaceController {
    @Autowired
    private ServiceConfigService configService;

    @Autowired
    private RequestService requestService;


    @RequestMapping(value = "/common", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GiantResponseInfo common(HttpServletRequest request
            , @RequestParam("partner_code") String partnerCode
            , @RequestParam("partner_key") String partnerKey
            , @RequestParam("seq_id") String seqId
            , @RequestParam(value = "service_code", required = true) String serviceCode) {


        //首先检查product是否存在
        List<ServiceConfigInfoWithBLOBs> serviceConfigInfos = configService.findByServiceCode(serviceCode);
        if (CollectionUtils.isEmpty(serviceConfigInfos)) {
            log.info("seq_id :{} ,partner_code :{} not exists!", seqId, serviceCode);
            return GiantResponseInfo.failure(ErrorCode.PARAM_NULL_ERROR);
        }


        //再检查参数是否合法
        ServiceConfigInfoWithBLOBs serviceConfigInfo = serviceConfigInfos.get(0);
        String inputConfig = serviceConfigInfo.getInputConfig();
        boolean isvalid = ParamCheckUtils.checkParam(request, inputConfig);
        if (!isvalid) {
            log.info("param not valid");
            return GiantResponseInfo.failure(ErrorCode.PARAM_NOT_VALID);
        }

        //再拼接Url发送请求
        return requestService.request(serviceConfigInfo, request);
    }


}
