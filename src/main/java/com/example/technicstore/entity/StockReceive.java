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


    // Tổng giá trị phiếu nhập
    @Column(name = "total")
    private double total;
    // Ngày nhập kho
    @Column(name = "receive_date")
    private LocalDateTime receive_date;

    // Ghi chú bổ sung
    @Column(name = "note")
    private String note;

    // Nhà cung cấp sản phẩm
    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

//    // Danh sách chi tiết phiếu nhập kho
//    @OneToMany(mappedBy = "stockReceive")
//    private Set<StockReceiveDetail> stockReceiveDetails;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

//    public Set<StockReceiveDetail> getStockReceiveDetails() {
//        return stockReceiveDetails;
//    }
//
//    public void setStockReceiveDetails(Set<StockReceiveDetail> stockReceiveDetails) {
//        this.stockReceiveDetails = stockReceiveDetails;
//    }

    // endregion
}
