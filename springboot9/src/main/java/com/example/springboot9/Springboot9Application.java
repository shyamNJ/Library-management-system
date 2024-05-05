package com.example.springboot9;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import com.example.springboot9.model.Library;
import com.example.springboot9.model.LibraryService;

@SpringBootApplication
public class Springboot9Application implements CommandLineRunner {

	@Autowired
	LibraryService lib;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Springboot9Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		
		//regular insert
		Library lib11 = new Library(11,"sum", "supermom", "hello", "adfad" );
		lib.add(lib11);
		
		//bulk insert
		Library l1 = new Library (12, "sofdfa", "richestman", "rakesh", "her");
		Library l2 = new Library(13, "hello", "bum", "qutar", "doremon");
		List<Library> newlib = new ArrayList<>();
		newlib.add(l1);
		newlib.add(l2);
		lib.addBulk(newlib);
		
		//-------------------------------------print console in name only-------------------------------------
//		List<Library> allAnimals = lib.getBySortOnly("name", Direction.DESC);
//		for(Library temp : allAnimals) {
//			System.out.println("Name : "+ temp.getName());
//		}
		
		/*
		 * List<Library> allLibrary = lib.filterByname("ack"); //black for(Library temp
		 * : allLibrary) { System.out.println("Details : "+temp.toString()); }
		 */
		
		
	}

}
