package com.spring.hibernate.mappings.springHibernateMappings;

import com.spring.hibernate.mappings.springHibernateMappings.dao.InstructorDAO;
import com.spring.hibernate.mappings.springHibernateMappings.entity.Instructor;
import com.spring.hibernate.mappings.springHibernateMappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO dao){

		return runner -> {

//			Instructor instructor = new Instructor("Gagan", "M" , "mgagan544@gmail.com");
//
//			InstructorDetail instructorDetail = new InstructorDetail("FitnessGeek" , "Singing");
//			instructor.setInstructorDetailId(instructorDetail);
//			dao.save(instructor);

//			findInstructor(dao);
//			dao.removeAll();
			findByInstructorDetail(dao);
		};
	}

	public void findByInstructorDetail(InstructorDAO dao){
		int id = 4;
//		Instructor instructor = dao.findInstructorById(id);
		InstructorDetail instdetail = dao.findById(id);
		System.out.println("Instructor is : " + instdetail);
		System.out.println("Instructor details are : " + instdetail.getInstructor());
	}

	public void findInstructor(InstructorDAO dao){
		int id = 2;
		Instructor instructor = dao.findInstructorById(id);
		System.out.println("Instructor is : " + instructor);
		System.out.println("Instructor details are : " + instructor.getInstructorDetailId());
	}
}
