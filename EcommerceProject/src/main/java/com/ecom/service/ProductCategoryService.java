package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.ProductCategory;
import com.ecom.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {
	@Autowired
	ProductCategoryRepository pcrs;

	public String save(ProductCategory pc) {
		pcrs.save(pc);
		return "ProductCategory save data sucessfully";
	}

	public List findall() {
		return pcrs.findAll();
	}

}
