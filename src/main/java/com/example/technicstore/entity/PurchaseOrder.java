package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`purchase_order`")
public class PurchaseOrder {


    // region Attribute
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nhà cung cấp sản phẩm
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // Phien bản đặt hàng
    @ManyToOne
    @JoinColumn(name = "variant_id")
    private Variant variant;

    // số lượng dặt
    private int quantity;

    // Ngày đặt hàng
    private Date order_date;
    //endregion

    // region Constructor

    public PurchaseOrder() {
    }

    // endregion

    // region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    // endregion
}
