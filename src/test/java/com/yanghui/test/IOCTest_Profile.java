package com.yanghui.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.yanghui.config.MainConfigOfProfile;

public class IOCTest_Profile {
	
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

	@Test
	public void test01() {
		String[] dataSources = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : dataSources) {
			System.out.println(string);
		}
	}
}
