package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`purchase_order_detail`")
public class PurchaseOrderDetail {


    // region Attribute
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Phien bản đặt hàng
    @ManyToOne
    @JoinColumn(name = "variant_id")
    private Variant variant;

    // số lượng dặt
    private int quantity;

    // phieu dat
    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchase_order;

    // endregion

    // region Constructor

    public PurchaseOrderDetail() {
    }

    // endregion

    // region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PurchaseOrder getPurchase_order() {
        return purchase_order;
    }

    public void setPurchase_order(PurchaseOrder purchase_order) {
        this.purchase_order = purchase_order;
    }

    // endregion
}
