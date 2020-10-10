package com.zj.oauth.config;

/**
 * @author 000062064
 * @title: IntegrationAuthenticationContext
 * @description: 认证上下文
 */
public class IntegrationAuthenticationContext {
    private static ThreadLocal<IntegrationAuthentication> holder = new ThreadLocal<>();

    public static void set(IntegrationAuthentication integrationAuthentication){
        holder.set(integrationAuthentication);
    }

    public static IntegrationAuthentication get(){
        return holder.get();
    }

    public static void clear(){
        holder.remove();
    }

}
