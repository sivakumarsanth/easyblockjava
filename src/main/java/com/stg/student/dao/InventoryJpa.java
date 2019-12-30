package com.stg.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.student.entity.Inventory;

public interface InventoryJpa extends JpaRepository<Inventory, Integer> {

	
}
