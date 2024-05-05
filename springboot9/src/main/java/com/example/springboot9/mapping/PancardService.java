package com.example.springboot9.mapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PancardService {
	
	@Autowired
	PancardRepo panrepo;
	
	public void addUpdate (Pancard pancard) {
		panrepo.save(pancard);
	}
	
	public List<Pancard> getAll(){
		return panrepo.findAll();
		
	}
	
	public Pancard getById(int id) {
		Optional<Pancard> pancardopt = panrepo.findById(id);
		if(pancardopt.isEmpty()) {
			return null;
		}
		return pancardopt.get();
	}
	
	

}
