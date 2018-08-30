package com.yanghui.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.yanghui.bean.Blue;
import com.yanghui.bean.Yellow;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector{

	//返回值，就是导入到容器中的组件全类名
	//AnnotationMetadata：当前标注@Import注解的类的所有注解信息
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		String blueClass = Blue.class.getName();
		String yellowClass = Yellow.class.getName();
		//importingClassMetadata.
		//方法返回null之后处理过程中会抛出异常，因此为空应该返回空数组
		return new String[]{blueClass,yellowClass};
	}

}
