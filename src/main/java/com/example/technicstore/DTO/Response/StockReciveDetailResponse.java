package com.example.technicstore.DTO.Response;

import com.example.technicstore.entity.Imei;

import java.util.List;

public class StockReciveDetailResponse {
    private Long id;
    private int quantity;
    private Double price;

    private Long stockReceiveId;
    private VariantResponse variantResponse;
    private List<ImeiResponse> imeiResponses;
    public StockReciveDetailResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getStockReceiveId() {
        return stockReceiveId;
    }

    public void setStockReceiveId(Long stockReceiveId) {
        this.stockReceiveId = stockReceiveId;
    }

    public VariantResponse getVariantResponse() {
        return variantResponse;
    }

    public void setVariantResponse(VariantResponse variantResponse) {
        this.variantResponse = variantResponse;
    }

    public List<ImeiResponse> getImeiResponses() {
        return imeiResponses;
    }

    public void setImeiResponses(List<ImeiResponse> imeiResponses) {
        this.imeiResponses = imeiResponses;
    }
}
