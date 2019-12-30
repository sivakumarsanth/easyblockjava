/**
 * 
 */
package com.stg.student.dao;
import org.hibernate.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import com.jayway.jsonpath.Criteria;
import com.stg.student.entity.Booking;
import com.stg.student.entity.Inventory;
import com.stg.student.entity.Room;

/**
 * @author sivakumars
 *
 */
@Repository
public class BaseDaoImpl {

	@PersistenceContext
	EntityManager em;

	public Session getSession() {
		return em.unwrap(Session.class);
	}

	public List<Booking> cancel1(Integer employeeId)
	{
		org.hibernate.Criteria  cr=getSession().createCriteria(Booking.class);
		List<Booking> results = cr.list();
		System.out.println(results);
		System.out.println("hare ram");
		if(results.equals(null))
		{	
		System.out.println("the value was null");
		return null;
		}
		else
		return results;
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Booking> findAllBooking(){

		String SQL="select * from booking";
		Query sql=getSession().createSQLQuery(SQL);

		List<Object[]> obj=sql.list();

		for (Object[] objects : obj) {
			Integer booking_id=(Integer)objects[0];
			System.out.println("bookingid is "+booking_id);
		}
		return null;
	}
	public  List<Room>  availableRoom(List<Booking> bookedone,Booking currentBook){
		String SQL="";
		return null;
	}
	public List<Booking> findAllBooking2(){
		try {

			//select booking_id from easy_block.booking where 
			//(start_time <'2020-01-01 01:00:00' && end_time<'2020-01-01 01:00:00') ||
			//(start_time >'2020-01-01 01:00:00' && end_time>'2020-01-01 01:00:00') && room_id=1
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = format.parse("2010-01-01 04:00:00");	
			Date date2 = format.parse("2010-01-01 05:00:00");
			String SQL="select Room_Id from room where Room_type=:groomtype && floor=:floornum" 
					+" where Room_Id not in("
					+"select room_id from booking where"
					+ "((start_time <:givenstart && start_time<=:givenend)"
					+"||(givenstart=>:end_time && givenend>:end_time))"
					+"&& room_type=:groomtype && floor=:gfloor)";
			// List<Booking> employees = getSession().createNativeQuery("SELECT * FROM booking where start_time>:id",Booking.class)

			List<Booking> employees = getSession().createNativeQuery("SELECT * FROM booking where start_time>:id",Booking.class)
					.setParameter("givenstart",date1)
					.setParameter("givenend",date2)
					.setParameter("groomtype", "board")
					.setParameter("gfloor", 1)

					.list();
			for (Booking employee : employees) {
				Integer id=employee.getBookingId();
				System.out.println("Employee["+id);
			}
			return employees;
		}
		catch(Exception e)
		{
			System.out.println("exception");
		}


		return null;
	}

	public List<Room> availableroom(Booking bookingForm){
		try {

			//select booking_id from easy_block.booking where 
			//(start_time <'2020-01-01 01:00:00' && end_time<'2020-01-01 01:00:00') ||
			//(start_time >'2020-01-01 01:00:00' && end_time>'2020-01-01 01:00:00') && room_id=1
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = format.parse("2010-01-01 0:30:00");	
			Date date2 = format.parse("2010-01-01 05:00:00");

			System.out.println("easyblock dao availableroom start");
			System.out.println(bookingForm.getRoomType());
			String SQL="select * from Room ";
			String SQL1=		"select * from room where "
					+ "room_type=:groomtype and "
					+ "location=:glocation and "
					+ "room_id not in("
					+"select room_id from booking where ((start_time <=:givenstart and :givenstart<end_time) ||"
					+"(start_time <:givenend and :givenend<=end_time))"
					+ "and Room_type=:groomtype && location=:glocation"
					+ " and room_id IS NOT NULL)" ;
			// List<Booking> employees = getSession().createNativeQuery("SELECT * FROM booking where start_time>:id",Booking.class)

			List<Room> resultquery = getSession().createNativeQuery(SQL1,Room.class)
					.setParameter("givenstart",bookingForm.getStartTime())
					.setParameter("givenend",bookingForm.getEndTime())
					.setParameter("groomtype",bookingForm.getRoomType())
					.setParameter("glocation",bookingForm.getLocation())
					.list();
			System.out.println(bookingForm);
			System.out.println(resultquery.size());
			return resultquery;
		}
		catch(Exception e)
		{
			System.out.println("error");
			e.printStackTrace();

		}


		return null;
	}

	public void test() {
		try {
			List<Room> roomList=new ArrayList<Room>();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = format.parse("2020-01-01 01:00:00");	
			Date date2 = format.parse("2020-01-01 02:00:00");
			System.out.println("item count");
			String SQL=
					"select item_id,sum(item_count) from booking "
							+ "where ((start_time <=:givenstart and :givenstart<end_time) ||"
							+"(start_time <:givenend and :givenend<=end_time)) and location=:glocation group by item_id ";
			List<Object[]> resultquery = getSession().createSQLQuery(SQL)
					.setParameter("givenstart",date1)
					.setParameter("givenend",date2)
					.setParameter("glocation", "chennai")
					.addScalar("item_id", IntegerType.INSTANCE)
					.addScalar("sum(item_count)", IntegerType.INSTANCE)
					.list();

			//					List<Room> resultquery = getSession().createSQLQuery(SQL,Room.class)
			//					.setParameter("givenstart",bookingForm.getStartTime())
			//					.setParameter("givenend",bookingForm.getEndTime())
			//					.setParameter("glocation", bookingForm.getLocation())
			//					
			//	.addScalar("item_id", IntegerType.INSTANCE)
			//.addScalar("sum(item_count)", IntegerType.INSTANCE)
			List<Inventory> ls=new ArrayList<Inventory>();
			Inventory r=new Inventory();
			System.out.println(resultquery.size());
			for (Object[] objects : resultquery) {
				Integer id=(Integer)objects[0];
				Integer count=(Integer)objects[1];
				r.setItemId(id);
				r.setItemcount(count);
				ls.add(r);
				System.out.println("Department["+id+","+count+"]");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	

	public int updateStatus(Booking b) {
		
		Query query = getSession().createQuery("update Booking set status = :updatedstatus" +
				" where bookingId = :bookid");
query.setParameter("updatedstatus",b.getStatus());
query.setParameter("bookid", b.getBookingId());
int result = query.executeUpdate();
		return result;
	}

	

	}
