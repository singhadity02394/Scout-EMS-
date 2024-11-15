package com.scouttribe.service;

import com.scouttribe.entity.Customer;
import com.scouttribe.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Method to save a new customer
    public Customer saveCustomer(Customer customer) {
        // Save customer to database
        return customerRepository.save(customer);
    }

	public boolean finddata(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
