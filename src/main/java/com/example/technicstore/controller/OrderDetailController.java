package com.example.technicstore.controller;

import com.example.technicstore.entity.Imei;
import com.example.technicstore.entity.OrderDetail;
import com.example.technicstore.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    // Tìm kiếm chi tiết theo đơn hàng
    @GetMapping("/order/{orderId}")
    public List<OrderDetail> getOrderDetailsByOrderId(@PathVariable Long orderId) {
        return orderDetailService.getOrderDetailsByOrderId(orderId);
    }

    // Tìm kiếm chi tiết đơn đặt hàng theo IMEI
    @GetMapping("/imei/{imei}")
    public List<OrderDetail> getOrderDetailsByImei(@PathVariable Imei imei) {
        return orderDetailService.getOrderDetailsByImei(imei);
    }

    // Lấy chi tiết đơn đặt hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long id) {
        Optional<OrderDetail> orderDetail = orderDetailService.getOrderDetailById(id);
        return orderDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo chi tiết đơn đặt hàng mới
    @PostMapping
    public OrderDetail createOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.createOrderDetail(orderDetail);
    }


}
