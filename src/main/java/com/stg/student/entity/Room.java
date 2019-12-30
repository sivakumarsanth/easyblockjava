package com.stg.student.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Room")
public class Room {

	@Id
	@Column(name="roomId")
	Integer roomId;
	@Column(name="roomname")
	String roomname;
	
	

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomname=" + roomname + ", Location=" + location + ", roomType=" + roomType
				+ ", floor=" + floor + "]";
	}

	@Column(name="location")
	String location;
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name="roomType")
	String roomType;
	
	@Column(name="floor")
	Integer floor;
	
	public Room(Integer roomId, String roomname, String roomType, Integer floor) {
		super();
		this.roomId = roomId;
		this.roomname = roomname;
		this.roomType = roomType;
		this.floor = floor;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
