package com.qitf.config;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.web.flow.CasWebflowConfigurer;
import org.apereo.cas.web.flow.config.CasWebflowContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;

import com.qitf.auth.CustomWebflowConfigurer;

/**
 重新定义默认的web流程
 */
@Configuration("customerAuthWebflowConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
@AutoConfigureBefore(value = CasWebflowContextConfiguration.class)
public class CustomerAuthWebflowConfiguration {
	@Autowired
	private CasConfigurationProperties casProperties;
	
	@Autowired
	@Qualifier("loginFlowRegistry")
	private FlowDefinitionRegistry loginFlowRegistry;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private FlowBuilderServices flowBuilderServices;

	/**
	 * 注册我们的表单到服务器上
	 * @return
	 */
	@Bean
	public CasWebflowConfigurer customWebflowConfigurer() {
		//实例化自定义的表单配置类
		final CustomWebflowConfigurer c = new CustomWebflowConfigurer(flowBuilderServices, loginFlowRegistry,
				applicationContext, casProperties);
		//初期化
		c.initialize();
		//返回对象
		return c;
	}
}