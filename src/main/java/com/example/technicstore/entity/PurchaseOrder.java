package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`purchase_order`")
public class PurchaseOrder {


    // region Attribute
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
