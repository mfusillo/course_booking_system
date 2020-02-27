package com.codeclan.example.coursebookingsystem.repositories.CustomerRepository;

import com.codeclan.example.coursebookingsystem.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<Customer> getAllCustomersForGivenCourse(String courseName);
}
