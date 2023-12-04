package com.project.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.restapi.entity.Student;
import com.project.restapi.repository.StudentRepository;


@RestController
public class StudentController 
{
		@Autowired
		StudentRepository repo;
		//localhost:8080/students
		@GetMapping("/students")
		public List<Student> getAllStudents(){
			 List<Student> students = repo.findAll();
			  return students;
		}
		
		//localhost:8080/students/1
		@GetMapping("/students/{id}")
		public Student getStudent(@PathVariable int id) {
			Student student = repo.findById(id).get();
			
			return student;
			
		}
		@PostMapping("/student/add")
		public ResponseEntity<Student> createStudent(@RequestBody Student student) {
			Student newStudent = repo.save(student);
			return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
			
		}
		
		@PutMapping("/student/update/{id}")
		public Student updateStudents(@PathVariable int id) {
		   Student student = repo.findById(id).get();
		   student.setName("poonam");
		   student.setPercentage(92);
		   repo.save(student);
		   return student;
			
		}
		@DeleteMapping("/student/delete/{id}")
		public ResponseEntity<String> removeStudent(@PathVariable int id) {
			Student student = repo.findById(id).get();
			repo.delete(student);
			return new ResponseEntity<String>("Lead is Deleted",HttpStatus.OK);
		}

}
		

