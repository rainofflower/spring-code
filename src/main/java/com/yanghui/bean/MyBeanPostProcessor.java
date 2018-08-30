package com.yanghui.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器
 * @author YangHui
 *
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor{
	
	public MyBeanPostProcessor() {
		System.out.println("MyBeanPostProcessor...Constructor....");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("MyBeanPostProcessor...init...");
	}
	
	@PreDestroy
	public void destory(){
		System.out.println("MyBeanPostProcessor...destory...");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

}
