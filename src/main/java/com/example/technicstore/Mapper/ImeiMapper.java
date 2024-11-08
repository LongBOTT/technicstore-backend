package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.Request.ImeiRequest;
import com.example.technicstore.DTO.Response.ImeiResponse;
import com.example.technicstore.entity.Imei;
import org.springframework.stereotype.Component;

@Component
public class ImeiMapper {

    public static Imei toEntity (ImeiRequest imeiRequest) {
        Imei imei = new Imei();
        imei.setImeiCode(imeiRequest.getImei_code());
        imei.setStatus(imeiRequest.getStatus());
        return imei;
    }

    public static ImeiResponse toDTO (Imei imei) {
        ImeiResponse imeiResponse = new ImeiResponse();
        imeiResponse.setId(imei.getId());
        imeiResponse.setImei(imei.getImeiCode());
        imeiResponse.setStatus(imei.getStatus());
        imeiResponse.setStockReceiveDetailId(imei.getStockReceiveDetail().getId());
        return imeiResponse;
    }
}
