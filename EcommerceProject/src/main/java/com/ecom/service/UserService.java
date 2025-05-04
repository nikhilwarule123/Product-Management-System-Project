package com.ecom.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Products;
import com.ecom.entity.User;
import com.ecom.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository uresp;

    public List<User> findAll() {
        return uresp.findAll();
    }
    
   

    public String save(User u) {
        User existingUser = uresp.findByUsername(u.getUsername()); // ✅ fix here
        if (existingUser != null) {
            return "Username already exists. Please try another one.";
        } else {
            uresp.save(u);
            return "User registered successfully.";
        }
    }

    public User login(String username, String password) {
        User user = uresp.findByUsername(username);
        if (user != null && user.getPassword() != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
