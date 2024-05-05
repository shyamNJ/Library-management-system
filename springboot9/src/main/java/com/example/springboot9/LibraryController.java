package com.example.springboot9;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.springboot9.model.Library;
import com.example.springboot9.model.LibraryService;

@Controller
public class LibraryController {
	
	@Autowired
	LibraryService lib;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	//----------insert data-------------------//
		@RequestMapping("/insert")
		public String insert() {
			return "insert-form";
		}
		
		@PostMapping("insert-lib")
		public String insertLib(@RequestParam int id, @RequestParam String name, @RequestParam String booknames, @RequestParam String subject, @RequestParam String publisher) {
			Library l1 = new Library(id, name, booknames, subject, publisher);
			lib.add(l1);
			return "home";
			
		}
		
   //------------show------
		@RequestMapping("/show")
		public String Show(Model data) {
			List<Library> l2 = lib.getAll();
			data.addAttribute("Libb" , l2);
			return "show-form";
			
		}
		
		//----------delete method-------------//
		@GetMapping("delete-lib")
		public String delete(@RequestParam int id) {
			Library l3 = new Library(id, null, null, null, null);
			lib.delete(l3);
			return "home";		
		}
		
		//------------update-----------------------------------------------------------------------------------//
		@GetMapping("/update-lib")
		public String update(@RequestParam int id, Model data) {
			Library l4 = lib.getById(id);
			
			if(l4 != null) {
				data.addAttribute("Libb",l4);
				return "update-form";
			}
			else {
				List<Library> l5 = lib.getAll();
				data.addAttribute("Libb", l5);
				return "show-form";
			}
			
		}
		
		@PostMapping("/update-lib")
		public String update(Model data,@RequestParam int id, @RequestParam String name, @RequestParam String booknames, @RequestParam String subject, @RequestParam String publisher) {
			
			Library bc = new Library(id, name, booknames, subject, publisher);
			lib.add(bc);
			List<Library> l6 = lib.getAll();
			data.addAttribute("Libb", l6);
			
			return "show-form";	
		}

}
