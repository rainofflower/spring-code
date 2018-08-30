package com.yanghui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.yanghui.bean.Car;

/**
 * bean的生命周期
 *  bean创建--初始化--销毁
 *  容器管理bean的生命周期
 * @author Administrator
 * 
 * 指定初始化和销毁方法，容器到当前生命周期可以调用自定义初始化和销毁方法
 *	init-method="" destroy-method=""
 *
 */
@Configuration
@ComponentScan("com.yanghui.bean")
//@Import({Car.class})
public class MainConfigOfLifeCycle {

	//@Scope("prototype")
	@Bean(initMethod="init",destroyMethod="destory")
	public Car car() {
		return new Car();
	}
}
