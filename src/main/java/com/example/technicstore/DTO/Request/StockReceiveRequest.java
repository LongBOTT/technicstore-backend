package com.example.technicstore.DTO.Request;

import java.time.LocalDateTime;
import java.util.Date;

public class StockReceiveRequest {
    private Long id;

    private LocalDateTime receive_date;

    private Double total;

    private String note;

    private Long supplierId;

    public StockReceiveRequest() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getReceive_date() {
        return receive_date;
    }

    public void setReceive_date(LocalDateTime receive_date) {
        this.receive_date = receive_date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
