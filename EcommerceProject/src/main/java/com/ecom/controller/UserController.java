package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.LoginDto;
import com.ecom.entity.Products;
import com.ecom.entity.User;
import com.ecom.service.UserService;

@RestController
@RequestMapping("/userss")
@CrossOrigin

public class UserController {
	 @Autowired
	UserService userss;
	@PostMapping("/register")//http://localhost:8080/userss/adduser
		public String save(@RequestBody User u) {
			return userss.save(u);
			
		}
	
	@GetMapping("/findall")//http://localhost:8080/userss/findall
	public List findall() {
		return userss.findAll();
	}
	
	 
	    
	
	 @PostMapping("/login")//http://localhost:8080/userss/login
	    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
	        try {
	            User user = userss.login(loginDto.getUsername(), loginDto.getPassword());
	            if (user != null) {
	                return ResponseEntity.ok(user);
	            } else {
	                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	        }
	    }
}

//{
//    "username":"nikhil",
//	 "mobile":"9158449484",
//	 "email":"nikhil915894@gmail.com",
//	 "role":"customer",
//}
	

