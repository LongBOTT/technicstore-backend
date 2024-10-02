package com.example.technicstore.entity;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "inventory_history")
public class InventoryHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "variant_id")
    private Variant variant;

    // Ngày ghi nhận
    @Temporal(TemporalType.TIMESTAMP)
    private Date record_date;

    // Nhân viên thực hiện
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // thao tác (nhập/xuất)
    private String action;

   // Số lượng thay đổi
    private int change_quantity;

    // Số lưượng còn lại trong kho
    private int remain_quantity;

    // Mã chứng từ
    private String document_code;

    public InventoryHistory() {
    }

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

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getChange_quantity() {
        return change_quantity;
    }

    public void setChange_quantity(int change_quantity) {
        this.change_quantity = change_quantity;
    }

    public int getRemain_quantity() {
        return remain_quantity;
    }

    public void setRemain_quantity(int remain_quantity) {
        this.remain_quantity = remain_quantity;
    }

    public String getDocument_code() {
        return document_code;
    }

    public void setDocument_code(String document_code) {
        this.document_code = document_code;
    }
}
