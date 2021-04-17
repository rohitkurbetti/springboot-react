package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.Users;

public interface UsersDao extends JpaRepository<Users, Long>{
	
}
