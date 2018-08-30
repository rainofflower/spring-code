package com.yanghui.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.yanghui.bean.Phone;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	/*
	 * AnnotationMetadata:@Import注解类的注解信息
	 * BeanDefinitionRegistry:BeanDefinition注册类（bean定义注册）
	 * BeanDefinitionRegistry.registerBeanDefinition()方法手动往容器中注册bean
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		boolean personDefinition = registry.containsBeanDefinition("com.yanghui.bean.Person");
		if(personDefinition){
			//指定Bean定义信息（bean的类型，bean的作用域...etc）
			RootBeanDefinition beanDefinition = new RootBeanDefinition(Phone.class);
			//注册一个bean,指定bean名
			registry.registerBeanDefinition("phone", beanDefinition);
		}
	}

}
