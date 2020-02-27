package com.codeclan.example.coursebookingsystem.repositories.CourseRepository;


import com.codeclan.example.coursebookingsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {
}
