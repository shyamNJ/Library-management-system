package com.example.springboot9.mapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RestController;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo repo;
	
	public void addUpdate(Student student) {
		repo.save(student);
		
	}
	
   public List<Student> getAll(){
	   return repo.findAll();
   }
   
   public Student getById(int id) {
	   Optional<Student> opt=repo.findById(id);
	   if(opt.isEmpty()) {
		   return null;
	   }
	   return opt.get();
   }
	
	

}
