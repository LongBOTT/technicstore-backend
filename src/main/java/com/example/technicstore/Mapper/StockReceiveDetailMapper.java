package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.Request.StockReceiveDetailRequest;
import com.example.technicstore.DTO.Response.StockReciveDetailResponse;
import com.example.technicstore.DTO.Response.VariantResponse;
import com.example.technicstore.entity.StockReceiveDetail;
import org.springframework.stereotype.Component;

@Component
public class StockReceiveDetailMapper {
    public static StockReceiveDetail toEntity(StockReceiveDetailRequest stockReceiveDetailRequest) {
        StockReceiveDetail stockReceiveDetail = new StockReceiveDetail();
        stockReceiveDetail.setQuantity(stockReceiveDetailRequest.getQuantity());
        stockReceiveDetail.setPrice(stockReceiveDetailRequest.getPrice());
        return stockReceiveDetail;
    }

    public static StockReciveDetailResponse toDTO (StockReceiveDetail stockReceiveDetail) {
        StockReciveDetailResponse stockReceiveDetailResponse = new StockReciveDetailResponse();
        stockReceiveDetailResponse.setId(stockReceiveDetail.getId());
        stockReceiveDetailResponse.setQuantity(stockReceiveDetail.getQuantity());
        stockReceiveDetailResponse.setPrice(stockReceiveDetail.getPrice());
        stockReceiveDetailResponse.setStockReceiveId(stockReceiveDetail.getStockReceive().getId());
        VariantResponse variantResponse = VariantMapper.toDTO(stockReceiveDetail.getVariant());
        stockReceiveDetailResponse.setVariantResponse(variantResponse);
        return stockReceiveDetailResponse;
    }
}
