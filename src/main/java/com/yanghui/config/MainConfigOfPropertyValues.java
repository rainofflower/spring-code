package com.yanghui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.yanghui.bean.Person;

@Configuration
//@PropertySource读取外部配置文件中的k/v，保存到运行的环境变量中，然后可以使用${}取出
@PropertySource(value= "classpath:person.properties")
@ComponentScan(basePackages= "com.yanghui.bean")
public class MainConfigOfPropertyValues {
	
	@Bean
	public Person person() {
		return new Person();
	}
}
