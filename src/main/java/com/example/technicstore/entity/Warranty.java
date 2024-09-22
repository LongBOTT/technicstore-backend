package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "`warranty`")
public class Warranty {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetail order_detail;

    // Ngày bắt đầu bảo hành
    @Column(name = "warranty_start_date")
    private Date warranty_start_date;

    // Ngày kết thúc bảo hành
    @Column(name = "warranty_end_date")
    private Date warranty_end_date;

    // Trạng thái bảo hành
    @Column(name = "status")
    private String status;

    // endregion

    // region Constructor

    public Warranty() {
    }

    // endregion

    // Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDetail getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(OrderDetail order_detail) {
        this.order_detail = order_detail;
    }

    public Date getWarranty_start_date() {
        return warranty_start_date;
    }

    public void setWarranty_start_date(Date warranty_start_date) {
        this.warranty_start_date = warranty_start_date;
    }

    public Date getWarranty_end_date() {
        return warranty_end_date;
    }

    public void setWarranty_end_date(Date warranty_end_date) {
        this.warranty_end_date = warranty_end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // endregion
}
