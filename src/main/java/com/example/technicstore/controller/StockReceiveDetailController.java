package com.example.technicstore.controller;

import com.example.technicstore.DTO.Request.StockReceiveDetailRequest;
import com.example.technicstore.entity.StockReceive;
import com.example.technicstore.entity.StockReceiveDetail;
import com.example.technicstore.service.StockReceiveDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock-receive-details")
public class StockReceiveDetailController {
    @Autowired
    private StockReceiveDetailService stockReceiveDetailService;
        @PostMapping
        public ResponseEntity<StockReceiveDetail> createStockReceiveDetail(@RequestBody StockReceiveDetailRequest request) {
            StockReceiveDetail createdStockReceiveDetail = stockReceiveDetailService.createStockReceiveDetail(request);
            return ResponseEntity.ok(createdStockReceiveDetail);
        }
}


