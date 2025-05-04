package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Login;
import com.ecom.service.LoginService;

@RestController
@RequestMapping("/loginusers")
@CrossOrigin

public class LoginController {
	@Autowired
	LoginService cserp;
	
	@PostMapping("/save")//http://localhost:8080/loginusers/save
	public String save(@RequestBody Login l) {
		return cserp.save(l);
		
	}
	
	@GetMapping("/findalls")//http://localhost:8080/loginusers/findalls
	public List findall() {
		return cserp.findall();
	}

}

//{
//    "mobile":"8374454534",
//	 "password":"12345",
//	 "status":"active",
//	 "created":"16-04-25",
//	 "updated":"16-04-25"
//}