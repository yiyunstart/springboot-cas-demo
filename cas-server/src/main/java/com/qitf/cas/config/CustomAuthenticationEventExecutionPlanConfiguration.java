package com.qitf.cas.config;

import com.qitf.cas.auth.handler.CustomAuthenticationHandler;
import com.qitf.cas.auth.handler.UsernamePasswordCodeAuthenticationHandler;
import org.apereo.cas.adaptors.rest.RestAuthenticationApi;
import org.apereo.cas.adaptors.rest.RestAuthenticationHandler;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlan;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlanConfigurer;
import org.apereo.cas.authentication.AuthenticationHandler;
import org.apereo.cas.authentication.principal.DefaultPrincipalFactory;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.services.ServicesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 注册验证器到springboot中
 */
@Configuration("customAuthenticationEventExecutionPlanConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class CustomAuthenticationEventExecutionPlanConfiguration implements AuthenticationEventExecutionPlanConfigurer {
    @Autowired
    @Qualifier("servicesManager")
    private ServicesManager servicesManager;

    @Autowired
    @Qualifier("restAuthenticationApi")
    private RestAuthenticationApi  restAuthenticationApi;
    /**
     * 注册验证器
     *
     * @return
     */
    @Bean
    public AuthenticationHandler customAuthenticationHandler() {
        //优先验证
        return new RestAuthenticationHandler("customAuthenticationHandler",restAuthenticationApi,
                servicesManager, new DefaultPrincipalFactory());
    }

    //注册自定义认证器
    @Override
    public void configureAuthenticationExecutionPlan(final AuthenticationEventExecutionPlan plan) {
        plan.registerAuthenticationHandler(customAuthenticationHandler());
    }
}