package com.example.technicstore.service;

import com.example.technicstore.DTO.Response.ImeiResponse;
import com.example.technicstore.DTO.Response.OrderDetailResponse;
import com.example.technicstore.DTO.Response.OrderResponse;
import com.example.technicstore.Mapper.ImeiMapper;
import com.example.technicstore.Mapper.OrderDetailMapper;
import com.example.technicstore.Mapper.OrderMapper;
import com.example.technicstore.entity.*;
import com.example.technicstore.repository.CustomerRepository;
import com.example.technicstore.repository.OrderDetailRepository;
import com.example.technicstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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


}
