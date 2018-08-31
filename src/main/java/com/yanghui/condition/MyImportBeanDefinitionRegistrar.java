package com.yanghui.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.yanghui.bean.Phone;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	/*
	 * AnnotationMetadata:@Import娉ㄨВ绫荤殑娉ㄨВ淇℃伅
	 * BeanDefinitionRegistry:BeanDefinition娉ㄥ唽绫伙紙bean瀹氫箟娉ㄥ唽锛�
	 * BeanDefinitionRegistry.registerBeanDefinition()鏂规硶鎵嬪姩寰�瀹瑰櫒涓敞鍐宐ean
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		boolean personDefinition = registry.containsBeanDefinition("com.yanghui.bean.Person");
		if(personDefinition){
			//鎸囧畾Bean瀹氫箟淇℃伅锛坆ean鐨勭被鍨嬶紝bean鐨勪綔鐢ㄥ煙...etc锛�
			RootBeanDefinition beanDefinition = new RootBeanDefinition(Phone.class);
			//娉ㄥ唽涓�涓猙ean,鎸囧畾bean鍚�
			registry.registerBeanDefinition("phone", beanDefinition);
		}
	}

}
