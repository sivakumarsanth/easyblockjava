package com.stg.student.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stg.student.entity.Booking;

public interface BookingJpa extends JpaRepository<Booking, Integer> {
	

	
}
