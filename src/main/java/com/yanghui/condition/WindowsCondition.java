package com.yanghui.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		
		ClassLoader classLoader = context.getClassLoader();
		
		BeanDefinitionRegistry registry = context.getRegistry();
		boolean containsBeanDefinition = registry.containsBeanDefinition("person");
		
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");
		if(property.contains("Windows")){
			return true;
		}
		return false;
	}

}
