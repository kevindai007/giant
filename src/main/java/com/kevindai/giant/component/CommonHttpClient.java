package com.kevindai.giant.component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.conn.NoopIOSessionStrategy;
import org.apache.http.nio.conn.SchemeIOSessionStrategy;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

/**
 * @Author daiwenkai
 * @Date 11/11/2019 17:48
 **/
@Slf4j
@Getter
@Component
@PropertySource("classpath:httpclient.properties")
public class CommonHttpClient {
    private CloseableHttpAsyncClient asyncClient;

    @Value("${read.timeout}")
    private int readTimeout;
    @Value("${connect.timeout}")
    private int connectTimeout;
    @Value("${connect.request.timeout}")
    private int connectRequestTimeout;

    private int threadCount = Runtime.getRuntime().availableProcessors() * 2;

    @PostConstruct
    public void init() {
        try {
            RequestConfig requestConfig = RequestConfig.custom().setCircularRedirectsAllowed(false)
                    .setSocketTimeout(readTimeout * 1000).setConnectTimeout(connectTimeout * 1000)
                    .setConnectionRequestTimeout(connectRequestTimeout * 1000)
                    .setCookieSpec(CookieSpecs.IGNORE_COOKIES).setMaxRedirects(0).build();

            SSLContext sslcontext = SSLContexts.custom().useProtocol("TLS")
                    .loadTrustMaterial(null, (chain, authType) -> true).build();
            SSLIOSessionStrategy sslSessionStrategy = new SSLIOSessionStrategy(sslcontext, (s, sslSession) -> true);

            Registry<SchemeIOSessionStrategy> sessionStrategyRegistry = RegistryBuilder.<SchemeIOSessionStrategy>create()
                    .register("http", NoopIOSessionStrategy.INSTANCE).register("https", sslSessionStrategy)
                    .build();

            IOReactorConfig ioReactorConfig = IOReactorConfig.custom().setIoThreadCount(threadCount).build();
            ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
            PoolingNHttpClientConnectionManager poolConnManager = new PoolingNHttpClientConnectionManager(ioReactor,
                    sessionStrategyRegistry);
            poolConnManager.setDefaultMaxPerRoute(1000);
            poolConnManager.setMaxTotal(10000);


            HttpAsyncClientBuilder builder = HttpAsyncClients.custom()
                    .setConnectionManager(poolConnManager).setDefaultRequestConfig(requestConfig)
                    .setSSLStrategy(sslSessionStrategy).setSSLHostnameVerifier((s, sslSession) -> true);

            asyncClient = builder.build();
            asyncClient.start();
        } catch (Exception e) {
            log.error("catch exception when init PoolingHttpClientConnectionManager:", e);
        }

    }
}
