package com.alacriti.freemarker;

public class IVROption
{
	private int option;
	private String optionMessage;
	
	public IVROption(int option , String optionMessage)
	{
		this.option = option;
		this.optionMessage = optionMessage;
	}
	public int getOption()
	{
		return option;
	}
	public void setOption(int option)
	{
		this.option = option;
	}
	public String getOptionMessage()
	{
		return optionMessage;
	}
	public void setOptionMessage(String optionMessage)
	{
		this.optionMessage = optionMessage;
	}
	
	

}
