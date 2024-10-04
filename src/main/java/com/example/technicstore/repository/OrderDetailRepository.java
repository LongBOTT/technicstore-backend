package com.example.technicstore.repository;

import com.example.technicstore.entity.Imei;
import com.example.technicstore.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    // Tìm kiếm theo đơn hàng
    List<OrderDetail> findByOrderId(Long orderId);


}
