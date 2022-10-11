package com.myspringmvcproject;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class App extends AbstractAnnotationConfigDispatcherServletInitializer{
	static{
		System.out.println("App loaded...");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses called...");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?>[] carry=new Class[] {ControllerConfig.class};
		return carry;
	}

	@Override
	protected String[] getServletMappings() {
		String[] sarry=new String[] {"/"};
		return sarry;
	}
	
}
 