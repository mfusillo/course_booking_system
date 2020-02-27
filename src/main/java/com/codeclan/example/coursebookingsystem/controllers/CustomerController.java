package com.codeclan.example.coursebookingsystem.controllers;

import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/course/{courseName}")
    public List<Customer> getAllCustomersForGivenCourse(@PathVariable String courseName){
        return customerRepository.getAllCustomersForGivenCourse(courseName);
    }



}
