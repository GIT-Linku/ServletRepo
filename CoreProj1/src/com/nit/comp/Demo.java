package com.nit.comp;

public class Demo {
	private int a = 10,b=20;
	
	public Demo() {
		System.out.println("Demo::0-param constructor");
	}

	@Override
	public String toString() {
		return "Demo [a=" + a + ", b=" + b + "]";
	}

}
