package com.yanghui.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * @author Administrator
 *
 *	@Aspect:告诉spring当前类是切面类
 */
@Component
@Aspect
public class LogAspect {

	/*
	 * 抽取出公共的切入点表达式
	 * 1.本类引用直接写切入点方法名加小括号()-->"pointCut()"
	 * 2.其他的切面引用需写切入点方法全名-->"com.yanghui.aop.LogAspect.pointCut()"
	 */
	@Pointcut("execution(public int com.yanghui.aop.MathCalculator.*(..))")
	public void pointCut() {}
	
	//@Before在目标方法之前切入，value为切入点表达式，用来指定在哪个方法切入
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println("@Before除法"+joinPoint.getSignature().getName()+"运行---->参数列表：{"+Arrays.asList(args)+"}");
	}
	
	@After("com.yanghui.aop.LogAspect.pointCut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println("@After除法"+joinPoint.getSignature().getName()+"结束");
	}
	
	//参数表里有JoinPoint时，joinPoint一定要放在最前面，否则会报错
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result){
		System.out.println("@AfterReturning除法"+joinPoint.getSignature().getName()+"正常返回---->返回结果：{"+result+"}");
	}
	
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logException(JoinPoint joinPoint,Exception exception){
		System.out.println("@AfterThrowing除法"+joinPoint.getSignature().getName()+"异常---->异常信息：{"+exception+"}");
	}
}
