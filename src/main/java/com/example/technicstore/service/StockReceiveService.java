package com.example.technicstore.service;

import com.example.technicstore.DTO.Request.StockReceiveRequest;
import com.example.technicstore.DTO.Response.StockReceiveResponse;
import com.example.technicstore.Mapper.StockReceiveMappter;
import com.example.technicstore.entity.StockReceive;
import com.example.technicstore.entity.StockReceiveDetail;
import com.example.technicstore.entity.Supplier;
import com.example.technicstore.repository.StockReceiveRepository;
import com.example.technicstore.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockReceiveService {
    @Autowired
    private StockReceiveRepository stockReceiveRepository;
    @Autowired
    private StockReceiveDetailService stockReceiveDetailService;

    @Autowired
    SupplierRepository supplierRepository;

    // lấy tất cả phiếu nhập
    public List<StockReceiveResponse> getAllStockReceives() {
        List<StockReceive> stockReceives = stockReceiveRepository.findAll();
        List<StockReceiveResponse> stockReceiveResponses = new ArrayList<>();
        StockReceiveResponse stockReceiveResponse;
        for (StockReceive stockReceive : stockReceives) {
            stockReceiveResponse = StockReceiveMappter.toDTO(stockReceive);


        }

        return stockReceiveResponses;
    }
    // tạo phiết nhập
    public StockReceive createStockReceive (StockReceiveRequest stockReceiveRequest) {
        StockReceive stockReceive = StockReceiveMappter.toEntity(stockReceiveRequest);
        Supplier supplier = supplierRepository.findById(stockReceiveRequest.getSupplierId()).orElseThrow(() -> new RuntimeException("Supplier not found"));
        stockReceive.setSupplier(supplier);
        return stockReceiveRepository.save(stockReceive);
    }
}
