package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

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

    // Ngày đặt hàng
    private Date order_date;

    // Danh sách chi tiết đơn đặt hàng
    @OneToMany(mappedBy = "purchase_order")
    private Set<PurchaseOrderDetail> purchase_order_details;

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

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Set<PurchaseOrderDetail> getPurchase_order_details() {
        return purchase_order_details;
    }

    public void setPurchase_order_details(Set<PurchaseOrderDetail> purchase_order_details) {
        this.purchase_order_details = purchase_order_details;
    }
    // endregion
}
