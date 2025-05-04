package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.ProductCategory;
import com.ecom.service.ProductCategoryService;

@RestController
@RequestMapping("/productcategory")
@CrossOrigin

public class ProductCategoryController {
	@Autowired 
	ProductCategoryService pcrv;
	
	@PostMapping("/savepc")//http://localhost:8080/productcategory/savepc
	public String save(@RequestBody ProductCategory pc) {
		
		return pcrv.save(pc);
	}
	
	@GetMapping("/findalls")//http://localhost:8080/productcategory/findalls
	public List findall() {
		return pcrv.findall();
	}
	

}

//{
//	   "productid":"1",
//	   "productcategory":"Mobile",
//	   "status":"Active",
//	   "created":"12-04-25",
//	   "updated":"13-04-25"
//	}
