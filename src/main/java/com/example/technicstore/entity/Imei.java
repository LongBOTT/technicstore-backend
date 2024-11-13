package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`imei`")
public class Imei {


    // region Attribute
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imeiCode;
    @ManyToOne
    @JoinColumn(name = "stock_receive_detail_id", unique = false, nullable = true)
    private StockReceiveDetail stockReceiveDetail;

    private String status;


    // endregion

    // region Constructor

    public Imei() {
    }

    // endregion

    // region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImeiCode() {
        return imeiCode;
    }

    public void setImeiCode(String imeiCode) {
        this.imeiCode = imeiCode;
    }

    public StockReceiveDetail getStockReceiveDetail() {
        return stockReceiveDetail;
    }

    public void setStockReceiveDetail(StockReceiveDetail stockReceiveDetail) {
        this.stockReceiveDetail = stockReceiveDetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // endregion
}
