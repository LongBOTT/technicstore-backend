package com.example.technicstore.service;

import com.example.technicstore.entity.Customer;
import com.example.technicstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
//        Optional<Customer> customerOptional = customerRepository.findById(id);
//        if (customerOptional.isPresent()) {
//            Customer existingCustomer = customerOptional.get();
//            existingCustomer.setFullName(updatedCustomer.getFullName());
//            existingCustomer.setEmail(updatedCustomer.getEmail());
//            existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
//            existingCustomer.setAddress(updatedCustomer.getAddress());
//            return customerRepository.save(existingCustomer);
//        }
        return null; // Hoặc có thể ném ngoại lệ
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
