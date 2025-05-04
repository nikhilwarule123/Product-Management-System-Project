package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Order;
import com.ecom.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin

public class OrderController {
	@Autowired 
	OrderService orsps;
	
	@PostMapping("/savess")//table data not enter backend any table //dublicted filed not endter data
	//http://localhost:8080/order/savess
	public String save(@RequestBody Order o) 
	{
		return orsps.save(o);
	}
	
	@GetMapping("/findall")
	public List findall() {
		return orsps.findll();
		
	}
	
	@DeleteMapping("/deletes/{id}")//http://localhost:8080/order/deletes/1
    public String deletebyid(@PathVariable int id) {
		return orsps.deleteById(id);
	}
	
	@PutMapping("/updateorde/{id}")
	public String update(@PathVariable int id,@RequestBody Order newOrder) {
		return orsps.update(id, newOrder);
	}
}


//{
//	  "name": "Nikhil Warule",
//	  "productName": "Smartphone",
//	  "productPrice": "499",
//	  "email": "john@example.com",
//	  "mobile": "1234567890",
//	  "address": "123 Street Lane",
//	  "city": "Pune",
//	  "state": "India",
//	  "payment": "Online"
//	}
