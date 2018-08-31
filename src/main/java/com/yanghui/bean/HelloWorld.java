package com.yanghui.bean;

public class HelloWorld {
	
	private String name;
	private String message;
	
	public void init() {
		setName("Java");
		setMessage("HelloWorld");
	}
	
	public void printMessage() {
		System.out.println("name: " + name + "/n" + "message: " + message);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
