package com;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.LearnService;

public class LearningApp extends Application
{

    private Set<Object> singletons = new HashSet<Object>();
  

    public FormSubmission()
    {

    	singletons.add(new LearnService());
       
    }

    @Override
    public Set<Object> getSingletons()
    {
        return singletons;
    }

   
}
