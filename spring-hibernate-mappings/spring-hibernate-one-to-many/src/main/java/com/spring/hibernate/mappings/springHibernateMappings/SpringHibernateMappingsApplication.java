package com.spring.hibernate.mappings.springHibernateMappings;

import com.spring.hibernate.mappings.springHibernateMappings.dao.InstructorDAO;
import com.spring.hibernate.mappings.springHibernateMappings.entity.Course;
import com.spring.hibernate.mappings.springHibernateMappings.entity.Instructor;
import com.spring.hibernate.mappings.springHibernateMappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringHibernateMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO dao){

		return runner -> {
//			createInstructorWithCourses(dao);
//			findInstructorAlongWithCourses(dao);
//			updateInstructor(dao);
			updateCourseUsingInstructor(dao);
		};
	}

	private void updateCourseUsingInstructor(InstructorDAO dao) {
		//we will
		Instructor inst = dao.findInstructorById(1);
		
	}

	private void updateInstructor(InstructorDAO dao) {
		//find the instructor from db on whom update has to be done
		Instructor instructor = dao.findInstructorById(1);

		//now update whatever fields required on the instructor
		instructor.setFirstName("Alpha");

		//now use the update method from dao to merge the new data into DB
		dao.update(instructor);
	}

	private void findInstructorAlongWithCourses(InstructorDAO dao) {
		Instructor instructor = dao.findInstructorAndRelatedCourses(1);
		//fetch instructor from dao using lazy loading as its default for oneToMany
		List<Course> courses = dao.findCoursesByInstructorId(instructor.getId());
		//then we will fetch a list of courses from dao

		System.out.println("The instructor is : " + instructor);
//		System.out.println("The courses are ");
		System.out.println("The courses of "+ instructor.getFirstName() + " are " + instructor.getCourses());
	}

	public void createInstructorWithCourses(InstructorDAO dao){
		Course course1 = new Course("Spring Boot");
		Course course2 = new Course("ReactJS");

		Instructor instructor = new Instructor("Giga", "Chad", "gigaChad@gmail.com");
		instructor.add(course1);
		instructor.add(course2);

		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/DanielThrasher", "Piano");
		instructor.setInstructorDetailId(instructorDetail);
		dao.save(instructor);
	}

}
