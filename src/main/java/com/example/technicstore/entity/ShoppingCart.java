package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`shopping_cart`")
public class ShoppingCart {

    // region Thuộc tính

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // endregion
}
