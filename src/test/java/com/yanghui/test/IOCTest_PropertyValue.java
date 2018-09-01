package com.yanghui.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yanghui.bean.Person;
import com.yanghui.config.MainConfigOfPropertyValues;

public class IOCTest_PropertyValue {
	
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
	
	@Test
	public void test01() {
		printBeans(applicationContext);	
		
		System.out.println("--------------------");
		
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		//关闭容器
		applicationContext.close();
	}
	
	private void printBeans(ApplicationContext applicationContext){
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}
}
