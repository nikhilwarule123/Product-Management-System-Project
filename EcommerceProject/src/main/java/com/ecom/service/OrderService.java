package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Order;
import com.ecom.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orsp;

	public String save(Order o) {
		orsp.save(o);
		return "Order save data sucessfully";
	}

	public List findll() {
		return orsp.findAll();
	}

	public String deleteById(int id) {
		if (orsp.existsById(id)) { // Check if the order exists
			orsp.deleteById(id); // Delete the order by ID
			return "Order deleted successfully";
		} else {
			return "Order not found";
		}

	}
	
	  // Update order by ID
	public String update(int id, Order newOrder) {
	    Order existingOrder = orsp.findById(id).orElse(null);

	    if (existingOrder == null) {
	        return "Existing order not found to update";
	    }

	    if (newOrder.getName() != null) {
	        existingOrder.setName(newOrder.getName());
	    }
	    if (newOrder.getProduct_name() != null) {
	        existingOrder.setProduct_name(newOrder.getProduct_name());
	    }
	    if (newOrder.getProduct_price() != null) {
	        existingOrder.setProduct_price(newOrder.getProduct_price());
	    }
	    if (newOrder.getEmail() != null) {
	        existingOrder.setEmail(newOrder.getEmail());
	    }
	    if (newOrder.getMobile() != null) {
	        existingOrder.setMobile(newOrder.getMobile());
	    }
	    if (newOrder.getAddress() != null) {
	        existingOrder.setAddress(newOrder.getAddress());
	    }
	    if (newOrder.getCity() != null) {
	        existingOrder.setCity(newOrder.getCity());
	    }
	    if (newOrder.getState() != null) {
	        existingOrder.setState(newOrder.getState());
	    }
	    if (newOrder.getPayment() != null) {
	        existingOrder.setPayment(newOrder.getPayment());
	    }
	    // ✅ Add this block to update status
	    if (newOrder.getStatus() != null) {
	        existingOrder.setStatus(newOrder.getStatus());
	    }

	    orsp.save(existingOrder);
	    return "Order updated successfully";
	}

}
