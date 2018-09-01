package com.yanghui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.yanghui.bean.Person;

@Configuration
//@ComponentScan(basePackages= "com.yanghui.bean")
public class MainConfigOfPropertyValues {
	
	@Bean
	public Person person() {
		return new Person();
	}
}
