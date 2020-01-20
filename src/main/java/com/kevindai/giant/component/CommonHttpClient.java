package com.kevindai.giant.component;

import cn.hutool.http.ssl.DefaultTrustManager;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.Cookie;
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
import org.apache.http.protocol.HttpContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author daiwenkai
 * @Date 14/01/2020 14:17
 **/
@Component
@Slf4j
@Getter
@Setter
@PropertySource("classpath:httpclient.properties")
public class CommonHttpClient {

    private CloseableHttpAsyncClient asyncClient;

    private int threadCount = Runtime.getRuntime().availableProcessors() * 2;

    @Value("${connect.timeout}")
    private int connectTimeout;
    @Value("${read.timeout}")
    private int readTimeout;
    @Value("${connect.request.timeout}")
    private int connectRequestTimeout;
    @Value("${max.connection}")
    private int maxConnection;
    @Value("${max.conn.per.route}")
    private int maxConnPerRoute;


    @PostConstruct
    public void init() {
        log.info("init HttpServiceClient");

        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new DefaultTrustManager();
            ctx.init(null, new TrustManager[]{tm}, null);

            SSLIOSessionStrategy sslSessionStrategy = new SSLIOSessionStrategy(ctx, (s, sslSession) -> true);
            Registry<SchemeIOSessionStrategy> sessionStrategyRegistry = RegistryBuilder.<SchemeIOSessionStrategy>create()
                    .register("http", NoopIOSessionStrategy.INSTANCE)
                    .register("https", sslSessionStrategy)
                    .build();


            IOReactorConfig ioReactorConfig = IOReactorConfig.custom().setIoThreadCount(threadCount).build();
            ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
            PoolingNHttpClientConnectionManager poolConnManager = new PoolingNHttpClientConnectionManager(ioReactor,
                    sessionStrategyRegistry);
            poolConnManager.setMaxTotal(maxConnection);
            poolConnManager.setDefaultMaxPerRoute(maxConnPerRoute);


            RedirectStrategy noRedirect = new RedirectStrategy() {
                @Override
                public boolean isRedirected(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
                    return false;
                }

                @Override
                public HttpUriRequest getRedirect(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
                    return null;
                }
            };
            CookieStore ignoreCookieStore = new CookieStore() {
                @Override
                public void addCookie(Cookie cookie) {

                }

                @Override
                public List<Cookie> getCookies() {
                    return new ArrayList<>();
                }

                @Override
                public boolean clearExpired(Date date) {
                    return true;
                }

                @Override
                public void clear() {

                }
            };
            RequestConfig requestConfig = RequestConfig.custom().setCircularRedirectsAllowed(false)
                    .setSocketTimeout(readTimeout * 1000).setConnectTimeout(connectTimeout * 1000)
                    .setConnectionRequestTimeout(connectRequestTimeout * 1000)
                    .setCookieSpec(CookieSpecs.IGNORE_COOKIES).setMaxRedirects(0).build();

            HttpAsyncClientBuilder builder = HttpAsyncClients.custom().setRedirectStrategy(noRedirect)
                    .setConnectionManager(poolConnManager).setDefaultRequestConfig(requestConfig)
                    .setSSLStrategy(sslSessionStrategy).setSSLHostnameVerifier((s, sslSession) -> true)
                    .setDefaultCookieStore(ignoreCookieStore);


            asyncClient = builder.build();
            asyncClient.start();
        } catch (Exception e) {
            log.error("HttpServiceClient init error!");
            System.exit(0);
        }

    }
}
