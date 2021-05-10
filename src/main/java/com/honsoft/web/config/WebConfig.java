package com.honsoft.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.honsoft.web.controller.HelloController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.honsoft")
public class WebConfig implements WebMvcConfigurer {

	@Bean("/hello*")
	public HelloController helloController() {
		return new HelloController();
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(true).ignoreAcceptHeader(false).defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML).mediaType("json", MediaType.APPLICATION_JSON);
	}


}