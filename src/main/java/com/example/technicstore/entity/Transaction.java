package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "`transaction`")
public class Transaction {

    // region Attributes
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Khóa ngoại đến bảng Orders
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // Ngày thanh toán
    @Column(name = "payment_date")
    private Date paymentDate;

    // Số tiền thanh toán
    @Column(name = "payment_amount")
    private double payment_amount;

    // Mã giao dịch
    @Column(name = "transaction_number", length = 100, nullable = true)
    private String transaction_id;

    // Tên ngân hàng
    @Column(name = "bank_name", length = 100, nullable = true)
    private String bank_name;

    // Trạng thái thanh toán (ví dụ: Success, Pending, Failed)
    @Column(name = "status")
    private String status;
    // endregion

    // region constructor

    public Transaction() {
    }

    //endregion

    //region Getter and Setter

    //endregion
}


