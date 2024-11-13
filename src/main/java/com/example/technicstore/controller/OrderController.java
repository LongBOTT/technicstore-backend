package com.example.technicstore.controller;

import com.example.technicstore.DTO.Response.OrderResponse;
import com.example.technicstore.entity.Customer;
import com.example.technicstore.entity.Order;
import com.example.technicstore.service.CustomerService;
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
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    // Lấy danh sách tất cả đơn hàng
    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrderResponse();
    }

    // Lấy thông tin một đơn hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lấy thông tin một đơn hàng theo ID
    @GetMapping("getOrderResponseById/{id}")
    public ResponseEntity<OrderResponse> getOrderResponseById(@PathVariable Long id) {
        OrderResponse orderResponse = orderService.getOrderResponseById(id);
        if (orderResponse != null) {
            return ResponseEntity.ok(orderResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Lấy danh sách đơn hàng theo trạng thái
    @GetMapping("/search/status")
    public List<OrderResponse> getOrdersByStatus(@RequestParam String status) {
        return orderService.getOrdersByStatus(status);
    }

    // Lấy danh sách đơn hàng theo phương thức thanh toán
    @GetMapping("/search/payment_method")
    public List<OrderResponse> getOrdersByPaymentMethod(@RequestParam String paymentMethod) {
        return orderService.getOrdersByPaymentMethod(paymentMethod);
    }
    @GetMapping("/search/findOrdersByKeyword")
    public List<OrderResponse> findOrdersByKeyword(@RequestParam String search) {
        return orderService.findOrdersByKeyword(search);
    }

    // Lấy danh sách đơn hàng theo khách hàng
    @GetMapping("/search/customer")
    public List<Order> getOrdersByCustomerId(@RequestParam Long customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    // Lấy danh sách đơn hàng theo ngày đặt hàng
    @GetMapping("/search/order_date")
    public List<Order> getOrdersByOrderDateBetween(@RequestParam Date startDate, @RequestParam Date endDate) {
        return orderService.getOrdersByOrderDateBetween(startDate, endDate);
    }

    // Tạo mới một đơn hàng
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        System.out.println("Received Order: " + order); // Log dữ liệu
        // Kiểm tra nếu thông tin khách hàng không có hoặc số điện thoại trống
        if (order.getCustomer() == null || order.getCustomer().getPhone() == null || order.getCustomer().getPhone().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Trả về lỗi nếu không có thông tin khách hàng hoặc số điện thoại
        }

        // Tìm kiếm khách hàng dựa trên số điện thoại
        Optional<Customer> existingCustomer = customerService.findByPhone(order.getCustomer().getPhone());

        if (existingCustomer.isPresent()) {
            // Nếu khách hàng đã tồn tại, thiết lập khách hàng vào order
            order.setCustomer(existingCustomer.get());
        } else {
            // Nếu khách hàng chưa tồn tại, tạo mới khách hàng
            Customer newCustomer = customerService.createCustomer(order.getCustomer());
            order.setCustomer(newCustomer);
        }

        // Tạo đơn hàng
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


}
