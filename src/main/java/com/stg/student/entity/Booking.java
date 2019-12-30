package com.stg.student.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Booking")
public class Booking {
	@Id
	@GeneratedValue
	@Column(name="bookingId")
	Integer bookingId;
	
	

	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name="roomId")
	Integer roomId;
	
	@Column(name="location")
	String location;
	@Column(name="employeeId")
	Integer employeeId;
	
	@Column(unique = true)
	Integer itemsid;
	
	//@Temporal annotation is used with java.util.Date and java.util.Calendar classes.
	//It converts the date and time values from Java Object to compatible database type and vice versa.
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="startTime")
	Date startTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="endTime")
	Date endTime;
	@Column(name="floor")
	Integer floor;
	
	@Column(name="roomType")
	String roomType;
	
	@Column(name="status")
	String status;
	
	Integer chaircount;
	@Column
	Integer speakercount;
	@Column
	Integer visualcount;
	@Column
	String extra;
	public Integer getFloor() {
		return floor;
	}
	
	public Integer getItemsid() {
		return itemsid;
	}


	public void setItemsid(Integer itemsid) {
		this.itemsid = itemsid;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getChaircount() {
		return chaircount;
	}


	public void setChaircount(Integer chaircount) {
		this.chaircount = chaircount;
	}


	public Integer getSpeakercount() {
		return speakercount;
	}


	public void setSpeakercount(Integer speakercount) {
		this.speakercount = speakercount;
	}


	public Integer getVisualcount() {
		return visualcount;
	}


	public void setVisualcount(Integer visualcount) {
		this.visualcount = visualcount;
	}


	public String getExtra() {
		return extra;
	}


	public void setExtra(String extra) {
		this.extra = extra;
	}


	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	



	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", roomId=" + roomId + ", location=" + location + ", employeeId="
				+ employeeId + ", itemsid=" + itemsid + ", startTime=" + startTime + ", endTime=" + endTime + ", floor="
				+ floor + ", roomType=" + roomType + ", status=" + status + ", chaircount=" + chaircount
				+ ", speakercount=" + speakercount + ", visualcount=" + visualcount + ", extra=" + extra + "]";
	}


	

	
	
	
}
