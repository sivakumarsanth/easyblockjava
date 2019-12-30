package com.stg.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.student.entity.Employee;

public interface EmployeeJpa extends JpaRepository<Employee, Integer> {

}
