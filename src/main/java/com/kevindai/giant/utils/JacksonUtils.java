package com.kevindai.giant.utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author daiwenkai
 * @Date 04/11/2019 14:00
 **/
public class JacksonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtils.class);

    public static final ObjectMapper MAPPER = new ObjectMapper();
//    public static final XmlMapper XMLMAPPER = new XmlMapper();


    public static <V> String obj2Str(V v) {
        try {
            return MAPPER.writeValueAsString(v);
        } catch (IOException e) {
            LOGGER.info("parse object to str error", e);
            return null;
        }
    }

    public static <V> V str2Obj(String str, Class<V> c) {
        try {
            return MAPPER.readValue(str, c);
        } catch (IOException e) {
            LOGGER.error("jackson from error, json: {}, type: {}", str, c, e);
            return null;
        }
    }

    public static <V> V str2Array(String str, Class<V> c) {
        try {
            return MAPPER.readValue(str, c);
        } catch (IOException e) {
            LOGGER.error("jackson from error, json: {}, type: {}", str, c, e);
            return null;
        }
    }

//    public static <V> V xmlstr2Obj(String xml, Class<V> c) {
//        try {
//            return XMLMAPPER.readValue(xml, c);
//        } catch (IOException e) {
//            LOGGER.error("jackson from xml error, xml: {}, type: {}", xml, c, e);
//            return null;
//        }
//    }
//
//    public static <V> String obj2xmlstr(V v, boolean isIndent) {
//        try {
//            if (isIndent) {
//                return XMLMAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(v);
//            } else {
//                return XMLMAPPER.writeValueAsString(v);
//            }
//        } catch (JsonProcessingException e) {
//            LOGGER.error("jackson to xml error, obj: {}, isIndent, {}", v, isIndent, e);
//            return null;
//        }
//    }

    public static <V> V stream2Obj(InputStream inputStream, Class<V> c) {
        try {
            return MAPPER.readValue(inputStream, c);
        } catch (IOException e) {
            LOGGER.error("jackson stream2Obj format error, type: {}", e);
            return null;
        }
    }

    public static JsonNode str2JsonObj(String str) {
        try {
            return MAPPER.readTree(str);
        } catch (IOException e) {
            LOGGER.error("jackson str2JsonObj format error,val :{},err:{}", str, e);
            return null;
        }
    }
}