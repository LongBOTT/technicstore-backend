package com.example.technicstore.DTO;

import java.util.List;

public class VariantDTO {
    private Long id;
    private double costPrice;
    private String name;
    private String image;
    private double minStock;
    private double available;
    private double price;
    private double quantity;
    private Long productId; // Mã sản phẩm liên kết
    private List<VariantAttributeDTO> attributes; // Danh sách thuộc tính của phiên bản
    // Constructor, Getters, và Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getMinStock() {
        return minStock;
    }

    public void setMinStock(double minStock) {
        this.minStock = minStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    public List<VariantAttributeDTO> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<VariantAttributeDTO> attributes) {
        this.attributes = attributes;
    }

}
