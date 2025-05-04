package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Products;
import com.ecom.service.ProductsService;

@RestController
@RequestMapping("/admin/prod")
public class AdminController {
	@Autowired
	ProductsService prsp;
	
	@GetMapping("/getallprod")//http://localhost:8080/admin/prod/getallprod
	public List Products() {
		return prsp.findAll();
	}
	
	@PostMapping("/saveprod")//http://localhost:8080/admin/prod/saveprod
	 public String save(@RequestBody Products p) {
       return prsp.save(p);
   }

	 @GetMapping("/{id}")//http://localhost:8080/admin/prod/1
	    public Products findById(@PathVariable long id) {
	        return prsp.findById(id);
	    }
	 
	 @GetMapping("/findbynames/{name}")//http://localhost:8080/admin/prod/findbynames/amit Sharma
	    public List<Products> findbyName(@PathVariable String name){
	    	return prsp.findbyName(name);
	    }
	    
	    
	 @PutMapping("/updateprod/{id}")//http://localhost:8080/admin/prod/updateprod/2
		public String update(@PathVariable long id, @RequestBody Products newProd) {
		    return prsp.update(id, newProd);
		}
		   
		@DeleteMapping("/deletebyprod/{id}")//http://localhost:8080/admin/prod/deletebyprod/25
		public String delete(@PathVariable long id) {
		    return prsp.deletebyid(id);
		}
}
