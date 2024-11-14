package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.Response.CustomerResponse;
import com.example.technicstore.entity.Customer;

public class CustomerMapper {
    public static CustomerResponse toDTO(Customer customer) {
        CustomerResponse customerDTO = new CustomerResponse();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setDistrict(customer.getDistrict());
        customerDTO.setCity(customer.getCity());
        return customerDTO;
    }


}
