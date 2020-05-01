package com.practice.intrfc.defaultMethod;

public interface interface2
{
	public void method1(String str);
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}
}
