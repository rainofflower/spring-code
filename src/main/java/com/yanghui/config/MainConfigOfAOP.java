package com.yanghui.config;

import org.springframework.context.annotation.Configuration;

/**
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
 * @author YangHui
 *
 */
@Configuration
public class MainConfigOfAOP {

	
}
