package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Customer; // Assuming Student was renamed to Customer

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Define any additional methods if needed
}
