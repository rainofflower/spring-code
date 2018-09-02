package com.yanghui.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
	
	/**
	 * 使用@Value赋值
	 * 1.基本类型值
	 * 2.可以写SpEL：#{ }
	 * 3.可以写${},取出配置文件中的值（其实就是在运行环境变量Environment对象里面的值，
	 * 		可取出环境变量然后调用getProperty("name")获取）
	 */
	
	@Value("${topic.park.carServiceInfo}") //500 Hundred Mails
	private String name;
	
	@Value("#{19-2}")
	private Integer age;
	
	@Value("${person.nickName}")
	private String nickName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nickName=" + nickName + "]";
	}
	
	
}
