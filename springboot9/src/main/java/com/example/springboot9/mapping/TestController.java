package com.example.springboot9.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;

@RestController
public class TestController {
	
	@Autowired
	StudentRepo repo;
	
	@Autowired
	PancardRepo panrepo;
	
	@Autowired
	StudentService studentservice;
	
     @Autowired
     PancardService pancardservice;
     
     @PostMapping("/tutor/addStudent")
     public String addStudent(@RequestParam int id, @RequestParam String name, @RequestParam int age) {
    	 Student s1 = new Student(id, name, age, null);
    	 studentservice.addUpdate(s1);
    	 return "Student Added";
     }
     
     @GetMapping("/tutor/getAllStudent")
     public List<Student> getAllStudent(){
    	 return studentservice.getAll();
     }
     
     @PostMapping("/tutor/addPancard")
     public String addPancard (@RequestParam int id, @RequestParam String PanNumber, @RequestParam int studentId) {
		Student s1 =studentservice.getById(studentId);
		if(s1 == null) {
			return "invalid student id";
			
		}
		Pancard pancard = new Pancard(id, PanNumber, s1);
		pancardservice.addUpdate(pancard);
    	 return "Pancard Added";	 
     }
     
     @GetMapping("/tutor/getAllPancard")
     public List<Pancard> getAllPancard(){
		return pancardservice.getAll();
    	 
		
     }
     
	
}
