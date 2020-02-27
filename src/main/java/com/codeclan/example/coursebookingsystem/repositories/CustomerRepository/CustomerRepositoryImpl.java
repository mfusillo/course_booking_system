package com.codeclan.example.coursebookingsystem.repositories.CustomerRepository;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> getAllCustomersForGivenCourse(String courseName){
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.createAlias("booking.course", "course");
            cr.add(Restrictions.eq("course.name", courseName).ignoreCase());
            result = cr.list();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Transactional
    public List<Customer> getAllCustomersForGivenTownAndGivenCourse(String town, String courseName){
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.add(Restrictions.eq("town", town).ignoreCase());
            cr.createAlias("bookings", "booking");
            cr.createAlias("booking.course", "course");
            cr.add(Restrictions.eq("course.name", courseName).ignoreCase());
            result = cr.list();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Transactional
    public List<Customer> getAllCustomersOverGivenAgeInGivenTownForGivenCourse(int age, String town, String courseName){
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.add(Restrictions.ge("age", age));
            cr.add(Restrictions.eq("town", town).ignoreCase());
            cr.createAlias("bookings", "booking");
            cr.createAlias("booking.course", "course");
            cr.add(Restrictions.eq("course.name", courseName).ignoreCase());
            result = cr.list();
        }

        catch(HibernateException ex){
        ex.printStackTrace();
        }

        return result;
    }


}
