package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.Request.OrderRequest;
import com.example.technicstore.DTO.Response.OrderResponse;
import com.example.technicstore.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public static OrderResponse toDTO(Order order) {
        OrderResponse orderDTO = new OrderResponse();
        orderDTO.setId(order.getId());
        orderDTO.setCustomer(order.getCustomer());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotal_amount(order.getTotal_amount());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setPayment_status(order.getPayment_status());
        orderDTO.setPayment_method(order.getPayment_method());
        orderDTO.setNote(order.getNote());
        orderDTO.setAddress(order.getAddress();
        return orderDTO;
    }

    public static  Order toEntity(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderStatus(orderRequest.getOrderStatus());
        order.setPayment_status(orderRequest.getPayment_status());
        order.setOrderDate(orderRequest.getOrderDate());
        order.setTotal_amount(orderRequest.getTotal_amount());
        order.setNote(orderRequest.getNote());
        order.setAddress(orderRequest.getAddress());
        return order;
    }
}
