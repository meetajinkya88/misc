package com.practice.intrfc.defaultMethod;

public interface interface1 
{
	public void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static boolean isNull(String str)
	{
		return str == null;
	}
}
