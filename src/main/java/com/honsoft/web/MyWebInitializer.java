package com.honsoft.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.honsoft.web.config.WebConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//servlet api 3.0 이상에서 사용가능
public class MyWebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	System.out.println("MyWebInitializer taken up.");
        var ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        ctx.setServletContext(servletContext);

        System.out.println("MyWebInitializer before adding dispatcher");
        var servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        System.out.println("MyWebInitializer ended servletContext build");
    }
}