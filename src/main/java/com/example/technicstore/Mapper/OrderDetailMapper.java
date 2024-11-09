package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.Request.OrderDetailRequest;
import com.example.technicstore.DTO.Response.OrderDetailResponse;
import com.example.technicstore.entity.OrderDetail;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {
    public static OrderDetailResponse toDTO(OrderDetail orderDetail) {
        OrderDetailResponse orderDetailDTO = new OrderDetailResponse();
        orderDetailDTO.setId(orderDetail.getId());
        orderDetailDTO.setOrderId(orderDetail.getOrder().getId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        orderDetailDTO.setPrice(orderDetail.getPrice());
        orderDetailDTO.setTotal_amount(orderDetail.getTotal());
        return orderDetailDTO;
    }

    public static OrderDetail toEntity(OrderDetailRequest orderDetailRequest) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(orderDetailRequest.getQuantity());
        orderDetail.setPrice(orderDetailRequest.getPrice());
        orderDetail.setTotal(orderDetailRequest.getTotal_amount());
        return orderDetail;
    }
}
