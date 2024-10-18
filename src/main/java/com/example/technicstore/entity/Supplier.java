package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "`supplier`")
public class Supplier {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên nhà cung cấp với độ dài 256
    @Column(length = 256)
    private String name;

    // Email nhà cung cấp với độ dài 256
    @Column(length = 256)
    private String email;

    // Số điện thoại nhà cung cấp với độ dài 256
    @Column(length = 256)
    private String phone;

    // Địa chỉ nhà cung cấp với độ dài 256
    @Column(length = 256)
    private String address;
    private String status;

    // endregion

    // region Constructor

    public Supplier() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//endregion
}
