package com.example.demo.test;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
 
public class WavingInvocationHandler  implements InvocationHandler{
 
	private Object target;
 
	public void setTarget(Object target) {
		this.target = target;
	}
 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("方法执行之前！");
		Object obj = method.invoke(target, args);
		System.out.println("方法执行之后！");
		return obj;
	}
}