package com.codeclan.example.coursebookingsystem.components;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.BookingRepository.BookingRepository;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository.CourseRepository;
import com.codeclan.example.coursebookingsystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

        Course java = new Course("Java", "Edinburgh", 5);
        courseRepository.save(java);
        Course javascript = new Course("Javascript", "Glasgow", 4);
        courseRepository.save(javascript);
        Course ruby = new Course("Ruby", "London", 4);
        courseRepository.save(ruby);

        Customer evan = new Customer("Evan", "Edinburgh", 36);
        customerRepository.save(evan);
        Customer matteo = new Customer("Matteo", "Dundee", 27);
        customerRepository.save(matteo);
        Customer john = new Customer("John", "Edinburgh", 36);
        customerRepository.save(john);

        Booking booking1 = new Booking("10-12-19", java, evan);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("12-06-20", javascript, matteo);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("10-03-20", ruby, matteo);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("10-03-20", java, john);
        bookingRepository.save(booking4);

    }
}
