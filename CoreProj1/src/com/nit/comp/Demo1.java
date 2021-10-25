package com.nit.comp;

public class Demo1 {
	private int a = 10,b=20;
	
	public Demo1() {
		System.out.println("Demo1::0-param constructor");
	}
	public Demo1(int a,int b) {
		this.a= a;
		this.b= b;
		System.out.println("Demo1::2-param constructor");
	}

	@Override
	public String toString() {
		return "Demo1 [a=" + a + ", b=" + b + "]";
	}

}
