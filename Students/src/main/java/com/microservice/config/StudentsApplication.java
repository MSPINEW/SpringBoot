package com.microservice.config;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microservice.pojo.Student;

@SpringBootApplication(scanBasePackages = { "com.microservice.config", "com.microservice.service" })

public class StudentsApplication {

	public static HashMap<Long, Student> hmStudent;

	public static void main(String[] args) {
		hmStudent = new HashMap<Long, Student>();

		Student one = new Student("John", "math");
		hmStudent.put(new Long(one.getId()), one);

		SpringApplication.run(StudentsApplication.class, args);
	}
}
