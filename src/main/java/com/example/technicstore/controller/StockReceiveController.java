package com.example.technicstore.controller;

import com.example.technicstore.DTO.Request.ProductCreationRequest;
import com.example.technicstore.DTO.Request.StockReceiveRequest;
import com.example.technicstore.entity.Product;
import com.example.technicstore.entity.StockReceive;
import com.example.technicstore.service.StockReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock-receives")
public class StockReceiveController {
    @Autowired private StockReceiveService stockReceiveService;
    @PostMapping
    public ResponseEntity<StockReceive> createProduct(@RequestBody StockReceiveRequest request) {
        StockReceive createdStockReceive= stockReceiveService.createStockReceive(request);
        return ResponseEntity.ok(createdStockReceive);
    }

}
