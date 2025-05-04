package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	List<Products> findByName(String name);
	
}
