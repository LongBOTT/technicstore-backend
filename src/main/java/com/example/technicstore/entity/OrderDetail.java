package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`order_detail`")
public class OrderDetail {

    // region Thuộc tính

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Đơn đặt hàng chứa chi tiết đơn đặt hàng
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Sản phẩm thuộc chi tiết đơn đặt hàng
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Số lượng sản phẩm được đặt
    private int quantity;

    // Giá trị của chi tiết đơn đặt hàng
    private double unit_price;

    // endregion

    // region Constructor

    public OrderDetail() {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    //endregion
}
