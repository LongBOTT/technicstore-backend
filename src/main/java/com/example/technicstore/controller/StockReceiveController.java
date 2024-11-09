package com.example.technicstore.controller;

import com.example.technicstore.DTO.Request.ProductCreationRequest;
import com.example.technicstore.DTO.Request.StockReceiveRequest;
import com.example.technicstore.DTO.Response.StockReceiveResponse;
import com.example.technicstore.entity.Product;
import com.example.technicstore.entity.StockReceive;
import com.example.technicstore.service.StockReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-receives")
public class StockReceiveController {
    @Autowired private StockReceiveService stockReceiveService;
    @PostMapping
    public ResponseEntity<StockReceive> createProduct(@RequestBody StockReceiveRequest request) {
        StockReceive createdStockReceive= stockReceiveService.createStockReceive(request);
        return ResponseEntity.ok(createdStockReceive);
    }

    @GetMapping("/getAllStockReceives")
    public ResponseEntity<List<StockReceiveResponse>> getAllStockReceives() {
        return ResponseEntity.ok(stockReceiveService.getAllStockReceives());
    }

    @GetMapping("/getStockReceiveByIdContaining/{id}")
    public ResponseEntity<List<StockReceiveResponse>> getStockReceiveByIdContaining(@PathVariable Long id) {
        return ResponseEntity.ok(stockReceiveService.getStockReceivesByIdContaining(id));
    }

    @GetMapping("/getStockReceiveBySupplierId/{supplierId}")
    public ResponseEntity<List<StockReceiveResponse>> getStockReceiveBySupplierId(@PathVariable Long supplierId) {
        return ResponseEntity.ok(stockReceiveService.getStockReceivesBySupplierId(supplierId));
    }

   @GetMapping("getStockReceiveAndStockReceiveDetailById/{id}")
    public ResponseEntity<StockReceiveResponse> getStockReceiveAndStockReceiveDetailById(@PathVariable Long id) {
        return ResponseEntity.ok(stockReceiveService.getStockReceiveAndStockReceiveDetailById(id));
   }
}
