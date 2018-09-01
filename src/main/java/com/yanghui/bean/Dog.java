package com.yanghui.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Dog implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	public Dog(){
		System.out.println("Dog...Constructor...");
	}
	
	//对象创建并赋值之后调用
	@PostConstruct
	public void init(){
		System.out.println("dog...@PostConstruct...");
	}
	
	//容器移除组件之前调用
	@PreDestroy
	public void destory(){
		System.out.println("dog...@PreDestroy...");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
}
