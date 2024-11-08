package com.example.technicstore.DTO.Request;

public class StockReceiveDetailRequest {
    private int quantity;
    private Long stockReceiveId;

    private Long variantId;

    private Double price;

    public StockReceiveDetailRequest() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getStockReceiveId() {
        return stockReceiveId;
    }

    public void setStockReceiveId(Long stockReceiveId) {
        this.stockReceiveId = stockReceiveId;
    }

    public Long getVariantId() {
        return variantId;
    }

    public void setVariantId(Long variantId) {
        this.variantId = variantId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
