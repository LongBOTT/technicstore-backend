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

    public Optional<Customer> getCustomersByPhoneOrEmail(String phone, String email) {
        return customerRepository.findCustomerByPhoneOrEmail(phone, email);
    }

    public List<Customer> getCustomersByName(String name) {
        return customerRepository.findCustomerByNameContainsIgnoreCase(name);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer existingCustomer = customerOptional.get();
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPhone(updatedCustomer.getPhone());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setDistrict(updatedCustomer.getDistrict());
            existingCustomer.setCity(updatedCustomer.getCity());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> findByPhone(String phone) {
        return customerRepository.findCustomerByPhone(phone);
    }
}
