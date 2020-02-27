package com.codeclan.example.coursebookingsystem.projections;

import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.models.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.util.ArrayList;
import java.util.List;

@Projection(name = "embedCourseAndCustomer", types = {Customer.class, Course.class})
public interface EmbedCourseAndCustomer {
    String getName();
}
