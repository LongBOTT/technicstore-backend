package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`delivery_fee`")
public class DeliveryFee {


    // region Attribute
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Thanh pho
    @Column(name = "city", nullable = false)
    private String city;

    // Quan/huyen
    @Column(name = "district", nullable = true)
    private String district;

    // Chi phi van chuyen
    @Column(name = "fee", nullable = false)
    private double fee;

    // endregion

    // region Constructor

    public DeliveryFee() {
    }

    // endregion

    // region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    // endregion
}
