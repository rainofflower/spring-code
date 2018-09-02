package com.yanghui.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class Color implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware{

	private ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("传入IOC："+applicationContext);
		this.applicationContext = applicationContext;
	}

	public void setBeanName(String name) {
		System.out.println("当前bean的名字"+name);
	}

	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String resolveStringValue = resolver.resolveStringValue("你好${person.nickName},我是#{10+12}");
		System.out.println(resolveStringValue);
	}

}
