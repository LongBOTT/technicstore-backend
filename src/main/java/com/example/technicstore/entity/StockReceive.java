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

    // Khóa ngoại đến bảng Suppliers
    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;

    // Số tiền
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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
    // endregion
}
