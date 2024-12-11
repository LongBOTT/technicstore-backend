package com.example.technicstore.service;

import com.example.technicstore.DTO.Response.ImeiResponse;
import com.example.technicstore.DTO.Response.OrderDetailResponse;
import com.example.technicstore.DTO.Response.OrderResponse;
import com.example.technicstore.DTO.Response.OrderStatisticsDTO;
import com.example.technicstore.Mapper.ImeiMapper;
import com.example.technicstore.Mapper.OrderDetailMapper;
import com.example.technicstore.Mapper.OrderMapper;
import com.example.technicstore.entity.*;
import com.example.technicstore.repository.CustomerRepository;
import com.example.technicstore.repository.OrderDetailRepository;
import com.example.technicstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VariantService variantService;

    @Autowired
    private StockReceiveDetailService stockReceiveDetailService;

    @Autowired
    private ImeiService imeiService;

    // Lấy tất cả đơn hàng
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Lấy đơn hàng theo ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }


    // Lấy đơn hàng theo khách hàng
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findOrdersByCustomerId(customerId);
    }

    // Lấy đơn hàng theo ngày đặt hàng
    public List<Order> getOrdersByOrderDateBetween(Date startDate, Date endDate) {
        return orderRepository.findOrdersByOrderDateBetween(startDate, endDate);
    }

    public Optional<Customer> findByPhone(String phone) {
        return customerRepository.findCustomerByPhone(phone);
    }

    // Tạo mới một đơn hàng
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<OrderResponse> getAllOrderResponse() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            OrderResponse orderResponse = OrderMapper.toDTO(order);
            orderResponses.add(orderResponse);
        }
        return orderResponses;
    }


    // Lấy đơn hàng theo trạng thái
    public List<OrderResponse> getOrdersByStatus(String status) {
        List<Order> orders = orderRepository.findOrdersByOrderStatus(status);
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            OrderResponse orderResponse = OrderMapper.toDTO(order);
            orderResponses.add(orderResponse);
        }
        return orderResponses;
    }

    public List<OrderResponse> findOrdersByKeyword(String keyword) {
        List<Order> orders = orderRepository.searchOrders(keyword);
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            OrderResponse orderResponse = OrderMapper.toDTO(order);
            orderResponses.add(orderResponse);
        }
        return orderResponses;
    }


    // Lấy đơn hàng theo phương thức thanh toán
    public List<OrderResponse> getOrdersByPaymentMethod(String paymentMethod) {
        // Chuyển đổi từ chuỗi sang enum PaymentMethod
        Order.PaymentMethod method;
        try {
            method = Order.PaymentMethod.valueOf(paymentMethod);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Phương thức thanh toán không hợp lệ: " + paymentMethod);
        }

        // Sử dụng phương thức tìm kiếm của repository
        List<Order> orders = orderRepository.findOrdersByPaymentMethod(method);
        List<OrderResponse> orderResponses = new ArrayList<>();

        // Chuyển đổi mỗi Order sang OrderResponse
        for (Order order : orders) {
            OrderResponse orderResponse = OrderMapper.toDTO(order);
            orderResponses.add(orderResponse);
        }

        return orderResponses;
    }

    public OrderResponse getOrderResponseById(Long id) {
        Order order = orderRepository.findOrderById(id);
        OrderResponse orderResponse = OrderMapper.toDTO(order);
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(id);
        List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            OrderDetailResponse orderDetailResponse = OrderDetailMapper.toDTO(orderDetail);
            Optional<Variant> variant = variantService.getVariantById(orderDetail.getVariantId());
            orderDetailResponse.setVariant(variant.get());
            List<StockReceiveDetail> stockReceiveDetails = stockReceiveDetailService.findStockReceiveDetailsByVariant_Id(orderDetail.getVariantId());
            for (StockReceiveDetail stockReceiveDetail : stockReceiveDetails) {
                if (stockReceiveDetail.getId() != null) {
                    List<Imei> imeis = imeiService.getImeisByStockReceiveDetailId(stockReceiveDetail.getId());
                    List<ImeiResponse> imeisResponses = new ArrayList<>();
                    for (Imei imei : imeis) {
                        if ("available".equals(imei.getStatus())) {
                            ImeiResponse imeiResponse = ImeiMapper.toDTO(imei);
                            imeisResponses.add(imeiResponse);
                        }
                    }
                    orderDetailResponse.setImeis(imeisResponses);
                }
            }

            orderDetailResponses.add(orderDetailResponse);
        }
        orderResponse.setOrderDetailResponseList(orderDetailResponses);
        return orderResponse;
    }

    // Cập nhật thông tin đơn hàng
    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order existingOrder = orderOptional.get();
            existingOrder.setCustomer(updatedOrder.getCustomer());
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            existingOrder.setTotal_amount(updatedOrder.getTotal_amount());
            existingOrder.setOrderStatus(updatedOrder.getOrderStatus());
            existingOrder.setPayment_status(updatedOrder.getPayment_status());
