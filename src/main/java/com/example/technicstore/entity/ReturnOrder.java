package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "`return_order`")
public class ReturnOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // nhân viên tạo
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // ngày tạo
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_date;

    // Mã khách hàng
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    //Trạng thái hoàn tiền
    private String refund_status;
    // Trạng thái nhận hàng
    private String receive_status;

    // Tổng tiền
    private double total_money;

    // Lý do
    private String reason;

    public ReturnOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(String refund_status) {
        this.refund_status = refund_status;
    }

    public String getReceive_status() {
        return receive_status;
    }

    public void setReceive_status(String receive_status) {
        this.receive_status = receive_status;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
