package com.yanghui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.yanghui.bean.Person;
import com.yanghui.service.BookService;

//该注解告诉Spring该类是一个配置类
@Configuration
@ComponentScans(value={
		@ComponentScan(value="com.yanghui"
		,includeFilters={
		/*@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
		@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),*/
		@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
		}
		,useDefaultFilters=false)
		})
//@ComponentScans value:指定要扫描的包
//excludeFilters = Filter[]:指定扫描的时候按照什么规则包含哪些组件
//includeFilters = Filter[]:指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION: 按照注解过滤
//FilterType.ASSIGNABLE_TYPE:按照给定类型
//FilterType.ASPECTJ:使用ASPECTJ表达式
//FilterType.REGEX:使用正则表达式指定
//FilteType.CUSTOM:使用自定义规则
public class MainConfig {

	//给容器注册一个bean；类型为返回值类型；id默认为方法名
	@Bean("person")
	public Person person(){
		return new Person("lisi",20);
	}
}
