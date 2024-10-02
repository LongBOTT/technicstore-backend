package com.example.technicstore.service;

import com.example.technicstore.entity.Imei;
import com.example.technicstore.entity.OrderDetail;
import com.example.technicstore.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    // Tìm kiếm chi tiết theo đơn hàng
    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    // Tìm kiếm chi tiết đơn đặt hàng theo ID
    public Optional<OrderDetail> getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id);
    }

    // Tìm kiếm chi tiết đơn đặt hàng theo IMEI
    public List<OrderDetail> getOrderDetailsByImei(Imei imei) {
        return orderDetailRepository.findByImei(imei);
    }



    // Tạo chi tiết đơn đặt hàng mới
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }
}
