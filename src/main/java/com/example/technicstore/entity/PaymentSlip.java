package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "`payment_slip`")

public class PaymentSlip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // loại phiếu: tự động, thu nợ đối tác vận chuyển ...
    private String type;

    // Nhóm người nộp
    private String group_receiver;

    // người nộp
    private String receiver;

    // Chứng từ gốc
    private String original_document;

    // Nhân viên tạo
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Ngày tạo
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_date;

    // Ghi chú
    private String note;

    // Số tiền thu
    private double money;

    public PaymentSlip() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroup_receiver() {
        return group_receiver;
    }

    public void setGroup_receiver(String group_receiver) {
        this.group_receiver = group_receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getOriginal_document() {
        return original_document;
    }

    public void setOriginal_document(String original_document) {
        this.original_document = original_document;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
