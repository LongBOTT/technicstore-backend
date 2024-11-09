package com.example.technicstore.DTO.Response;

import com.example.technicstore.entity.Customer;
import com.example.technicstore.entity.Order;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class OrderResponse {
    private Long id;
    private Customer customer;
    private LocalDateTime orderDate;
    private double total_amount;
    private String orderStatus;
    private String payment_status;
    private Order.PaymentMethod payment_method;
    private String note;
    private String address;
    private List<OrderDetailResponse> orderDetailResponseList;

    public OrderResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public Order.PaymentMethod getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(Order.PaymentMethod payment_method) {
        this.payment_method = payment_method;
    }
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderDetailResponse> getOrderDetailResponseList() {
        return orderDetailResponseList;
    }

    public void setOrderDetailResponseList(List<OrderDetailResponse> orderDetailResponseList) {
        this.orderDetailResponseList = orderDetailResponseList;
    }
}
