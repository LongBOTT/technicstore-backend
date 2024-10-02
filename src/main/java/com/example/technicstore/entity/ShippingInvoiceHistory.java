package com.example.technicstore.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "`shipping_invoice_history`")
public class ShippingInvoiceHistory {
      // region Attributes
        // Khai báo khoá chính của bảng và tự động generate ID
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // thời gian
        @Temporal(TemporalType.TIMESTAMP)
        private Date time;

        // người thao tác
        @ManyToOne
        @JoinColumn(name = "employee_id")
        private Employee employee;

        // chức năng thao tác
        private String function;

        // Mã vận đơn vận chuyển
        @ManyToOne
        @JoinColumn(name = "shipping_invoice_id")
        private ShippingInvoice shippingInvoice;

    public ShippingInvoiceHistory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public ShippingInvoice getShippingInvoice() {
        return shippingInvoice;
    }

    public void setShippingInvoice(ShippingInvoice shippingInvoice) {
        this.shippingInvoice = shippingInvoice;
    }
}
