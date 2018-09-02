package com.yanghui.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.yanghui.bean.Blue;
import com.yanghui.bean.Color;
import com.yanghui.bean.Person;
import com.yanghui.config.MainConfig;
import com.yanghui.config.MainConfig2;

public class IOCTest {

	//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
	
	/*@Test
	public void testImport(){
		printBeans(applicationContext);
		Blue bean = applicationContext.getBean(Blue.class);
		System.out.println(bean);
		
		Object bean2 = applicationContext.getBean("phoneFactoryBean");
		System.out.println(bean2);
		Object bean3 = applicationContext.getBean("phoneFactoryBean");
		System.out.println(bean2 == bean3);
		Object bean4 = applicationContext.getBean("&phoneFactoryBean");
		System.out.println(bean4);
	}*/
	
	private void printBeans(ApplicationContext applicationContext){
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}
	
	@Test
	public void test04(){
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
		String[] names = classPathXmlApplicationContext.getBeanNamesForType(Person.class);
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		System.out.println(classPathXmlApplicationContext.getBeanDefinitionCount());
		printBeans(classPathXmlApplicationContext);
		System.out.println(classPathXmlApplicationContext.getBeansOfType(Person.class));
		/*Environment environment = classPathXmlApplicationContext.getEnvironment();
		String port = environment.getProperty("server.port");
		System.out.println(port);
		System.out.println(environment);*/
	}
	
	/*@Test
	public void test03(){
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		Environment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println(property);
		
		for (String name : beanNamesForType) {
			System.out.println(name);
		}
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		System.out.println(persons);
		System.out.println("---------------");
		printBeans(applicationContext);
	}*/
	
	@Test
	public void test02(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		/*String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		*/
		System.out.println("ioc容器创建完成...");
		Object bean = applicationContext.getBean("person");
		Object bean2 = applicationContext.getBean("person");
		System.out.println(bean == bean2);
	}
	
	@Test
	public void test01(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
