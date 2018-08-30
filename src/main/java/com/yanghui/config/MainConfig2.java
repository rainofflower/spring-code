package com.yanghui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.yanghui.bean.Color;
import com.yanghui.bean.Person;
import com.yanghui.bean.PhoneFactoryBean;
import com.yanghui.bean.Size;
import com.yanghui.condition.LinuxCondition;
import com.yanghui.condition.MyImportBeanDefinitionRegistrar;
import com.yanghui.condition.MyImportSelector;
import com.yanghui.condition.WindowsCondition;

@Conditional(value = { WindowsCondition.class })
@Configuration
@Import(value = { Color.class,Size.class,Person.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class })//@Import导入组件，id默认为组件的全类名
public class MainConfig2 {

	/**
	 * ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * 
	 * 
	 * @Scope:调整作用域
	 * prototype:多实例的: ioc容器启动并不会调用方法创建对象放到容器中，
	 * 			每次获取的时候才会调用方法创建对象
	 * singleton:单实例的（默认值）: ioc容器启动会调用方法创建对象放到ioc容器中，
	 * 			以后每次获取就是直接从容器中（map.get()）拿
	 * request：同一次请求创建一个实例
	 * session:同一个session创建一个实例
	 * 
	 * 懒加载：
	 * 		单实例bean:默认在容器启动的时候创建对象
	 * 		懒加载，容器启动不创建对象，第一次使用（获取）bean时创建对象，并初始化
	 */
	//@Scope("prototype")
	/*@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("给IOC容器中添加Person...");
		return new Person("张三",25);
	}*/
	
	/**
	 * @Conditional:按照一定条件进行判断，满足条件给容器中注册bean
	 * 
	 */
	@Conditional(value = { WindowsCondition.class })
	@Bean("bill")
	public Person person01(){
		System.out.println("给IOC容器中添加Bill...");
		return new Person("Bill Gates",62);
	}
	
	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person02(){
		System.out.println("给IOC容器中添加linus...");
		return new Person("linus",48);
	}
	
	/**
	 * 给容器中注册组件
	 * 1.包扫描+组件标注注解（@Component,@Repository,@Service,@Controller）
	 * 2.@Bean导入的第三方包里的组件
	 * 3.@Import快速给容器中导入组件
	 * 	1)@Import(要导入到容器中的组件)
	 * 	2)ImportSelector：返回需要导入的组件的全类名数组
	 * 	3)ImportBeanDefinitionRegistrar：手动注册bean
	 * 4.使用Spring提供的FactoryBean<T>
	 * 	1)默认获取的是工厂bean调用getObject方法创建的对象
	 * 	2)要获取bean工厂本身，需要在id 前加上&符 如：&phoneFactoryBean
	 * 
	 */
	@Bean
	public PhoneFactoryBean phoneFactoryBean(){
		return new PhoneFactoryBean();
	}
	
}
