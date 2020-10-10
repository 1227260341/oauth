package com.zj.oauth.config;

import lombok.Data;

import java.util.Map;

/**
 * @description: 认证实体（主要作为存认证的用户信息等数据）
 */
@Data
public class IntegrationAuthentication {
    private String authType;
    private String username;
    private String platform; // 平台：标识
    private Map<String,String[]> authParameters;//request 的请求请求参数

    public String getAuthParameter(String paramter){
        String[] values = this.authParameters.get(paramter);
        if(values != null && values.length > 0){
            return values[0];
        }
        return null;
    }

}
