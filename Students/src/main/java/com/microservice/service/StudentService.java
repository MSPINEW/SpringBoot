package com.microservice.service;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.microservice.config.StudentsApplication;
import com.microservice.pojo.Student;

import io.swagger.annotations.Api;

@Api
@Component

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentService {

	@GET
	@Path("/student")
	public HashMap<Long, Student> getAllStudents() {
		return StudentsApplication.hmStudent;
	}
}