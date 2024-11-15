package com.scouttribe.repository;

import com.scouttribe.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can define custom queries if needed, for example, find by email
    // Optional<Customer> findByEmail(String email);
}

