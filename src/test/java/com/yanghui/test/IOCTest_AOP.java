package com.yanghui.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yanghui.aop.MathCalculator;
import com.yanghui.config.MainConfigOfAOP;

public class IOCTest_AOP {
	
	
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		
		//不要自己创建对象
		MathCalculator mathCalculator = new MathCalculator();
		mathCalculator.div(1, 1);
		
		MathCalculator bean = applicationContext.getBean(MathCalculator.class);
		bean.div(1, 0);
		
	}
}
