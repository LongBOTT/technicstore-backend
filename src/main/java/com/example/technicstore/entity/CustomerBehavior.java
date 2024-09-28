package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`customer_behavior`")
public class CustomerBehavior {

    // region Attribute
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // IP thiết bị truy cập
    private String IP;

    // Tên sản phẩm quan tâm gần nhất
    private String last_related_product;

    // endregion

    // region Constructor

    public CustomerBehavior() {
    }

    // endregion

    // region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getLast_related_product() {
        return last_related_product;
    }

    public void setLast_related_product(String last_related_product) {
        this.last_related_product = last_related_product;
    }

    // endregion
}
