package com.alacriti.freemarker3;

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

public class FreeMarkerTest3
{
	private Configuration cfg = null;
	private Template template = null;

	public static void main(String[] args)
	{

		try
		{
			
			FreeMarkerTest3 ft = new FreeMarkerTest3();
			
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
		
		Template template = cfg.getTemplate("/Workspace_Practice/FreeMarkerTest/templates/ftlTest3.ftl");

		Map<String, Object> data = new HashMap<String, Object>();
		List<List<String>> countryCapitalOuterList = new ArrayList<List<String>>();

		List<String> countryCapitalList1 = new ArrayList<String>();
		countryCapitalList1.add("United States, Washington DC");
		countryCapitalList1.add("India , Delhi");
		
		
		List<String> countryCapitalList2 = new ArrayList<String>();
		countryCapitalList2.add("Germany,Berlin");
		countryCapitalList2.add("France,Paris");
		countryCapitalList2.add("Italy,Rome");
		  
		countryCapitalOuterList.add(countryCapitalList1);
		countryCapitalOuterList.add(countryCapitalList2);

	
		data.put("countryCapitalOuterList", countryCapitalOuterList);

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
