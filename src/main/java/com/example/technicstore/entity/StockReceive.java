package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "`stock_receive`")
public class StockReceive {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Số tiền hàng
    @Column(name = "total_value")
    private double total_value;

    // Chi phí phát sinh
    @Column(name = "cost")
    private double cost;
    // Tổng giá trị phiếu nhập
    @Column(name = "total")
    private double total;
    // Ngày nhập kho
    @Column(name = "receive_date")
    private LocalDateTime receive_date;

    // Ghi chú bổ sung
    @Column(name = "note")
    private String note;

    // Danh sách chi tiết phiếu nhập kho
    @OneToMany(mappedBy = "stock_receive")
    private Set<StockReceiveDetail> stock_receive_details;
    // endregion

    // region Constructor

    public StockReceive() {
    }

    // endregion

    // region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getReceive_date() {
        return receive_date;
    }

    public void setReceive_date(LocalDateTime receive_date) {
        this.receive_date = receive_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<StockReceiveDetail> getStock_receive_details() {
        return stock_receive_details;
    }

    public void setStock_receive_details(Set<StockReceiveDetail> stock_receive_details) {
        this.stock_receive_details = stock_receive_details;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(double total_value) {
        this.total_value = total_value;
    }
    // endregion
}
