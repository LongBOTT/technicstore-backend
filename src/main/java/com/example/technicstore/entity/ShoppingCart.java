package com.example.technicstore.entity;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Var;

import java.time.LocalDateTime;

@Entity
@Table(name = "`shopping_cart`")
public class ShoppingCart {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Khóa ngoại đến bảng accounts
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Khóa ngoại đến bảng Products
    @ManyToOne
    @JoinColumn(name = "variant_id")
    private Variant variant;

    // Số lượng sản phẩm trong giỏ hàng
    @Column(name = "quantity")
    private int quantity;

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    // endregion
}
