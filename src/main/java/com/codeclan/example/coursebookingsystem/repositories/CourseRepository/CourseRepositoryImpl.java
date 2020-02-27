package com.codeclan.example.coursebookingsystem.repositories.CourseRepository;

import com.codeclan.example.coursebookingsystem.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> getAllCoursesForGivenRating(int rating){
        List<Course> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Course.class);
            cr.add(Restrictions.eq("starRating", rating));
            result = cr.list();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Transactional
    public List<Course> getAllCoursesForGivenCustomer(String customerName){
        List<Course> result = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("bookings", "booking");
            cr.createAlias("booking.customer", "customer");
            cr.add(Restrictions.eq("customer.name", customerName));
            result = cr.list();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        return result;
    }

}
