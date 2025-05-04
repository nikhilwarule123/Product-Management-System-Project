package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Login;
import com.ecom.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository lserp;
	
	public String save(Login l) {
		lserp.save(l);
		return "login save data sucessfully";
		
	}
	
	public List findall() {
		return lserp.findAll();
	}
	

}
