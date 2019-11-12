package com.kevindai.giant.controller;

import com.kevindai.giant.pojo.GiantRequestInfo;
import com.kevindai.giant.pojo.GiantResponseInfo;
import com.kevindai.giant.service.GiantService;
import com.kevindai.giant.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author daiwenkai
 * @Date 08/11/2019 17:43
 **/
@Slf4j
@RestController
public class InterfaceController {
    @Autowired
    private GiantService giantService;


    @PostMapping(value = "run", consumes = "application/x-www-form-urlencoded", produces = "application/json; charset=utf-8")
    public GiantResponseInfo run(HttpServletRequest request
            , @RequestParam("partner_code") String partnerCode
            , @RequestParam("partner_key") String partnerKey
            , @RequestParam("seq_id") String seqId
            , @RequestParam("product_code") String product) {

        GiantRequestInfo giantRequestInfo = new GiantRequestInfo();
        giantRequestInfo.setPartnerCode(partnerCode);
        giantRequestInfo.setPartnerKey(partnerKey);
        giantRequestInfo.setSeqId(seqId);
        giantRequestInfo.setProductCode(product);

        if (CollectionUtils.isEmpty(request.getParameterMap())) {
            log.error("ext param is empty,seqId : {}", seqId);
            return GiantResponseInfo.failure(ErrorCode.PARAM_NULL_ERROR);
        }

        Map<String, String> extParams = new HashMap<>();
        request.getParameterMap().forEach((k, v) -> {
            extParams.put(k, v[0]);
        });
        giantRequestInfo.setExtParams(extParams);

        return giantService.run(giantRequestInfo);
    }
}
