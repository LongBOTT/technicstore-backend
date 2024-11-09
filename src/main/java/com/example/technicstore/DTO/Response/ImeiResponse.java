package com.example.technicstore.DTO.Response;

public class ImeiResponse {
    private Long id;
    private String imei;
    private String status;
    private Long stockReceiveDetailId;

    public ImeiResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStockReceiveDetailId() {
        return stockReceiveDetailId;
    }

    public void setStockReceiveDetailId(Long stockReceiveDetailId) {
        this.stockReceiveDetailId = stockReceiveDetailId;
    }
}
