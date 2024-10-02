package com.example.technicstore.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "`order_history`")

public class OrderHistory {
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


    // mã đơn hàng
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // endregion

    // region Constructor
    public OrderHistory() {
    }
    // endregion


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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
