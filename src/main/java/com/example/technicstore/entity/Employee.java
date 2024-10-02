package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`employee`")
public class Employee {
    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên nhân viên với độ dài 256
    @Column(length = 256)
    private String name;

    // căng cước công dân
    @Column(length = 256)
    private String idCard;

    // Email nhân viên với độ dài 256
    @Column(length = 256)
    private String email;

    // Số điện thoại nhân viên với độ dài 256
    @Column(length = 256)
    private String phone;

    // Địa chỉ nhân viên với độ dài 256
    @Column(length = 256)
    private String address;

    public Employee() {
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }



}
