package com.project.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restapi.entity.Student;



public interface StudentRepository extends JpaRepository<Student, Integer> 
{
	

}
