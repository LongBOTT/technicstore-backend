package com.example.technicstore.DTO.Response;

import java.util.List;

public class VariantResponse {
    private Long id;
    private double costPrice;
    private String name;
    private String image;

    private double price;
    private double quantity;
    private Long productId; // Mã sản phẩm liên kết

    private String status;
    private List<VariantAttributeResponse> attributes; // Danh sách thuộc tính của phiên bản


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<VariantAttributeResponse> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<VariantAttributeResponse> attributes) {
        this.attributes = attributes;
    }

}
