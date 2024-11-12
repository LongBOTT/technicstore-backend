package com.example.technicstore.repository;

import com.example.technicstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Tìm kiếm đơn hàng theo id
    Order findOrderById(Long id);

    // Tìm kiếm đơn hàng theo trạng thái
    List<Order> findOrdersByOrderStatus(String status);

    // Tìm kiếm đơn hàng theo khách hàng
    List<Order> findOrdersByCustomerId(Long customerId);

    // Tìm kiếm đơn hàng theo ngày đặt hàng
    List<Order> findOrdersByOrderDateBetween(Date startDate, Date endDate);


    // Tìm kiếm đơn hàng theo phương thức thanh toán
    @Query("SELECT o FROM Order o WHERE o.payment_method = :paymentMethod")
    List<Order> findOrdersByPaymentMethod(@Param("paymentMethod") Order.PaymentMethod paymentMethod);

    // Tìm kiếm đơn hàng theo id đơn hàng hoặc tên khách hàng hoặc số điện thoại
    @Query("SELECT o FROM Order o WHERE " +
            "CAST(o.id AS string) LIKE CONCAT('%', :search, '%') OR " +
            "o.customer.name LIKE CONCAT('%', :search, '%') OR " +
            "o.phone LIKE CONCAT('%', :search, '%')")
    List<Order> searchOrders(@Param("search") String search);


}
