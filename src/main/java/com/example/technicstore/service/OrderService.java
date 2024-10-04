package com.example.technicstore.service;

import com.example.technicstore.entity.Order;
import com.example.technicstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Lấy tất cả đơn hàng
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Lấy đơn hàng theo ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Lấy đơn hàng theo trạng thái
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findOrdersByOrderStatus(status);
    }

    // Lấy đơn hàng theo khách hàng
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findOrdersByCustomerId(customerId);
    }

    // Lấy đơn hàng theo ngày đặt hàng
    public List<Order> getOrdersByOrderDateBetween(Date startDate, Date endDate) {
        return orderRepository.findOrdersByOrderDateBetween(startDate, endDate);
    }
    // Tạo mới một đơn hàng
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Cập nhật thông tin đơn hàng
    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order existingOrder = orderOptional.get();
            existingOrder.setCustomer(updatedOrder.getCustomer());
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            existingOrder.setTotal_amount(updatedOrder.getTotal_amount());
            existingOrder.setDelivery_fee(updatedOrder.getDelivery_fee());
            existingOrder.setOrderStatus(updatedOrder.getOrderStatus());
            existingOrder.setPayment_status(updatedOrder.getPayment_status());
            existingOrder.setDelivery_status(updatedOrder.getDelivery_status());
            existingOrder.setCod_status(updatedOrder.getCod_status());
            existingOrder.setCarrier(updatedOrder.getCarrier());
            existingOrder.setOrder_details(updatedOrder.getOrder_details());
            existingOrder.setPayment_method(updatedOrder.getPayment_method());
            existingOrder.setNote(updatedOrder.getNote());
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    // Xóa một đơn hàng
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }


}
