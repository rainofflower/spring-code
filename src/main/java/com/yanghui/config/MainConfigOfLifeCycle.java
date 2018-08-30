package com.yanghui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.yanghui.bean.Car;

/**
 * bean����������
 *  bean����--��ʼ��--����
 *  ��������bean����������
 * @author Administrator
 * 
 * ָ����ʼ�������ٷ�������������ǰ�������ڿ��Ե����Զ����ʼ�������ٷ���
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
