package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "`order`")
public class Order {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Khách hàng thuộc đơn hàng
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Ngày đặt hàng
    @Temporal(TemporalType.TIMESTAMP)
    private Date order_date;

    // Tổng tiền của đơn đặt hàng
    private double total_amount;

    // Trạng thái đơn đặt hàng
    private String status;

    // đôn vị phụ trách vận chuyển
    @ManyToOne
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    // Danh sách chi tiết đơn đặt hàng
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> order_details;
    // endregion

    // region Constructor

    public Order() {
    }

    // endregion

    //region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<OrderDetail> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(Set<OrderDetail> order_details) {
        this.order_details = order_details;
    }

    //endregion
}
