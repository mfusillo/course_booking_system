package com.codeclan.example.coursebookingsystem.repositories.CourseRepository;


import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.projections.EmbedCourseAndCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = EmbedCourseAndCustomer.class)
public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {

    List<Course> getAllCoursesForGivenRating(int rating);
    List<Course> getAllCoursesForGivenCustomer(String customerName);

}
