package com.example.technicstore.DTO.Response;

import com.example.technicstore.entity.Imei;
import com.example.technicstore.entity.Variant;

import java.util.List;

public class OrderDetailResponse {
    private Long id;
    private Long orderId;

    private int quantity;
    private double price;
    private double total_amount;

    private Variant variant;
    private Imei imei;

    private List<ImeiResponse> imeis;
    public OrderDetailResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public List<ImeiResponse> getImeis() {
        return imeis;
    }

    public void setImeis(List<ImeiResponse> imeis) {
        this.imeis = imeis;
    }

    public Imei getImei() {
        return imei;
    }

    public void setImei(Imei imei) {
        this.imei = imei;
    }
}
