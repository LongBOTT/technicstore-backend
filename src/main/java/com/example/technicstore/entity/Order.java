package com.example.technicstore.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime orderDate;

    // Tổng tiền của đơn đặt hàng
    private double total_amount;

    // Trạng thái đơn đặt hàng
    private String orderStatus;

    // Trạng thái thanh toán
    private String payment_status;

    // Danh sách chi tiết đơn đặt hàng (nếu cần)
    // @OneToMany(mappedBy = "order")
    // private Set<OrderDetail> order_details;

    // Phương thức thanh toán (Tiền mặt hoặc Chuyển khoản)
    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod payment_method;

    // Ghi chú với độ dài 4096
    @Column(length = 4096)
    private String note;

    private String address;

    private String phone;

    // endregion

    // region Constructor

    public Order() {}

    // endregion

    // region Getter and Setter

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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // endregion

    public enum PaymentMethod {
        Cash("Tiền mặt"),
        BankTransfer("Chuyển khoản");

        private final String description;

        PaymentMethod(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
