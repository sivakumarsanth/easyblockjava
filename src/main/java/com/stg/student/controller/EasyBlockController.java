package com.stg.student.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stg.student.entity.Booking;
import com.stg.student.entity.Employee;
import com.stg.student.entity.Room;
import com.stg.student.service.EasyBlockService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EasyBlockController {
	@Autowired
	EasyBlockService easyBlockService;
	
	@PostMapping(value = "/login")
	public Employee  checkLoginDetrails(@RequestBody Employee efrom ) { 
		
		System.out.println("heraaaaa ram");
		
		System.out.println("siva");
		System.out.println(efrom);
		Employee e = easyBlockService.checkLoginDetails(efrom);
	System.out.println(e+"rama");
		return e;
	}
	@PostMapping(value="/addbooking")
	public Booking addBooking(@RequestBody Booking bookingForm) {
		return easyBlockService.addBooking(bookingForm);
	}
	
	@GetMapping(value="/getallbooking")
	public List<Booking> findall()
	{
		List<Booking> t=easyBlockService.findAll();

	      LocalDateTime currentTime = LocalDateTime.now();
	     // LocalTime now = LocalTime.now();
//		List<Booking> result=t.stream().filter
//				(i->i.getStartTime(). ).collect(Collectors.toList());
//			
		return t;
//		List<E> l= new ArrayList<>();
		
		
	}
	@PostMapping(value="/availableroom")
	public List<Room> availableroom(@RequestBody Booking bookingForm)
	{
		System.out.println("availableroom in easyblock controller");
		System.out.println("booking form"+bookingForm.toString());
		List<Room> t=easyBlockService. availableroom(bookingForm);
		for(Room re: t)
		{
		System.out.println(re.getRoomId());
		}
		System.out.println();
		return t;
	}

	@GetMapping(value="/test")
	public void test()
	{
		
		easyBlockService.test();
	}
	@PostMapping(value="/testangular")
	public void testang(@RequestBody Booking bookingForm)
	{
		System.out.println("siva");
		System.out.println(bookingForm.toString());
	}
	
	@PostMapping(value="/final")
	public void waitForAdmin(@RequestBody Booking bookingForm)
	{
		System.out.println("final called");
		//bookingForm.setEmployeeId(101);
		easyBlockService.waitForAdmin(bookingForm);
	System.out.println(bookingForm);
		 
	}
	@PostMapping(value="/cancel1")
	public List<Booking> cancel1(@RequestBody Integer id)
	{
		System.out.println(id +"--siva");
		// to get the records for the cancel
		List<Booking> results=easyBlockService.cancel1(id);
		System.out.println(results);
		return results;
		
		
	}
	@GetMapping(value="/cancel2/{bookingId}")
	public Boolean cancel2(@PathVariable Integer bookingId)
	{
		Boolean results=easyBlockService.cancel2(bookingId);
		System.out.println(results);
		return results;
	
	}
	@PostMapping(value="/adminapprove")
	public int adminApproval(@RequestBody Booking b)
	{
		System.out.println("inside approval");
		System.out.println(b);
		int results=easyBlockService.adminApproval(b);
		System.out.println(results);
		return results;
	}
	@GetMapping(value="/findallbooking")
	public List<Booking> findAllBooking()
	{
		return easyBlockService.findAll();
	}
}
