package com.codeclan.example.coursebookingsystem.repositories.CourseRepository;

import com.codeclan.example.coursebookingsystem.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {
    List<Course> getAllCoursesForGivenRating(int rating);
    List<Course> getAllCoursesForGivenCustomer(String customerName);
}
