package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.Request.StockReceiveRequest;
import com.example.technicstore.DTO.Response.StockReceiveResponse;
import com.example.technicstore.entity.StockReceive;
import org.springframework.stereotype.Component;

@Component
public class StockReceiveMappter {

    public static StockReceive toEntity(StockReceiveRequest stockReceiveRequest) {
        StockReceive stockReceive = new StockReceive();
        stockReceive.setReceive_date(stockReceiveRequest.getReceive_date());
        stockReceive.setTotal(stockReceiveRequest.getTotal());
        stockReceive.setNote(stockReceiveRequest.getNote());
        return stockReceive;
    }

    public static StockReceiveResponse toDTO(StockReceive stockReceive) {
        StockReceiveResponse stock_receiveResponse = new StockReceiveResponse();
        stock_receiveResponse.setId(stockReceive.getId());
        stock_receiveResponse.setReceive_date(stockReceive.getReceive_date());
        stock_receiveResponse.setTotal(stockReceive.getTotal());
        stock_receiveResponse.setSupplier(stockReceive.getSupplier());
        return stock_receiveResponse;
    }
}
