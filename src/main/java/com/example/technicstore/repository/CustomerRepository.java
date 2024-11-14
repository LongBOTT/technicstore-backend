package com.example.technicstore.repository;

import com.example.technicstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Tìm kiếm theo số điện thoại hoặc email
    Optional<Customer> findCustomerByPhoneOrEmail(String phone, String email);

    // Tìm kiếm gần đúng theo tên khách hàng
    List<Customer> findCustomerByNameContainsIgnoreCase(String name);

    Optional<Customer> findCustomerByPhone(String phone);
}
