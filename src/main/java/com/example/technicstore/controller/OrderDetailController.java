package com.example.technicstore.controller;

import com.example.technicstore.DTO.Request.ProductCreationRequest;
import com.example.technicstore.entity.Imei;
import com.example.technicstore.entity.OrderDetail;
import com.example.technicstore.entity.Variant;
import com.example.technicstore.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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


    // Lấy chi tiết đơn đặt hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long id) {
        Optional<OrderDetail> orderDetail = orderDetailService.getOrderDetailById(id);
        return orderDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo chi tiết đơn đặt hàng mới
    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        try {
            OrderDetail createdOrderDetail = orderDetailService.createOrderDetail(orderDetail);
            return ResponseEntity.ok(createdOrderDetail);
        } catch (Exception e) {
            e.printStackTrace(); // Log chi tiết lỗi
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Cập nhật chi tiết đơn đặt hàng

    @PutMapping("/{id}/{imeiId}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable Long id, @PathVariable Long imeiId) {
        try {
            OrderDetail updatedOrderDetail = orderDetailService.updateOrderDetail(id, imeiId);
            return ResponseEntity.ok(updatedOrderDetail);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            e.printStackTrace(); // Log chi tiết lỗi
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



}
