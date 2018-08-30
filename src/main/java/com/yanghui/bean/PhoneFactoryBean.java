package com.yanghui.bean;

import org.springframework.beans.factory.FactoryBean;

public class PhoneFactoryBean implements FactoryBean<Phone>{

	@Override
	public Phone getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Phone();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Phone.class;
	}

	//是否单例
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
