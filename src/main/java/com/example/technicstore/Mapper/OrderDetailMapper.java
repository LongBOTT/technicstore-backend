package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.Request.OrderDetailRequest;
import com.example.technicstore.DTO.Response.OrderDetailResponse;
import com.example.technicstore.entity.OrderDetail;
import com.example.technicstore.repository.VariantRepository;
import com.example.technicstore.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {

    private VariantService variantService;
    private VariantRepository variantRepository;

    public static OrderDetailResponse toDTO(OrderDetail orderDetail) {
        OrderDetailResponse orderDetailDTO = new OrderDetailResponse();
        orderDetailDTO.setId(orderDetail.getId());
        orderDetailDTO.setOrderId(orderDetail.getOrder().getId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        orderDetailDTO.setPrice(orderDetail.getPrice());
        orderDetailDTO.setTotal_amount(orderDetail.getTotal());
        orderDetailDTO.setImei(orderDetail.getImei());
        return orderDetailDTO;
    }

    public static OrderDetail toEntity(OrderDetailRequest orderDetailRequest) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(orderDetailRequest.getQuantity());
        orderDetail.setPrice(orderDetailRequest.getPrice());
        orderDetail.setTotal(orderDetailRequest.getTotal_amount());
        orderDetail.setVariantId(orderDetailRequest.getVariantId());
        return orderDetail;
    }
}
