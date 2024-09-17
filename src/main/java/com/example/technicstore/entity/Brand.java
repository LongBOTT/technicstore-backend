package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`brand`")
public class Brand {

    // region Thuộc tính

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên thương hiệu với độ dài 256
    @Column(length = 256)
    private String name;
    // endregion

    // region Constructor

    public Brand() {
    }

    // endregion

    // region
}
