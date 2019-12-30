package com.stg.student.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stg.student.dao.BaseDaoImpl;
import com.stg.student.dao.BookingJpa;
import com.stg.student.dao.EmployeeJpa;
import com.stg.student.entity.Booking;
import com.stg.student.entity.Employee;
import com.stg.student.entity.Room;

@Service("easyblockService")
public class EasyBlockServiceImpl implements EasyBlockService {

	@Autowired
	BaseDaoImpl basedaoimpl;

	@Autowired
	BookingJpa bookingobj;
	@Autowired
	EmployeeJpa ejpa;
	//@Transactional
	public Employee checkLoginDetails(Employee eForm) {
		System.out.println(eForm.getEmployeeId());
		System.out.println("god"+eForm.getEpass());
		Employee e=new Employee();
		Optional<Employee> e1=ejpa.findById(eForm.getEmployeeId());
		if(e1.isPresent() ){

			e.setEmployeeId( e1.get().getEmployeeId());
			e.setEname( e1.get().getEname());
			e.setRole( e1.get().getRole());
			String pass=e1.get().getEpass();
			System.out.println("pass1"+pass);
			System.out.println("pass2"+eForm.getEpass());
			if(pass.equals(eForm.getEpass()))
			{
				return e;
			}
			else  {
				System.out.println("else");
				e.setEname("nothing");
				return e;
			}
		}
		else {
			System.out.println("else-else");
			e.setEname("nothing");
			return e;
		}
	}
	@Override
	public Booking addBooking(Booking bookingform) {
		Booking bookingresult;
		bookingresult=bookingobj.saveAndFlush(bookingform);

		return bookingresult;
		/*		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date,date1,date2;
		try {
			date = format.parse("2012-12-13 14:54:30");
		 // mysql datetime format
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		System.out.println(calendar.getTime());

		String string = format.format(calendar.getTime());
		System.out.println(string);
		Booking b=new Booking();
		Booking result;
		date1 = format.parse("2020-01-01 03:00:00");
		date2 = format.parse("2020-01-01 04:00:00");
		b.setStartTime(date1);
		b.setEndTime(date2);
		b.setItemCount(3);
		b.setItemId(1);
		b.setRoomId(1);
		b.setEmployeeId(2);
		result=bookingobj.saveAndFlush(b);
		System.out.println(result);
		System.out.println(b.getEndTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */
	}



	@Override
	public List<Booking> findAll() {

		return bookingobj.findAll();
	}
	public List<Room> availableroom(Booking bookingForm) {
		System.out.println("easyblock service start");
		List<Room> roomList=basedaoimpl.availableroom(bookingForm);
		System.out.println("easyblock service end");
		return roomList;
	}
	public void test() {
		basedaoimpl.test();
	}



	@Override
	public void waitForAdmin(Booking bookingForm) {
		System.out.println("waitForAdmin--- JPA");
		bookingobj.save(bookingForm);
	}



	@Override
	public List<Booking> cancel1(Integer employeeId) {
		 
		List<Booking> l1=basedaoimpl.cancel1(employeeId);
		List<Booking> l2=l1.stream().filter(obj ->{
			Date d= obj.getStartTime();
			Date d2= new Date();
			if(d.compareTo(d2)==1)
				return true;
			else 
				return false;
		}
				).collect(Collectors.toList());
		
				return l2;
		

	}



	@Override
	public Boolean cancel2(Integer bookingId) {
		System.out.println("canceling the booking-- hehehe");
		bookingobj.deleteById(bookingId);

		return true;
	}



	@Override
	@Transactional
	public int adminApproval(Booking b) {
		// TODO Auto-generated method stub
		int results;
		System.out.println("approving the booking-- tototo");
		System.out.println(b);
		if(b!=null)
		{
			results=basedaoimpl.updateStatus(b);
		}
		else 
		{return 0;
		}

		return results;
	}

}
