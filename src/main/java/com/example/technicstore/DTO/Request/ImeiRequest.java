package com.example.technicstore.DTO.Request;

public class ImeiRequest {
    private String imei_code;
    private Long receiveDetailId;

    private String status;

    public ImeiRequest() {
    }

    public String getImei_code() {
        return imei_code;
    }

    public void setImei_code(String imei_code) {
        this.imei_code = imei_code;
    }

    public Long getReceiveDetailId() {
        return receiveDetailId;
    }

    public void setReceiveDetailId(Long receiveDetailId) {
        this.receiveDetailId = receiveDetailId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
