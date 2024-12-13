package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "`review`")
public class Review {

    // region Attributes
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Khóa ngoại đến bảng Variants
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Khóa ngoại đến bảng Accounts
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Đánh giá sản phẩm (từ 1 đến 5)
    @Column(name = "rating")
    private int rating;

    // Bình luận của khách hàng về sản phẩm
    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    // Thời gian tạo đánh giá
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;
    //endregion

    // region constructor

    public Review() {
    }

    // endregion

    // region Getter and Setter

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }


    //endregion
}
