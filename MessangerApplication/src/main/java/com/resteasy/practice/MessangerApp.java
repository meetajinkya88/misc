package com.resteasy.practice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.resteasy.practice.resources.CommentResource;
import com.resteasy.practice.resources.InjectDemoResource;
import com.resteasy.practice.resources.MessageResource;
import com.resteasy.practice.resources.ProfileResource;

public class MessangerApp  extends Application
{
	private Set<Object> singletons = new HashSet<Object>();


	public MessangerApp()
	{

		instantiateRestResources();
	}


	private void instantiateRestResources() 
	{		
		singletons.add(new MyResource());
		singletons.add(new MessageResource());
		singletons.add(new CommentResource());
		singletons.add(new InjectDemoResource());
		singletons.add(new ProfileResource());


	}
	public Set<Object> getSingletons()
	{
		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses()
	{
		return null;
	}
}
