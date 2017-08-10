package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;

@SpringBootApplication
public class DemoApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(StudentRepository studentRepository) {
		return (args) -> {
			studentRepository.save(new Student("Gustavo", "Ponce", true));
			studentRepository.save(new Student("John", "Smith", true));
			studentRepository.save(new Student("Jim ", "Morrison", false));
			studentRepository.save(new Student("David", "Gilmour", true));
			logger.info("The sample data has been generated");
		};
	}
}
