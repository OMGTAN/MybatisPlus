package com.tec.anji.common;

public class test {
	public static void main(String[] args) {
//		A<Dog> a = new A<Dog>();
//		Dog[] dogs = a.get();
		B<Dog> a = new B<Dog>();
		a.put(new Dog());
		Dog dog = a.get();
		dog.eat();
	}
}

class B<E>{
	
	private E e;
	public void put(E e) {
		this.e=e;
	}
	public E get() {
		
		return e;
	}
	
}

class A<E>{
	public E[] get() {
		
		Object[] o = new Object[11];
		E[] e = (E[])o;
		return e;
	}
	
}
