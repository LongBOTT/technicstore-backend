package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "`customer_debt`")
public class CustomerDebt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mã phiếu
    private String code;

    // Khách hàng
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Nhân viên tạo
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Ngày tạo
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_date;

    // Ghi chú
    private String note;

    // Giá trị thay đổi
    private double change_value;

    // Công nợ
    private double debt;

    public CustomerDebt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getChange_value() {
        return change_value;
    }

    public void setChange_value(double change_value) {
        this.change_value = change_value;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
