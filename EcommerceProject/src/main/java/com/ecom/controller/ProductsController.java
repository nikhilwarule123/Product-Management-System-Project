package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecom.entity.Products;
import com.ecom.service.ProductsService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/products/all")
public class ProductsController {

    @Autowired
    private ProductsService prsp;

    @PostMapping("/save")//http://localhost:8080/products/all/save
    public String save(@RequestBody Products p) {
    	 System.out.println("Save API called");
        return prsp.save(p);
    }

    @GetMapping("/all")//http://localhost:8080/products/all/all
    public List<Products> findAll() {
        return prsp.findAll();
    }

    @GetMapping("/{id}")//http://localhost:8080/products/all/1
    public Products findById(@PathVariable long id) {
        return prsp.findById(id);
    }
    
    @GetMapping("/findbynames/{name}")//http://localhost:8080/products/all/findbynames/anass Sharma
    public List<Products> findbyName(@PathVariable String name){
    	return prsp.findbyName(name);
    }
    
    @PutMapping("/updateprod/{id}")//http://localhost:8080/products/all/deletebyprod/2
	public String update(@PathVariable long id, @RequestBody Products newProd) {
	    return prsp.update(id, newProd);
	}
	   
	@DeleteMapping("/deletebyprod/{id}")//http://localhost:8080/products/all/updateprod/1
	public String delete(@PathVariable long id) {
	    return prsp.deletebyid(id);
	}
}
