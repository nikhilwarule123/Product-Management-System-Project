package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Products;
import com.ecom.repository.ProductsRepository;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository prsp;

    public String save(Products p) {
        prsp.save(p);
        return "Product data added successfully";
    }

    public List<Products> findAll() {
        return prsp.findAll();
    }

    public Products findById(long id) {
        return prsp.findById(id).orElse(null);
    }
    
    public List<Products> findbyName(String name) {
    	return prsp.findByName(name);
    	
    }
    public String deletebyid(long id) {
		  prsp.deleteById(id);
		  return "Delete by id successfully";
	 }
	 
	 public String update(long id, Products newProd) {
		    Products existingProd = prsp.findById(id).orElse(null);

		    if (existingProd == null) {
		        return "Existing record not found to update";
		    }

		    if (newProd.getName() == null && newProd.getDescription() == null && newProd.getPrice() == null && newProd.getImage() == null) {
		        return "New record is empty";
		    }

		    if (newProd.getName() != null) {
		        existingProd.setName(newProd.getName());
		    }

		    if (newProd.getDescription() != null) {
		        existingProd.setDescription(newProd.getDescription());
		    }

		    if (newProd.getPrice() != null) {
		        existingProd.setPrice(newProd.getPrice());
		    }

		    if (newProd.getImage() != null) {
		        existingProd.setImage(newProd.getImage());
		    }

		    prsp.save(existingProd);
		    return "Product data updated successfully";
		}

}
