package com.kevindai.giant.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Writer;

/**
 * @Author daiwenkai
 * @Date 17/01/2020 17:18
 **/
public class IfNullDirective extends Directive {
    private static final String NULL = null;
    private static final int cont = 2;


    @Override
    public int getType() {
        return Directive.LINE;
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return "IfNull";
    }

    /**
     * @param context
     * @param writer
     * @param node
     * @return
     */
    @Override
    public boolean render(InternalContextAdapter context, Writer writer, Node node) throws
            IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
        if (node.jjtGetNumChildren() < 1) {
            throw new IllegalArgumentException("param error, expected at least 1");
        }

        Object target = node.jjtGetChild(0).value(context);
        Object defaultVal = null;
        if (node.jjtGetNumChildren() == 2) {
            defaultVal = node.jjtGetChild(1).value(context);
        }

        if (target != null) {
            //判断target类型，是不是JSONObject，需要把key的值未null的字段也输出
            if (target instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) target;
                String nullableStr = JSONObject.toJSONString(jsonObject, SerializerFeature.WRITE_MAP_NULL_FEATURES);
                writer.write(nullableStr);
            } else {
                writer.write((String) target);
            }
            return true;
        }

        if (defaultVal != null) {
            writer.write((String) (defaultVal));
        } else {
            writer.write(NULL);
        }
        return true;
    }

    private String replaceSpecial(Object target) {
        if (target instanceof String) {
            target = "\"" + target.toString().replace("\\", "|").replace("\"", "'") + "\"";

        }
        return target.toString();
    }

}
