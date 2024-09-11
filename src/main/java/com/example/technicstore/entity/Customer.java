package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`customer`")
public class Customer {

    // region Thuộc tính

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Họ và tên khách hàng với độ dài 256
    @Column(length = 256)
    private String name;

    // Email khách hàng với độ dài 256
    @Column(length = 256)
    private String email;

    // Số điện thoại khách hàng với độ dài 256
    @Column(length = 256)
    private String phone;

    // Địa chỉ khách hàng với độ dài 256
    @Column(length = 256)
    private String address;

    // Danh sách phiếu mua hàng của khách hàng

    // endregion

    // region Constructor

    public Customer() {
    }

    // endregion

    //region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //endregion
}
