package com.codeclan.example.coursebookingsystem.controllers;

import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.hibernate.persister.collection.CollectionPersister;

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

    @GetMapping(value = "/{town}/course/{courseName}")
    public List<Customer> getAllCustomersForGivenTownAndGivenCourse(@PathVariable String town, @PathVariable String courseName){
        return customerRepository.getAllCustomersForGivenTownAndGivenCourse(town, courseName);
    }

    @GetMapping(value = "/{age}/{town}/course/{courseName}")
    public List<Customer> getAllCustomersOverGivenAgeInGivenTownForGivenCourse(@PathVariable int age, @PathVariable String town, @PathVariable String courseName){
        return customerRepository.getAllCustomersOverGivenAgeInGivenTownForGivenCourse(age, town, courseName);
    }



}
