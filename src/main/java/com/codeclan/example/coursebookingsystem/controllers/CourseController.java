package com.codeclan.example.coursebookingsystem.controllers;

import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/rating/{rating}")
    public List<Course> getAllCoursesForGivenRating(@PathVariable int rating){
        return courseRepository.getAllCoursesForGivenRating(rating);
    }

    @GetMapping(value = "/customer/{customerName}")
    public List<Course> getAllCoursesForGivenCustomer( @PathVariable String customerName){
        return courseRepository.getAllCoursesForGivenCustomer(customerName);
    }


}
