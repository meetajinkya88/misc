package com.practice.intrfc.defaultMethod;

public class DefaultMethodClass implements interface1,interface2
{

	@Override
	public void method1(String str) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(String str) 
	{
		System.out.println("Concrete class logging::"+str);
	}

}
