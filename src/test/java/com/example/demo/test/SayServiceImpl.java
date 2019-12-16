package com.example.demo.test;
public class SayServiceImpl implements SayService{
 
	@Override
	public void say(String name) {
		System.out.println(name);
	}
}