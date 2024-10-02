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
    // Phi van chuyen
    private double delivery_fee;

    // Check xem có vận đơn hay chưa (đã tạo vận đơn hay chưa)
    private String order_status;

    // Trạng thái thanh toan
    private Boolean payment_status;


    // Trạng thái thu ho
    private String cod_status;


    // Danh sách chi tiết đơn đặt hàng
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> order_details;

    // Phương thức thanh toán (Tiền mặt hoặc Chuyển khoản)
    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod payment_method;

    // Ghi chú với độ dài 4096
    @Column(length = 4096)
    private String note;
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

    public double getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(double delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Boolean getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(Boolean payment_status) {
        this.payment_status = payment_status;
    }


    public String getCod_status() {
        return cod_status;
    }

    public void setCod_status(String cod_status) {
        this.cod_status = cod_status;
    }


    public Set<OrderDetail> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(Set<OrderDetail> order_details) {
        this.order_details = order_details;
    }

    public PaymentMethod getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(PaymentMethod payment_method) {
        this.payment_method = payment_method;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

//endregion

    public enum PaymentMethod {
        Cash("Tiền mặt"),
        BankTransfer("Chuyển khoản");

        private final String description;

        // Constructor cho enum
        PaymentMethod(String description) {
            this.description = description;
        }

        // Phương thức để lấy mô tả
        public String getDescription() {
            return description;
        }
    }
}
