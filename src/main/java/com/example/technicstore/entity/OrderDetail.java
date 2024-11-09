package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`order_detail`")
public class OrderDetail {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Đơn đặt hàng chứa chi tiết đơn đặt hàng
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // IMEI sản phẩm đặt
    @OneToOne
    @JoinColumn(name = "IMEI_code")
    private Imei Imei;

    // Số lượng sản phẩm được đặt
    private int quantity;

    // Giá trị của chi tiết đơn đặt hàng
    private double price;

    // Tổng tiền
    private double total;

    // endregion

    // region Constructor

    public OrderDetail() {
    }

    public OrderDetail(Order order, com.example.technicstore.entity.Imei imei, int quantity, double price) {
        this.order = order;
        Imei = imei;
        this.quantity = quantity;
        this.price = price;
        this.total = this.price * this.quantity;
    }

    // endregion

    //region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public com.example.technicstore.entity.Imei getImei() {
        return Imei;
    }

    public void setImei(com.example.technicstore.entity.Imei imei) {
        Imei = imei;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    //endregion
}
