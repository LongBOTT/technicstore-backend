package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "`stock_receive_detail`")
public class StockReceiveDetail {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stock_receive_id")
    private StockReceive stockReceive;

    // Phien bản đặt hàng
    @ManyToOne
    @JoinColumn(name = "variant_id")
    private Variant variant;

    private int quantity;
    private double price;

    // endregion

    // region Constructor

    public StockReceiveDetail() {
    }

    // endregion

    // region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StockReceive getStockReceive() {
        return stockReceive;
    }

    public void setStockReceive(StockReceive stockReceive) {
        this.stockReceive = stockReceive;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

// endregion
}
