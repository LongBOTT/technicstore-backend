package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "`variant`")
public class Variant {


    // region Attribute
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product products;

    private double price;

    // giá nhập
    private double cost;

    // tồn kho
    private double quantity;

    //có thể bán
    private int available;

    // đang giao dịch
    private int pending;


    // hàng đang giao
    private int shipping;

    // tồn tối thiểu
    private int min;

    // tồn tối đa
    private int max;

    // xóa phiên bản
    private int deleted; // 0: chưa xóa, 1: đã xóa


    @Column(length = 4096)
    private String image;
    // endregion

    public Variant() {
    }

    // region constructor

    // endregion

    // region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }


    public int getShipping() {
        return shipping;
    }

    public void setShipping(int shipping) {
        this.shipping = shipping;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }



    // endregion
}
