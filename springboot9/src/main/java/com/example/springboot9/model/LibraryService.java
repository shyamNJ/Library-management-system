package com.example.springboot9.model;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

//import net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record.Sort;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository lib;
	
	//----------add--------------
	public void add(Library library) {
		lib.save(library);
	}
	
	//-----------show-----------
	public List<Library> getAll(){
		return lib.findAll();
	}
	
	//----------delete----------
	public void delete(Library library) {
		lib.delete(library);
	}
	
	//-------update-------
	public Library getById(int id) {
		Optional<Library> liboptional = lib.findById(id);
		Library temp = null;
		if(liboptional.get() != null) {
			temp = liboptional.get();
		}
		return temp;
	}
	
	//---add bulk--------
	public void addBulk (List<Library> library) {
		lib.saveAll(library);
	}
	
	//-------direction - sorting--------
	public Page<Library> getBypage(int pageNumber, Direction direction, String columnName, int rowPerPage){
		
		//does not care of ordering / sorting /direction
		//Pageable page = PageRequest.of(pageNumber, rowPerPage);
		
		 Pageable page = PageRequest.of(pageNumber,  rowPerPage,direction, columnName);
		return lib.findAll(page);
		
	}
	
	//------------only paging------------------
	public Page<Library> getByPageOnly (int pageNumber, int rowPerPage){
		
		//does not care of ordering / sorting /direction
				Pageable page = PageRequest.of(pageNumber, rowPerPage);
				return lib.findAll(page);
	}
	
	//--------------only sorting-------------------
	public List<Library> getBySortOnly(String columns, Direction direction){
		return lib.findAll(Sort.by(direction, columns));
	}
	
	//--------------------filter-------------------
	public List<Library> filterByname(String searchKey,String columnNmae){
		//1. Dummy
		Library dummy = new Library();
		dummy.setName(searchKey);
		
		//2. Where with ExampleMatcher
		ExampleMatcher em = ExampleMatcher.matching().withMatcher(columnNmae, ExampleMatcher.GenericPropertyMatchers.contains()).withIgnoreCase("id", "booknames", "subject", "publisher");
		
		//3.combining dummy with where
		Example<Library> example = Example.of(dummy, em);
		
		return lib.findAll(example);
	}
	
	public List<Library> filterByBooknames(String searchKey, String columnname){
		//1. Dummy
		Library dummy = new Library();
		dummy.setName(searchKey);
		
		//2. Where with ExampleMatcher
		ExampleMatcher em = ExampleMatcher.matching().withMatcher(columnname, ExampleMatcher.GenericPropertyMatchers.contains()).withIgnoreCase("id", "booknames", "subject", "publisher");
		
		//3.combining dummy with where
		Example<Library> example = Example.of(dummy, em);
		
		return lib.findAll(example);
	}
		
		

		

	

}
