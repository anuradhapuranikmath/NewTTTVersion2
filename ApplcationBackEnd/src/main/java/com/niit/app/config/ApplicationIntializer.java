package com.niit.app.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationIntializer 
	 extends AbstractAnnotationConfigDispatcherServletInitializer {

		@Override
		protected Class<?>[] getRootConfigClasses() {
			// TODO Auto-generated method stub
			return new Class[]{Webconfig.class,AppDataBaseConfig.class};
		}

		@Override
		protected Class<?>[] getServletConfigClasses() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected String[] getServletMappings() {
			// TODO Auto-generated method stub
			return new String[]{"/"};
		}
		
		@Override
		protected Filter[] getServletFilters() {
			Filter[] singleton = { new CorsFilter() };
			return singleton;
		}


	}

