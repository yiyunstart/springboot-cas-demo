package com.qitf.cas.auth.handler;

import com.qitf.cas.auth.UsernamePasswordCodeCredential;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apereo.cas.adaptors.rest.RestAuthenticationApi;
import org.apereo.cas.adaptors.rest.RestAuthenticationHandler;
import org.apereo.cas.authentication.Credential;
import org.apereo.cas.authentication.HandlerResult;
import org.apereo.cas.authentication.PreventedException;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.AccountNotFoundException;
import java.security.GeneralSecurityException;
import java.util.Collections;

/**
 * 验证码认证
 */
public class CustomAuthenticationHandler extends RestAuthenticationHandler {
    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationHandler.class);

    public CustomAuthenticationHandler(String name, RestAuthenticationApi api, ServicesManager servicesManager, PrincipalFactory principalFactory) {
        super(name, api,servicesManager, principalFactory);
    }


    @Override
    public HandlerResult doAuthentication(Credential credential) throws GeneralSecurityException, PreventedException {
        UsernamePasswordCodeCredential sysCredential = (UsernamePasswordCodeCredential) credential;
        //简单点固定验证码8888 即可通过
        System.out.println(">>doAuthentication："+ToStringBuilder.reflectionToString(sysCredential));
        if ("8888".equals(sysCredential.getCode())) {
            System.out.println(">>doAuthentication：登录成功");
            return  super.doAuthentication(credential);
        } else {
            System.out.println(">>doAuthentication：登录失败");
            throw new AccountNotFoundException();
        }

    }


    @Override
    public boolean supports(Credential credential) {
        logger.info(">>supports:"+ToStringBuilder.reflectionToString(credential));
        logger.info(">>supports:"+String.valueOf(credential instanceof UsernamePasswordCodeCredential));
        return credential instanceof UsernamePasswordCodeCredential;
    }
}