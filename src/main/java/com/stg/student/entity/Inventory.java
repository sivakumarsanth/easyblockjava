package com.stg.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Inventory")
public class Inventory {
	
	@Id
	@Column(name="itemId")
	Integer itemId;
	@Column(name="itemName")
	String itemName;
	@Column(name="itemcount")
	Integer itemcount;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemcount() {
		return itemcount;
	}
	public void setItemcount(Integer itemcount) {
		this.itemcount = itemcount;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
