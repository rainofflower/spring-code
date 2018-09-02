package com.yanghui.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.yanghui.config.MainConfigOfProfile;

public class IOCTest_Profile {
	

	@Test
	public void test01() {
		//1.创建一个applicationContext
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		//2.设置要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("dev");
		//3.注册主配置类
		applicationContext.register(MainConfigOfProfile.class);
		//4.刷新容器
		applicationContext.refresh();
		
		String[] dataSources = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : dataSources) {
			System.out.println(string);
		}
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
		MainConfigOfProfile bean = (MainConfigOfProfile) applicationContext.getBean("mainConfigOfProfile");
		System.out.println(bean);
	}
}
