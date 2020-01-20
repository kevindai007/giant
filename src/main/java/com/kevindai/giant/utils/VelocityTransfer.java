package com.kevindai.giant.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.NullLogChute;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.ToolManager;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;

/**
 * @Author daiwenkai
 * @Date 17/01/2020 09:44
 **/
@Slf4j
public class VelocityTransfer {
    private static ToolContext toolContext;
    private static final VelocityEngine VELOCITY_ENGINE;

    static {
        VELOCITY_ENGINE = new VelocityEngine();
        VELOCITY_ENGINE.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        VELOCITY_ENGINE.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        VELOCITY_ENGINE.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM, new NullLogChute());
        VELOCITY_ENGINE.setProperty("directive.set.null.allowed", true);
        VELOCITY_ENGINE.setProperty("userdirective", IfNullDirective.class.getName());
        try {
            VELOCITY_ENGINE.init();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("velocity init error");
            System.exit(0);

        }

        ToolManager manager = new ToolManager();
        toolContext = manager.createContext();
    }

    public static String transfer(JSONObject inputSource, String outputTemplate) throws IOException {

        VelocityContext ctx = new VelocityContext(toolContext);
        Set<String> keySet = inputSource.keySet();
        for (String s : keySet) {
            //getString()会把value=null的key过滤掉
            ctx.put(s, inputSource.get(s));
        }

        StringWriter sw = new StringWriter();
        if (!VELOCITY_ENGINE.evaluate(ctx, sw, "giant-velocity", outputTemplate)) {
            log.error("velocity evaluate failed");
            return null;
        }

        return sw.toString();
    }

    public static void main(String[] args) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data","this is my test");
        String renderedResult = VelocityTransfer.transfer(jsonObject, "{\n" +
                "  \"data\":\"$data\"" +
                "}");
        System.out.println(renderedResult);
    }
}
