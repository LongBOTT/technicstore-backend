package com.example.technicstore.repository;

import com.example.technicstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Tìm kiếm theo số điện thoại
    List<Customer> findCustomerByPhoneOrEmail(String phone, String email);
}