//            existingOrder.setOrder_details(updatedOrder.getOrder_details());
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

    public OrderStatisticsDTO getOrderStatistics() {


        // Tính doanh thu trong ngày hôm nay
        Double revenue = orderRepository.calculateRevenue();

        // Tính số lượng đơn hàng mới trong ngày hôm nay
        Long newOrders = orderRepository.countNewOrdersToday();

        // Tính số lượng đơn hàng bị hủy trong ngày hôm nay
        Long canceledOrders = orderRepository.countCanceledOrdersToday();

        // Tính số lượng đơn hàng trả lại trong ngày hôm nay
        Long returnedOrders = orderRepository.countReturnedOrdersToday();

        // Tính toán ngày bắt đầu (7 ngày trước)
        LocalDateTime startDate = LocalDate.now().minusDays(7).atStartOfDay();

        // Tính doanh thu trong 7 ngày gần nhất
        List<Object[]> revenueLast7Days = orderRepository.calculateRevenueLast7Days(startDate);

        // Top 5 sản phẩm bán chạy trong ngày hôm nay
        List<Object[]> topSellingProductsToday = orderRepository.getTopSellingProductsToday();

        // Top 5 thể loại bán chạy trong ngày hôm nay
        List<Object[]> topSellingCategoriesToday = orderRepository.getTopSellingCategoriesToday();

        // Trả về kết quả thống kê dưới dạng DTO
        return new OrderStatisticsDTO(revenue, newOrders, canceledOrders, returnedOrders, revenueLast7Days, topSellingProductsToday, topSellingCategoriesToday);
    }

    public Map<String, Object> getOrderStatistics(LocalDateTime startDate, LocalDateTime endDate) {
        // Lấy tổng quan
        Object[] summaryStats = orderRepository.getStatisticsBetweenDates(startDate, endDate);

        // Kiểm tra nếu summaryStats là null hoặc không có đủ 4 phần tử
        if (summaryStats == null || summaryStats.length < 4) {
            summaryStats = new Object[]{0L, 0.0, 0.0, 0.0}; // Gán giá trị mặc định là 0
        }

        // Lấy thống kê theo ngày
        List<Object[]> dailyStats = orderRepository.getDailyStatistics(startDate, endDate);

        // Tạo response data
        Map<String, Object> response = new HashMap<>();
        response.put("totalOrders", summaryStats[0]);
        response.put("totalRevenue", summaryStats[1]);
        response.put("totalCostPrice", summaryStats[2]);
        response.put("totalProfit", summaryStats[3]);

        // Xử lý thống kê theo ngày
        List<Map<String, Object>> dailyData = new ArrayList<>();
        for (Object[] daily : dailyStats) {
            Map<String, Object> dailyMap = new HashMap<>();
            dailyMap.put("date", daily[0]);
            dailyMap.put("totalOrders", daily[1]);
            dailyMap.put("cashOrders", daily[2]);
            dailyMap.put("bankTransferOrders", daily[3]);
            dailyMap.put("totalQuantity", daily[4]);
            dailyMap.put("totalRevenue", daily[5]);
            dailyMap.put("totalCostPrice", daily[6]);
            dailyMap.put("totalProfit", daily[7]);
            dailyData.add(dailyMap);
        }

        response.put("dailyStats", dailyData);
        return response;
    }

}
