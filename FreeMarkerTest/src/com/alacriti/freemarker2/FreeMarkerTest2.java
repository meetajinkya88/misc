package com.alacriti.freemarker2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.alacriti.freemarker.IVROption;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class FreeMarkerTest2
{
	private Map<String, String> countryCapitalList = new HashMap<String, String>();
	private Configuration cfg = null;
	private Template template = null;

	public static void main(String[] args)
	{

		try
		{
			
			FreeMarkerTest2 ft = new FreeMarkerTest2();
			
			ft.setConfig();
	
			ft.transform();
			// Load the template
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage()+ e);
			e.printStackTrace();
		}
	}

	private void transform() throws IOException, TemplateException
	{
	//	Template template = cfg.getTemplate("templates/ftlTest2.ftl");
		
		Template template = cfg.getTemplate("/Workspace_Practice/FreeMarkerTest/templates/ftlTest2.ftl");

		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, String> countryCapitalList = new HashMap<String, String>();
		countryCapitalList.put("United States", "Washington DC");
		countryCapitalList.put("India", "Delhi");
		countryCapitalList.put("Germany", "Berlin");
		countryCapitalList.put("France", "Paris");
		countryCapitalList.put("Italy", "Rome");
		  
	
		data.put("countryCapitalList", countryCapitalList);

		String vxml = processData(template,data);
		//process the template
	
	//	System.out.println("Final Vxml is --> \n" + vxml);

	
		Writer fileWriter = new FileWriter(new File("output/FreeMarkerIVRTestOutput.vxml"));
		try
		{
			template.process(data, fileWriter);
		} finally
		{
			fileWriter.close();
		}
		
	}

	private void setConfig() throws IOException
	{
		// Configure Freemarker
		 cfg = new Configuration();
	//    cfg.setClassForTemplateLoading(FreeMarkerIVRTest.class, "templates");
		 
		 cfg.setDirectoryForTemplateLoading(new File("/home/ajinkyab"));
	    cfg.setIncompatibleImprovements(new Version(2, 3, 20));
	    cfg.setDefaultEncoding("UTF-8");
	    cfg.setLocale(Locale.US);
	    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		
	}

	private static String processData(Template template, Map<String, Object> data)
	{		
		StringWriter out = new StringWriter();
	 

		try
		{
		
			template.process(data, out);
			System.out.println("Printing buffer1:-->" +out.toString());
			out.getBuffer().setLength(0);;			
			template.process(data, out);
			
			System.out.println("Printing buffer2:-->" + out.toString());
		
			return out.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				out.flush();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
