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

    private String IMEI_code;
    @OneToOne
    @JoinColumn(name = "stock_receive_detail_id")
    private StockReceiveDetail stock_receive_detail;

    // đã bán hay chưa và cần dùng khi tạo đơn trả
    @ManyToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetail order_detail;

    // đã trả nhà cung cấp hay chưa
    private String returned; //  chưa trả,  đã trả

    // đã kích hoạt hay chưa
    private String activated; //  chưa kích hoạt,  đã kích hoạt
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

    public String getIMEI_code() {
        return IMEI_code;
    }

    public void setIMEI_code(String IMEI_code) {
        this.IMEI_code = IMEI_code;
    }

    public StockReceiveDetail getStock_receive_detail() {
        return stock_receive_detail;
    }

    public void setStock_receive_detail(StockReceiveDetail stock_receive_detail) {
        this.stock_receive_detail = stock_receive_detail;
    }


    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    public OrderDetail getOrder_detail() {
        return order_detail;
    }

// endregion
}
