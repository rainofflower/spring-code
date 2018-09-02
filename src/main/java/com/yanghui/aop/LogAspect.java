package com.yanghui.aop;

import org.aspectj.lang.annotation.Before;

public class LogAspect {

	@Before("public int com.yanghui.aop.MathCalculator.div(int, int)")
	public void logStart(){
		System.out.println("除法运行---->参数列表：{}");
	}
	
	public void logEnd(){
		System.out.println("除法结束");
	}
	
	public void logReturn(){
		System.out.println("除法正常返回---->返回结果：{}");
	}
	
	public void logException(){
		System.out.println("除法异常---->异常信息：{}");
	}
}
