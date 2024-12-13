package com.example.technicstore.service;

import com.example.technicstore.entity.Imei;
import com.example.technicstore.entity.OrderDetail;
import com.example.technicstore.entity.StockReceiveDetail;
import com.example.technicstore.entity.Variant;
import com.example.technicstore.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Autowired
    private ImeiService imeiService;

    @Autowired
    private VariantService variantService;

    @Autowired
    private StockReceiveDetailService stockReceiveDetailService;
    // Tìm kiếm chi tiết theo đơn hàng
    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    // Tìm kiếm chi tiết đơn đặt hàng theo ID
    public Optional<OrderDetail> getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id);
    }



    // Tạo chi tiết đơn đặt hàng mới
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public OrderDetail updateOrderDetail(Long id, Long imeiId) {
        Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findById(id);
        if (orderDetailOptional.isPresent()) {
            OrderDetail orderDetail = orderDetailOptional.get();
            Imei imei = imeiService.getImeiById(imeiId)
                    .orElseThrow(() -> new RuntimeException("IMEI không tồn tại"));
            orderDetail.setImei(imei);
            imeiService.updateImeiStatus(imeiId);

            Variant variant = variantService.getVariantById(imei.getStockReceiveDetail().getVariant().getId()).orElseThrow(() -> new RuntimeException("Variant khong ton tai"));
            System.out.println("name: " + variant.getName());
            System.out.println("id"+variant.getId());
            double quantity = variant.getQuantity()-1;
            System.out.println("quantity: " + quantity);
            variantService.updateVariantQuantity(variant.getId(),variant.getQuantity()-1);
            return orderDetailRepository.save(orderDetail);
        }
        throw new RuntimeException("OrderDetail không tồn tại");
    }

}
