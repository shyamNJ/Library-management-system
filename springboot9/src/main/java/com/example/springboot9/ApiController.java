package com.example.springboot9;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot9.model.Library;
import com.example.springboot9.model.LibraryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ApiController {

	@Autowired
	LibraryService lib;

	@GetMapping("/api/addition")
	public int addition(@RequestParam int a, @RequestParam int b) {
		return (a+b);
	}

	//-----------show------------
	@GetMapping("api/getAllBooks")
	public List<Library> getLibrary(){
		return lib.getAll();

	}

	//------------Add-------------
	@PostMapping("api/addNewLibrary")
	public String addBook(@RequestParam int id, @RequestParam String name, @RequestParam String booknames,@RequestParam String subject, @RequestParam String publisher) {
		Library l1 = new Library(id, name, booknames, subject, publisher);

		if(lib.getById(id) == null) {		
			lib.add(l1);
			return "book Added";
		}
		else {
			return "duplicate entry id";
		}

	}


	//------------update------------
	@PutMapping("api/updataLibrary")
	public String updateLibrary(@RequestParam int id, @RequestParam String name, @RequestParam String booknames,@RequestParam String subject, @RequestParam String publisher) {

		Library l2 = new Library(id, name, booknames, subject, publisher);
		lib.add(l2);
		return "Library update";

	}

	//---delete-----------
	@DeleteMapping("api/deleteLibrary")
	public String deleteLibrary(@RequestParam int id) {
		Library l3 = new Library(id, null, null, null, null);
		lib.delete(l3);
		return "Library deleted";
	}

	//------getby id------
	@GetMapping("api/getById")
	public Library getById(@RequestParam int id) {
		return lib.getById(id);

	}


	//---------------paging---------------------
	@Operation(summary = "for paging purposes. Send Direction 1 for asc, others for desc.")
	@GetMapping ("api/sorting")
	public Page<Library> getBySorting (@RequestParam int pageNumber, @RequestParam int direction, @RequestParam String columnName, @RequestParam int rowPerPage){
		//asc
		if(direction == 1) {
			Page<Library> library = lib.getBypage(pageNumber, Direction.ASC, columnName, rowPerPage);
			return library;
		}
		else {
			Page<Library> library = lib.getBypage(pageNumber, Direction.DESC, columnName, rowPerPage);
			return library;
		}
	}
	
	//------------------filter-----------------
	@Deprecated
	@Operation(summary = "search based on contains method on the color field.")
	@GetMapping("api/searchByname")
	public List<Library> searchByName(@RequestParam String name,@RequestParam String sk){
		return lib.filterByname(sk, name);
	}
	
	/*
	 * @Operation(summary = "search based on contains method on the color field.")
	 * 
	 * @GetMapping("api/searchBybookname") public List<Library>
	 * searchByBookName(@RequestParam String booknames){ return
	 * lib.filterByname(booknames); }
	 */
}
