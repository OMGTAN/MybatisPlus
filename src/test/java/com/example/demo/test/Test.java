package com.example.demo.test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;
 
public class Test {
 
	public static void main(String[] args) {
 
		//接口
		SayService sayService = new SayServiceImpl();
		//织入类
		WavingInvocationHandler handler = new WavingInvocationHandler();
		handler.setTarget(sayService);
		//代理类--增强的对象
		SayService s = (SayService) Proxy.newProxyInstance(
				sayService.getClass().getClassLoader(),
				sayService.getClass().getInterfaces(), handler);
 
		s.say("say()");//执行代理对象完成业务
		/**
		 方法执行之前！
		 say()
		 方法执行之后！
		 */
 
		//将jdk中生成代理类输出到本地.Class文件，之后可以通过反编译软件打开查看
//		createProxyClassFile("test12345",sayService.getClass().getInterfaces());
 
	}
 
	private static void createProxyClassFile(String name,Class<?> [] interfaces){
		byte[] data = ProxyGenerator.generateProxyClass(name,interfaces);//该方法为jdk中生成代理类的核心方法
		FileOutputStream out =null;
		try {
			out = new FileOutputStream(name+".class");
			System.out.println((new File(name)).getAbsolutePath());
			out.write(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(null!=out) try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}