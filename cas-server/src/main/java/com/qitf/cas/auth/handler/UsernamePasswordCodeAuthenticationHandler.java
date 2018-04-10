package com.qitf.cas.auth.handler;

import com.qitf.cas.auth.UsernamePasswordCodeCredential;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apereo.cas.authentication.Credential;
import org.apereo.cas.authentication.HandlerResult;
import org.apereo.cas.authentication.PreventedException;
import org.apereo.cas.authentication.handler.support.AbstractPreAndPostProcessingAuthenticationHandler;
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
public class UsernamePasswordCodeAuthenticationHandler extends AbstractPreAndPostProcessingAuthenticationHandler {
    private Logger logger = LoggerFactory.getLogger(UsernamePasswordCodeAuthenticationHandler.class);

    public UsernamePasswordCodeAuthenticationHandler(String name, ServicesManager servicesManager, PrincipalFactory principalFactory, Integer order) {
        super(name, servicesManager, principalFactory, order);
    }

//    @Override
//    public boolean preAuthenticate(final Credential credential) {
//        UsernamePasswordCodeCredential sysCredential = (UsernamePasswordCodeCredential) credential;
//        return "8888".equals(sysCredential.getCode());
//    }

    @Override
    public HandlerResult doAuthentication(Credential credential) throws GeneralSecurityException, PreventedException {
        UsernamePasswordCodeCredential sysCredential = (UsernamePasswordCodeCredential) credential;
        //简单点固定验证码8888 即可通过
        System.out.println(">>doAuthentication："+ToStringBuilder.reflectionToString(sysCredential));
        if ("8888".equals(sysCredential.getCode())) {
            System.out.println(">>doAuthentication：登录成功");

            //这里可以自定义属性数据
            return createHandlerResult(credential, this.principalFactory.createPrincipal(((UsernamePasswordCodeCredential) credential).getUsername(), Collections.emptyMap()), null);
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