package com.example.technicstore.DTO.Response;

import com.example.technicstore.entity.Supplier;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class StockReceiveResponse {
    private Long id;
    private LocalDateTime receive_date;

    private Double total;
    private Supplier supplier;

    private List<StockReciveDetailResponse> stockReciveDetailResponseList;

    public StockReceiveResponse() {
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<StockReciveDetailResponse> getStockReciveDetailResponseList() {
        return stockReciveDetailResponseList;
    }

    public void setStockReciveDetailResponseList(List<StockReciveDetailResponse> stockReciveDetailResponseList) {
        this.stockReciveDetailResponseList = stockReciveDetailResponseList;
    }
}
