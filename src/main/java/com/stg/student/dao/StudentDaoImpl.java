package com.stg.student.dao;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

public class StudentDaoImpl extends JpaRepositoryFactory {

	public StudentDaoImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
}