package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "`warranty_note`")
public class WarrantyNote {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetail order_detail;

    // Ngày bắt đầu bảo hành
    @Column(name = "warranty_start_date")
    private Date warranty_start_date;

    // Ngày kết thúc bảo hành
    @Column(name = "warranty_end_date")
    private Date warranty_end_date;

    // Trạng thái bảo hành: còn bảo hành, hết bảo hành
    @Column(name = "status")
    private String status;

    // Trạng thái yêu cầu: chấp nhận bảo hành, từ chối bảo hành, không
    @Column(name = "request_status")
    private String request_status;

    // Mã chính sách bảo hành
    @ManyToOne
    @JoinColumn(name = "warranty_id")
    private Warranty warranty;

    // Nội dung thanh toán
    @Column(length = 4096)
    private String description;

    // endregion

    // region Constructor

    public WarrantyNote() {
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

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequest_status() {
        return request_status;
    }

    public void setRequest_status(String request_status) {
        this.request_status = request_status;
    }
// endregion
}
