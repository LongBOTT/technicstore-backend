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
    private StockReceive stock_receive;

    // Phien bản đặt hàng
    @ManyToOne
    @JoinColumn(name = "variant_id")
    private Variant variant;

    private int quantity;
    private double unit_price;
    private String unit;
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

    public StockReceive getStock_receive() {
        return stock_receive;
    }

    public void setStock_receive(StockReceive stock_receive) {
        this.stock_receive = stock_receive;
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

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
// endregion
}
