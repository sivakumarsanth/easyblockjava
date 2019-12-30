package com.stg.student.service;

import java.util.List;

import com.stg.student.entity.Booking;
import com.stg.student.entity.Employee;
import com.stg.student.entity.Room;

public interface EasyBlockService {
	Employee checkLoginDetails(Employee eForm);
	 Booking addBooking(Booking bookingForm);
	 List<Booking> findAll();
	 List<Room> availableroom(Booking bookingForm);
	 void waitForAdmin(Booking bookingForm);
	void test();
	List<Booking> cancel1(Integer employeeId);
	Boolean cancel2(Integer bookingId);
	int adminApproval(Booking b);
}
