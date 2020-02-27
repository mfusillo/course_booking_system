package com.codeclan.example.coursebookingsystem.repositories.CustomerRepository;

import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.projections.EmbedCourseAndCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = EmbedCourseAndCustomer.class)
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
    List<Customer> getAllCustomersForGivenCourse(String courseName);
    List<Customer> getAllCustomersForGivenTownAndGivenCourse(String town, String courseName);
    List<Customer> getAllCustomersOverGivenAgeInGivenTownForGivenCourse(int age, String town, String courseName);

}
