package com.qitf.cas.auth;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.web.flow.CasWebflowConstants;
import org.apereo.cas.web.flow.configurer.AbstractCasWebflowConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.Flow;
import org.springframework.webflow.engine.ViewState;
import org.springframework.webflow.engine.builder.BinderConfiguration;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;

/**
 * 重新定义默认的web流程
 *
 */
public class CustomWebflowConfigurer extends AbstractCasWebflowConfigurer {

    public CustomWebflowConfigurer(FlowBuilderServices flowBuilderServices,
			FlowDefinitionRegistry loginFlowDefinitionRegistry, ApplicationContext applicationContext,
			CasConfigurationProperties casProperties) {
		super(flowBuilderServices, loginFlowDefinitionRegistry, applicationContext, casProperties);
	}
    
	@Override
	protected void doInitialize() {
		  final Flow flow = getLoginFlow();
          bindCredential(flow);
	}
	
	/**
     * 绑定输入信息
     *
     * @param flow
     */
    protected void bindCredential(Flow flow) {
        //重写绑定自定义credential
    	//表单对象，就是这个 credential 
        createFlowVariable(flow, CasWebflowConstants.VAR_ID_CREDENTIAL, UsernamePasswordCodeCredential.class);
        
        //获取登录页
        final ViewState state = (ViewState) flow.getState(CasWebflowConstants.STATE_ID_VIEW_LOGIN_FORM);

        //获取参数绑定对象
        final BinderConfiguration cfg = getViewStateBinderConfiguration(state);
        
        //由于用户名以及密码已经绑定，所以只需对新加系统参数绑定即可
        //参数1 ：字段名
        //参数2 ：转换器
        //参数3 ：是否必须的字段
        cfg.addBinding(new BinderConfiguration.Binding("code", null, false));
    }
}