package com.mongodb;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerApp {
	
	public static void main(String[] args) throws Exception {
		String templateFileName = "hello.ftl";
		HashMap<String, Object> dataModel = new HashMap<>();
		dataModel.put("name", "Geraaaldo");
		
		String string = createHtml(templateFileName, dataModel);
		
		System.out.println(string);
	}

	public static String createHtml(String templateFileName, HashMap<String, Object> dataModel)
			throws IOException, TemplateException {
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(FreemarkerApp.class, "/");
		Template template = configuration.getTemplate(templateFileName);
		
		StringWriter stringWriter = new StringWriter();
		template.process(dataModel, stringWriter);
		
		String string = stringWriter.toString();
		return string;
	}
	
	
	
}
