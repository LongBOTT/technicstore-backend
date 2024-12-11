package com.example.technicstore.repository;

import com.example.technicstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

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


    // Tính doanh thu: Các đơn hàng đã thanh toán và không có trạng thái 'Đã hủy' và 'Trả hàng' trong ngày hôm nay
    @Query("SELECT SUM(o.total_amount) FROM Order o WHERE o.payment_status = 'Đã thanh toán' AND o.orderStatus NOT IN ('Đã hủy', 'Trả hàng') AND DATE(o.orderDate) = CURRENT_DATE")
    Double calculateRevenue();

    // Đếm số đơn hàng mới trong ngày hôm nay (trạng thái 'Chờ duyệt')
    @Query("SELECT COUNT(o) FROM Order o WHERE o.orderStatus = 'Chờ duyệt' AND DATE(o.orderDate) = CURRENT_DATE")
    Long countNewOrdersToday();

    // Đếm số đơn hàng hủy trong ngày hôm nay (trạng thái 'Đã hủy')
    @Query("SELECT COUNT(o) FROM Order o WHERE o.orderStatus = 'Đã hủy' AND DATE(o.orderDate) = CURRENT_DATE")
    Long countCanceledOrdersToday();

    // Đếm số đơn hàng trả hàng trong ngày hôm nay (trạng thái 'Trả hàng')
    @Query("SELECT COUNT(o) FROM Order o WHERE o.orderStatus = 'Trả hàng' AND DATE(o.orderDate) = CURRENT_DATE")
    Long countReturnedOrdersToday();

    // Tính doanh thu trong 7 ngày gần nhất
    @Query("SELECT DATE(o.orderDate), SUM(o.total_amount) FROM Order o " +
            "WHERE o.payment_status = 'Đã thanh toán' AND o.orderStatus NOT IN ('Đã hủy', 'Trả hàng') " +
            "AND o.orderDate >= :startDate " + // Dùng tham số cho ngày bắt đầu
            "GROUP BY DATE(o.orderDate) ORDER BY DATE(o.orderDate) DESC")
    List<Object[]> calculateRevenueLast7Days(@Param("startDate") LocalDateTime startDate);

    // Top 5 sản phẩm bán chạy trong ngày hiện tại
    @Query("SELECT v.name, SUM(od.quantity) FROM OrderDetail od " +
            "JOIN Variant v ON od.variantId = v.id " +
            "WHERE DATE(od.order.orderDate) = CURRENT_DATE " +
            "GROUP BY v.name ORDER BY SUM(od.quantity) DESC")
    List<Object[]> getTopSellingProductsToday();


    // Top 5 thể loại bán chạy trong ngày hiện tại
    @Query("SELECT c.name, SUM(od.quantity) FROM OrderDetail od " +
            "JOIN Variant v ON od.variantId = v.id " +
            "JOIN v.products p " +
            "JOIN p.category c " +
            "WHERE DATE(od.order.orderDate) = CURRENT_DATE " +
            "GROUP BY c.name ORDER BY SUM(od.quantity) DESC")
    List<Object[]> getTopSellingCategoriesToday();

    // Truy vấn để lấy tổng đơn hàng, doanh thu, giá vốn, lợi nhuận trong khoảng thời gian
    @Query("SELECT COUNT(o), SUM(o.total_amount), SUM(od.price * od.quantity), SUM((od.price - v.costPrice) * od.quantity) " +
            "FROM Order o JOIN o.orderDetails od " +
            "JOIN Variant v ON od.variantId = v.id " +
            "WHERE o.orderDate >= :startDate AND o.orderDate <= :endDate " +
            "AND o.orderStatus NOT IN ('Đã hủy', 'Trả hàng')")
    Object[] getStatisticsBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);



    // Truy vấn để lấy thông tin từng ngày trong khoảng thời gian
    @Query("SELECT o.orderDate, COUNT(o), SUM(CASE WHEN o.paymentMethod = 'Cash' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN o.paymentMethod = 'BankTransfer' THEN 1 ELSE 0 END), SUM(od.quantity), SUM(o.total_amount), " +
            "SUM(od.price * od.quantity), SUM((od.price - v.costPrice) * od.quantity) " +
            "FROM Order o JOIN o.orderDetails od " +
            "JOIN Variant v ON od.variantId = v.id"+
            "WHERE o.orderDate >= :startDate AND o.orderDate <= :endDate "+
            "AND o.orderStatus NOT IN ('Đã hủy', 'Trả hàng') " +
            "GROUP BY DATE(o.orderDate")
    List<Object[]> getDailyStatistics(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
