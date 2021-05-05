package com.honsoft.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.honsoft.web.controller.HelloController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.honsoft")
public class WebConfig {
	
	@Bean("/hello*")
	public HelloController helloController() {
		return new HelloController();
	}
	
	@Bean
	  public InternalResourceViewResolver internalResourceViewResolver() {
	    return new InternalResourceViewResolver("/jsp/", ".jsp");
	  }
}