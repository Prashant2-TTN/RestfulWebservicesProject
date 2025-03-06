package com.prashant.RestApiProject.controller;

import com.prashant.RestApiProject.entity.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    //rest api (https://localhost:8080/corses)
    //course will contain id, name, author

    @GetMapping("/courses")
    public List<Course> retrieveCourses(){
        return Arrays.asList(new Course(1,"Springboot","Vishnu Sir"),
                new Course(2,"Spring","Nitin Sir"));
    }
    @GetMapping("/message")
    public String retrieveMessage(){
        return "Welcome to spring boot";
    }
}
