package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "`shopping_cart`")
public class ShoppingCart {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Khóa ngoại đến bảng Customers
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Khóa ngoại đến bảng Products
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Số lượng sản phẩm trong giỏ hàng
    @Column(name = "quantity")
    private int quantity;

    // Thời gian thêm vào giỏ hàng
    @Column(name = "added_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime added_at;


    // endregion

    // region Constructor

    public ShoppingCart() {
    }

    //endregion

    // region  Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getAdded_at() {
        return added_at;
    }

    public void setAdded_at(LocalDateTime added_at) {
        this.added_at = added_at;
    }

    // endregion
}
