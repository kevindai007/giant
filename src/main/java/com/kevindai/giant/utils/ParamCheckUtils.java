package com.kevindai.giant.utils;

import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kevindai.giant.constants.DataTypeEnum;
import com.kevindai.giant.constants.ParamTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author daiwenkai
 * @Date 10/01/2020 15:52
 **/
@Slf4j
public class ParamCheckUtils {

    public static boolean checkParam(HttpServletRequest request, String inputConfig) {
        if (StringUtils.isBlank(inputConfig)) {
            return false;
        }
        Map<String, String[]> parameterMap = request.getParameterMap();

        JSONArray inputParams = JSON.parseArray(inputConfig);
        for (Object object : inputParams) {
            JSONObject inputParam = (JSONObject) object;
            Boolean required = inputParam.getBoolean("required");
            String serviceParam = inputParam.getString("service_param");
            String maxLength = inputParam.getString("max_length");
            //1:变量(入参来自request)  2:定值(入参来自value字段) 3:枚举
            String type = inputParam.getString("type");
            //1:字符 2:整形 3:小数 4:布尔 5:日期
            String dataType = inputParam.getString("data_type");

            String value = inputParam.getString("value");
            String inputValue = parameterMap.get(serviceParam) == null ? "" : parameterMap.get(serviceParam)[0];


            if (required && StringUtils.isBlank(inputValue) && !ParamTypeEnum.CONSISTENT.getValue().equals(type)) {
                log.info("param {} is required but missing", serviceParam);
                return false;
            }


            if (StringUtils.isNotBlank(inputValue) && ParamTypeEnum.CONSISTENT.getValue().equals(type) && !value.equals(inputValue)) {
                log.info("param {} is consistent ,but not equal to inputValue : {}", serviceParam, inputValue);
                return false;
            }

            if (ParamTypeEnum.ENUMS.getValue().equals(type) && isEnum(value, inputValue)) {
                log.info("param {} is enums ,but not contain inputValue : {}", serviceParam, inputValue);
                return false;
            }


            if (DataTypeEnum.STR.getValue().equals(dataType)) {
                if (NumberUtil.parseInt(maxLength) != -1 && StringUtils.length(inputValue) > NumberUtil.parseInt(maxLength)) {
                    log.info("param {} max length is {} ,but inputValue length is {} ,original value is  {}", serviceParam, maxLength, inputValue.length(), inputValue);
                    return false;
                }
            } else if (DataTypeEnum.INT.getValue().equals(dataType)) {
                if (StringUtils.isNotBlank(inputValue) && !NumberUtil.isInteger(inputValue)) {
                    log.info("param {} is int ,but inputValue  is : {}", serviceParam, inputValue);
                    return false;
                }
            } else if (DataTypeEnum.FLOATT.getValue().equals(dataType)) {
                if (StringUtils.isNotBlank(inputValue) && !NumberUtil.isNumber(inputValue)) {
                    log.info("param {} is float ,but inputValue  is : {}", serviceParam, inputValue);
                    return false;
                }
            } else if (DataTypeEnum.BOOL.getValue().equals(dataType)) {
                if (StringUtils.isNotBlank(inputValue) && !Boolean.getBoolean(inputValue)) {
                    log.info("param {} is boolean ,but inputValue  is : {}", serviceParam, inputValue);
                    return false;
                }
            } else if (DataTypeEnum.DATE.getValue().equals(dataType)) {

            }

        }
        return true;
    }

    private static boolean isEnum(String value, String inputValue) {
        List<String> values = Arrays.asList(StringUtils.split(value, ","));
        if (CollectionUtils.containsInstance(values, inputValue)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(Boolean.getBoolean("123"));
    }

}
