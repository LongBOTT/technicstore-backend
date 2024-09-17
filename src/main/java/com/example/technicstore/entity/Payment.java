package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "`payment`")
public class Payment {

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

    // Phương thức thanh toán (Tiền mặt hoặc Chuyển khoản)
    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod payment_method;


    // Mã giao dịch, chỉ sử dụng khi phương thức là BankTransfer
    @Column(name = "transaction_id", length = 100, nullable = true)
    private String transaction_id;

    // Tên ngân hàng, chỉ sử dụng khi phương thức là BankTransfer
    @Column(name = "bank_name", length = 100, nullable = true)
    private String bank_name;

    // Trạng thái thanh toán (ví dụ: Success, Pending, Failed)
    @Column(name = "status")
    private String status;
    // endregion

    // region constructor

    public Payment() {
    }

    //endregion

    //region Getter and Setter

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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(double payment_amount) {
        this.payment_amount = payment_amount;
    }

    public PaymentMethod getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(PaymentMethod payment_method) {
        this.payment_method = payment_method;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //endregion

    public enum PaymentMethod {
        Cash("Tiền mặt"),
        BankTransfer("Chuyển khoản");

        private final String description;

        // Constructor cho enum
        PaymentMethod(String description) {
            this.description = description;
        }

        // Phương thức để lấy mô tả
        public String getDescription() {
            return description;
        }
    }
}


