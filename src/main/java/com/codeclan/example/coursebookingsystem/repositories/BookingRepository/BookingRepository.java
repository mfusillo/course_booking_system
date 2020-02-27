package com.codeclan.example.coursebookingsystem.repositories.BookingRepository;

import com.codeclan.example.coursebookingsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {

    List<Booking> findByDate(String date);

}
