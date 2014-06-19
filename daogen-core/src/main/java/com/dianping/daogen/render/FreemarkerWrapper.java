package com.dianping.daogen.render;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;

/**
 * @author code4crafer@gmail.com
 */
public class FreemarkerWrapper {

	private Configuration configuration;

	private FreemarkerWrapper() {
		initTemplate();
	}

	private void initTemplate() {
		configuration = new Configuration();
		configuration.setTemplateLoader(new ClassTemplateLoader(getClass(), "/"));
	}

	public Template getTemplate(String name) {
		try {
			return configuration.getTemplate(name);
		} catch (IOException e) {
            e.printStackTrace();
			return null;
		}
	}

	private final static FreemarkerWrapper INSTANCE = new FreemarkerWrapper();

	public static FreemarkerWrapper getInstance() {
		return INSTANCE;
	}
}
