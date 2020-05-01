package com.alacriti.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class FreeMarkerIVRTest
{

	public static void main(String[] args)
	{

		try
		{
				
			// Configurae Freemarker
			Configuration cfg = new Configuration();
		//    cfg.setClassForTemplateLoading(FreeMarkerIVRTest.class, "templates");
		    cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		    cfg.setDefaultEncoding("UTF-8");
		    cfg.setLocale(Locale.US);
		    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			// Load the template
			Template template = cfg.getTemplate("templates/sampleVxml.ftl");

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("welcomeMessage", "Hello Sir , Welcome to IVR system!");
            data.put("customerMessage","Please enter your customer identification number using your keypad.");
			data.put("enterAgeMessage","Please enter your age using your keypad.");
			
			List<IVROption> ivrOptions = new ArrayList<IVROption>();
			ivrOptions.add(new IVROption(1,"Autheticate Customer"));
			ivrOptions.add(new IVROption(2,"Add Funding Source"));
			ivrOptions.add(new IVROption(3,"Make Payment"));
			ivrOptions.add(new IVROption(4,null));

			data.put("ivrOptions", ivrOptions);

			String vxml = processData(template,data);
			//process the template
		
			System.out.println("Final Vxml is --> \n" + vxml);

		
			Writer fileWriter = new FileWriter(new File("output/FreeMarkerIVRTestOutput.vxml"));
			try
			{
				template.process(data, fileWriter);
			} finally
			{
				fileWriter.close();
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage() + e );
			e.printStackTrace();
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage()+ e);
			e.printStackTrace();
		}
	}

	private static String processData(Template template, Map<String, Object> data)
	{		
		Writer out = new StringWriter();

		try
		{
			template.process(data, out);
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
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}