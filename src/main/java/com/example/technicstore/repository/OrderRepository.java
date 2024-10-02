package com.example.technicstore.repository;

import com.example.technicstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Tìm kiếm đơn hàng theo trạng thái
    List<Order> findOrdersByOrderStatus(String status);

    // Tìm kiếm đơn hàng theo khách hàng
    List<Order> findOrdersByCustomerId(Long customerId);

    // Tìm kiếm đơn hàng theo ngày đặt hàng
    List<Order> findOrdersByOrderDateBetween(Date startDate, Date endDate);


}
