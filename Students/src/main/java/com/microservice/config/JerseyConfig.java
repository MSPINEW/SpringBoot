package com.microservice.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.microservice.service.StudentService;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Configuration
public class JerseyConfig extends ResourceConfig {

	@Value("${spring.jersey.application-path}")
	private String apiPath = "/api";	
	
	public JerseyConfig() {
		registerEndpoints();
		configureSwagger();
	}

	private void configureSwagger() {
		register(ApiListingResource.class);
		register(SwaggerSerializers.class);
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setTitle("Spring Boot + Jersey + Swagger + Docker Example");
		beanConfig.setVersion("v1");
		beanConfig.setSchemes(new String[] { "http" });
		System.out.println("apiPath:" + apiPath);
		beanConfig.setBasePath(apiPath);
		beanConfig.setResourcePackage("com.microservice.service,com.microservice.config");
		beanConfig.setPrettyPrint(true);
		beanConfig.setScan(true);
	}

	private void registerEndpoints() {
		register(WadlResource.class);
		register(StudentService.class);
	}	
}