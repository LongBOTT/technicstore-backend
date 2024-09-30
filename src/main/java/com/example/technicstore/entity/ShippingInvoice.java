package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "`shipping_invoice`")
public class ShippingInvoice {
    // region Attributes
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mã đơn hàng
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Ngày đóng gói kiện hàng
    @Temporal(TemporalType.TIMESTAMP)
    private Date packing_date;

    // Ngày xuất kho
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipping_date;

    // Ngày giao hàng đến tay khách hàng
    @Temporal(TemporalType.TIMESTAMP)
    private Date delivery_date;

    // Đối tác vận chuyển
    @ManyToOne
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    // Trạng thái đối soát
    private String reconciliation_status;

    // Có phải vận đơn mới nhất không
    private int is_latest;

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getPacking_date() {
        return packing_date;
    }

    public void setPacking_date(Date packing_date) {
        this.packing_date = packing_date;
    }

    public Date getShipping_date() {
        return shipping_date;
    }

    public void setShipping_date(Date shipping_date) {
        this.shipping_date = shipping_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getReconciliation_status() {
        return reconciliation_status;
    }


    public void setReconciliation_status(String reconciliation_status) {
        this.reconciliation_status = reconciliation_status;
    }

    public int getIs_latest() {
        return is_latest;
    }

    public void setIs_latest(int is_latest) {
        this.is_latest = is_latest;
    }


}
