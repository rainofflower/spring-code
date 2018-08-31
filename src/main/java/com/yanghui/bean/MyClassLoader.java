package com.yanghui.bean;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 自定义类加载器
 * 
 * 自定义类加载器可突破默认类加载器加载的类文件范围
 * 利用java的类加载机制动态地（程序运行中）将指定class文件加载到JVM中
 * 
 * 可指定通过网络获取的class文件，本地任何位置的class文件
 * 
 * @see 类加载器与反射的区别：
 * 反射是由 AppClassLoader->ExtClassLoader->BootStrapClassLoader 委派机制加载而来的,一般是AppClassLoader加载
 * 而使用自定义类加载器是由 自定义ClassLoader->AppClassLoader->ExtClassLoader->BootStrapClassLoader 加载而来
 * @author yanghui
 *
 */
public class MyClassLoader extends ClassLoader{

	private static final String drive = "D:/workspace/";
	private static final String fileType = ".class";
	
	public byte[] loadClassData(String name) throws ClassNotFoundException{
		FileInputStream fis = null;
		byte[] data = null;
		try {
			fis = new FileInputStream(new File(drive + name + fileType));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int ch = 0;
			while((ch = fis.read())!=-1) {
				baos.write(ch);
			}
			data = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 注意:要加载的目标.class文件是来自没有package头的java文件编译而来
	 * 若包含package,则defineClass中的第一个参数需要加上包名（命名空间）
	 * 例如：com.yanghui.HelloWorld 
	 * 其中com.yanghui是写在java文件中的包名
	 * HelloWorld是类名
	 */
	public Class<?> findClass(String name) throws ClassNotFoundException{
		byte[] data = loadClassData(name);
		return defineClass(name, data, 0, data.length); // 将一个 byte 数组转换为 Class 类的实例
	}
	
	public static void main(String[] args) throws Exception{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		System.out.println("current ClassLoader ====> " + classLoader);
		System.out.println("parent classLoader ====> " + classLoader.getParent());
		System.out.println("grandparent classLoader ===> " + classLoader.getParent().getParent());
		MyClassLoader loader = new MyClassLoader();
		System.out.println("current ClassLoader ====> " + loader);
		System.out.println("parent classLoader ====> " + loader.getParent());
		System.out.println("grandparent classLoader ===> " + loader.getParent().getParent());
		Class<?> loadClass = loader.loadClass("HelloWorld",true);
		Object obj = loadClass.newInstance();
		System.out.println(loadClass.getName());
		System.out.println(loadClass.getClassLoader());
		System.out.println(obj.getClass().toString());
		Method[] declaredMethods = loadClass.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName());
		}
		System.out.println("--------------------------------");
		Method method1 = loadClass.getMethod("init");
		method1.invoke(obj);
		Method method2 = loadClass.getMethod("printMessage");
		method2.invoke(obj);
		Field field = loadClass.getDeclaredField("name");
		field.setAccessible(true);
		field.set(obj, "yanghui");	
		method2.invoke(obj);
		System.out.println("---------------------------------");
		Class<?> clazz = Class.forName("com.yanghui.bean.HelloWorld");
		System.out.println(clazz.getName());
		System.out.println(clazz==loadClass);
		System.out.println(clazz.getClassLoader());
	}
}
