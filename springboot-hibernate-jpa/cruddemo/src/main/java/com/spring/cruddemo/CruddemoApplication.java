package com.spring.cruddemo;

import com.spring.cruddemo.dao.StudentDAO;
import com.spring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			System.out.println("Hello World!!");

			createStudent(studentDAO);
		};
	}

	public void createStudent(StudentDAO studentDAO){
		//create the student Obj
//		Student newStudent = new Student("Gagan", "M" , "mgagan544@gmail.com");
//		Student anotherStudent = new Student("Pranav", "M" , "mpranav05@gmail.com");

		//save the student obj
//		studentDAO.save(newStudent);
//		studentDAO.save(anotherStudent);
		Student myStudent  = studentDAO.findById(6);
//		myStudent.setFirstName("Rekha");
//		studentDAO.updateFirstName(myStudent);
		int data  = studentDAO.deleteAllStudents();
//		List<Student> students = studentDAO.findByGivenParamName("Pranav");
//		List<Student> students = studentDAO.findAll();

		//get the id of the new student obj entry
//		System.out.println("Student data of id"+anotherStudent.getId() + " is "+ myStudent);
//		for(Student s: students){
//			System.out.println(s);
//		}
//		System.out.println(myStudent);
		System.out.println(data);
	}
}
