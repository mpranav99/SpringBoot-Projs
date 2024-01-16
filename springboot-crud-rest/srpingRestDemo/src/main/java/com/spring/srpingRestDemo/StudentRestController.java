package com.spring.srpingRestDemo;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;
    //@postConstruct creates the data only once that is when the bean is loaded!!
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Pranav" , "M"));
        students.add(new Student("Gagan" , "M"));
        students.add(new Student("Rekha" , "M"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return students;
    }

    //creating new endpoint with a path variable
    @GetMapping("/students/{studentId}")
    public Student getStudentWithID(@PathVariable int studentId){

        if(studentId > students.size() || studentId < 0){
            throw new StudentNotFoundException("Student ID not found -" + studentId);
        }
        return  students.get(studentId);
    }

    // handling the exception thrown using exception-handler
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handlingExceptions(StudentNotFoundException exc){
//
//        //create an obj of custom error response i.e student error response in our case
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setMessage(exc.getMessage());
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setTimestamp(System.currentTimeMillis());
//
//        //return the ResponseEntity by passing the error(body) and the status code
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    //another exception handler for all kinds of exceptions
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleAllExceptions(Exception ex){
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setMessage(ex.getMessage());
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setTimestamp(System.currentTimeMillis());
//
//        //return the ResponseEntity by passing the error(body) and the status code
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }

}
