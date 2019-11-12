package com.kevindai.giant.service;

import com.kevindai.giant.config.InterfaceConfig;
import com.kevindai.giant.enums.ErrorCode;
import com.kevindai.giant.factory.ThirdCommonServiceFactory;
import com.kevindai.giant.pojo.GiantRequestInfo;
import com.kevindai.giant.pojo.GiantResponseInfo;
import com.kevindai.giant.pojo.InterfaceInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * 这个类主要用于走通用的流程
 *
 * @Author daiwenkai
 * @Date 11/11/2019 10:53
 **/
@Slf4j
@Setter
@Getter
@Service
public class GiantService {
    public static final int AVAILABLE_PROCESSOR = Runtime.getRuntime().availableProcessors() * 2;
    @Autowired
    private InterfaceConfig interfaceConfig;
    @Autowired
    private ThirdCommonServiceFactory factory;

    private ExecutorService threadPool = new ThreadPoolExecutor(AVAILABLE_PROCESSOR, AVAILABLE_PROCESSOR * 2, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), new ThreadFactory() {
        private int count = 0;
        private String prefix = "giant";

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, prefix + "-" + count++);
        }
    });

    public GiantResponseInfo run(GiantRequestInfo requestInfo) {
        InterfaceInfo interfaceInfo = interfaceConfig.getInterfaceInfoMap().get(requestInfo.getProductCode());
        if (interfaceInfo == null) {
            log.info("service type :{}  not found error", requestInfo.getPartnerCode());
            return GiantResponseInfo.failure(ErrorCode.UNSUPPORTED_SERVICE);
        }
        ThirdCommonService commonService = factory.createService(interfaceInfo.getInterfaceId());
        if (commonService == null) {
            log.info("service interface :{}  not found error", requestInfo.getPartnerCode());
            return GiantResponseInfo.failure(ErrorCode.UNSUPPORTED_SERVICE);
        }
        GiantResponseInfo responseInfo = commonService.run(requestInfo, interfaceInfo);
        if (responseInfo != null && responseInfo.getDispaly() == null) {
            return responseInfo;
        }

        //数据入口
        threadPool.submit(() -> commonService.saveResult(requestInfo, interfaceInfo,responseInfo));
        return responseInfo;
    }
}
