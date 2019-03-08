/*
 * *******************************************************************************
 * COPYRIGHT
 *               PAX TECHNOLOGY, Inc. PROPRIETARY INFORMATION
 *   This software is supplied under the terms of a license agreement or
 *   nondisclosure agreement with PAX  Technology, Inc. and may not be copied
 *   or disclosed except in accordance with the terms in that agreement.
 *
 *      Copyright (C) 2017 PAX Technology, Inc. All rights reserved.
 * *******************************************************************************
 */
package com.pax.market.api.sdk.java.api.util;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tanjie
 * @date 2018-07-04
 */
import com.google.gson.Gson;
import com.pax.market.api.sdk.java.api.base.dto.SdkObject;
import com.pax.market.api.sdk.java.api.constant.ResultCode;


/**
 * The type Json utils.
 */
public class EnhancedJsonUtils {
	private static final Logger logger = LoggerFactory.getLogger(EnhancedJsonUtils.class);
    private static Gson gson = getGson();

    /**
     * Gets gson.
     *
     * @return the gson
     */
    static /*package*/ Gson getGson() {
        if (gson == null) {
            synchronized (Gson.class) {
                if (gson == null) {
                    gson = new Gson();
                }
            }
        }
        return gson;
    }

    /**
     * 根据javaBean生成Json对象格式字符串
     *
     * @param object 任意javaBean类型对象
     * @return 拼接好的String对象 string
     */
    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * 根据Sdk返回的Json字符串生成Javabean，json字符串封装在data中
     *
     * @param <T>        the type parameter
     * @param sdkJsonStr Json字符串
     * @param clazz      the clazz
     * @return Javabean对象 t
     */
    public static <T> T fromJson(String sdkJsonStr, Class<T> clazz) {
    	logger.debug(sdkJsonStr);
        return gson.fromJson(sdkJsonStr, clazz);
    }

    /**
     * Gets sdk json.
     *
     * @param resultCode the result code
     * @return the sdk json
     */
    public static String getSdkJson(int resultCode) {
        String message = "";
        switch (resultCode) {
            case ResultCode.SDK_PARAM_ERROR:
                message = "16100";
                break;
            case ResultCode.SDK_UNINIT:
                message = "16101";
                break;
            case ResultCode.SDK_DEC_ERROR:
                message = "16102";
                break;
            case ResultCode.SDK_JSON_ERROR:
                message = "16103";
                break;
            case ResultCode.SDK_CONNECT_TIMEOUT:
                message = "16104";
                break;
            case ResultCode.SDK_UN_CONNECT:
                message = "16105";
                break;
            case ResultCode.SDK_RQUEST_EXCEPTION:
                message = "16106";
                break;
            case ResultCode.SDK_UNZIP_FAILED:
                message = "16107";
                break;
            case ResultCode.SDK_MD_FAILED:
                message = "16108";
                break;
            case ResultCode.SDK_REPLACE_VARIABLES_FAILED:
                message = "16109";
                break;
            case ResultCode.SDK_INIT_FAILED:
                message = "16110";
                break;
            case ResultCode.SDK_FILE_NOT_FOUND:
                message = "16111";
                break;

        }
        message = MessageBoudleUtil.getMessage(message, Locale.getDefault());
        return getSdkJson(resultCode, message);
    }

    /**
     * Gets sdk json.
     *
     * @param resultCode the result code
     * @param message    the message
     * @return the sdk json
     */
    public static String getSdkJson(int resultCode, String message) {
        SdkObject sdkObject = new SdkObject();
        sdkObject.setBusinessCode(resultCode);
        sdkObject.setMessage(message);
        return toJson(sdkObject);
    }
}