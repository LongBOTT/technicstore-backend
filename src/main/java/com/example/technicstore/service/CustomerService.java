package com.example.technicstore.service;

import com.example.technicstore.DTO.Response.CustomerResponse;
import com.example.technicstore.DTO.Response.OrderDetailResponse;
import com.example.technicstore.DTO.Response.OrderResponse;
import com.example.technicstore.Mapper.CustomerMapper;
import com.example.technicstore.Mapper.OrderDetailMapper;
import com.example.technicstore.Mapper.OrderMapper;
import com.example.technicstore.entity.Customer;
import com.example.technicstore.entity.Order;
import com.example.technicstore.entity.OrderDetail;
import com.example.technicstore.entity.Variant;
import com.example.technicstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private VariantService variantService;

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

    public List<CustomerResponse> getCustomerResponse() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerResponse customerResponse = CustomerMapper.toDTO(customer);
            List<Order> orders = orderService.getOrdersByCustomerId(customer.getId());
            List orderResponses = new ArrayList<>();
            for (Order order : orders) {
                OrderResponse orderResponse = OrderMapper.toDTO(order);
                List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
                List<OrderDetail> orderDetails = orderDetailService.getOrderDetailsByOrderId(order.getId());
                for (OrderDetail orderDetail : orderDetails) {
                    OrderDetailResponse orderDetailResponse = OrderDetailMapper.toDTO(orderDetail);
                    Variant variant = variantService.getVariantById(orderDetail.getVariantId()).orElseThrow(() -> new RuntimeException("Variant not found"));
                    orderDetailResponse.setVariant(variant);
                    orderDetailResponses.add(orderDetailResponse);
                }
                orderResponse.setOrderDetailResponseList(orderDetailResponses);
                orderResponses.add(orderResponse);
            }
            customerResponse.setOrders(orderResponses);
            customerResponses.add(customerResponse);
        }
        return customerResponses;
    }
}
