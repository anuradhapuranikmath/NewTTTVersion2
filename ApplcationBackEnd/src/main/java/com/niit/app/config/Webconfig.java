package com.niit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.niit.app")
public class Webconfig extends WebMvcConfigurerAdapter{

	
	public class WebConfiguration  {
		
		@Bean
		public InternalResourceViewResolver getViewResolver()
		{
			InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
			viewResolver.setPrefix("/WEB-INF/view/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
		}
	}
	
}
