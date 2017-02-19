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

		Student one = new Student(1 ,"John", "math");
		hmStudent.put(one.getId(), one);

		Student two = new Student(2, "Venkat", "IT");
		hmStudent.put(two.getId(), two);

		
		SpringApplication.run(StudentsApplication.class, args);
	}
}
