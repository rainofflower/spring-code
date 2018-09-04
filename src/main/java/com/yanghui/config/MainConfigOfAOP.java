package com.yanghui.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.yanghui.aop.LogAspect;
import com.yanghui.aop.MathCalculator;

/**
 * 
 * @author YangHui
 * 
 * AOP: 【动态代理】
 * 		在程序的运行期间动态地将某段代码切入到指定方法的指定位置进行运行的编码方式
 * 
 * 1、导入AOP模块
 * 2、定义一个业务逻辑类MathCalculator
 * 3、定义一个切面类LogAspect
 * 		通知方法
 * 			前置通知(@Before):logStart
 * 			后置通知(@After):logEnd
 * 			返回通知(@AfterReturning):logReturn
 * 			异常通知(@AfterThrowing):logException
 * 			环绕通知(@Around):动态代理，手动推进目标方法运行(joinPoint.procced())
 * 4、给切面类的目标方法标注何时何地运行(标注通知注解)
 * 5、将切面类和业务逻辑类（目标方法所在类）都加入到容器中
 * 6、必须告诉spring哪个类是切面类（给切面类加一个注解@Aspect）
 * 7、给配置类加@EnableAspectJAutoProxy，开启基于注解的aop模式
 * 
 * 	-->在Spring中有很多的@EnableXXX,表示开启某一项功能
 * 
 * AOP三步：
 * 1.将业务逻辑组件和切面类都加入到容器中，告诉Spring哪个是切面类（@Aspect）
 * 2.在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 * 3.开启基于注解的aop模式 @EnableAspectJAutoProxy
 * 
 *	AOP原理
 *		
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.yanghui.aop")
public class MainConfigOfAOP {

	@Bean
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}
	
	@Bean
	public LogAspect logAspect() {
		return new LogAspect();
	}
	
}
