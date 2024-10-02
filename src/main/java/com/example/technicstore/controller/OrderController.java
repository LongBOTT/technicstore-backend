package com.example.technicstore.controller;

import com.example.technicstore.entity.Order;
import com.example.technicstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Lấy danh sách tất cả đơn hàng
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Lấy thông tin một đơn hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lấy danh sách đơn hàng theo trạng thái
    @GetMapping("/search/status")
    public List<Order> getOrdersByStatus(@RequestParam String status) {
        return orderService.getOrdersByStatus(status);
    }

    // Lấy danh sách đơn hàng theo khách hàng
    @GetMapping("/search/customer")
    public List<Order> getOrdersByCustomerId(@RequestParam Long customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    // Lấy danh sách đơn hàng theo ngày đặt hàng
    @GetMapping("/search/order-date")
    public List<Order> getOrdersByOrderDateBetween(@RequestParam Date startDate, @RequestParam Date  endDate) {
        return orderService.getOrdersByOrderDateBetween(startDate, endDate);
    }

    // Tạo mới một đơn hàng
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    // Cập nhật thông tin đơn hàng
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(id, order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa một đơn hàng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    // Tìm kiếm theo trạng thái đơn hàng
    @GetMapping("/search/status")
    public List<Order> findOrdersByStatus(@RequestParam String status) {
        return orderService.findOrdersByStatus(status);
    }
}
