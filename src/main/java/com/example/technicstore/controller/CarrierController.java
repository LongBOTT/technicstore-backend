package com.example.technicstore.controller;

import com.example.technicstore.entity.Carrier;
import com.example.technicstore.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carriers")
public class CarrierController {

    @Autowired
    private CarrierService carrierService;

    // Lấy danh sách tất cả đơn vị vận chuyển
    @GetMapping
    public List<Carrier> getAllCarriers() {
        return carrierService.getAllCarriers();
    }

    // Lấy thông tin một đơn vị vận chuyển theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Carrier> getCarrierById(@PathVariable Long id) {
        Optional<Carrier> carrier = carrierService.getCarrierById(id);
        return carrier.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tìm đơn vị vận chuyển theo tên chính xác
    @GetMapping("/name/{name}")
    public ResponseEntity<Carrier> getCarrierByName(@PathVariable String name) {
        Optional<Carrier> carrier = carrierService.getCarrierByName(name);
        return carrier.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tìm các đơn vị vận chuyển gần đúng theo tên
    @GetMapping("/search/name")
    public List<Carrier> searchCarriersByName(@RequestParam String name) {
        return carrierService.getCarriersByNameContaining(name);
    }

    // Tạo mới một đơn vị vận chuyển
    @PostMapping
    public ResponseEntity<Carrier> createCarrier(@RequestBody Carrier carrier) {
        Carrier createdCarrier = carrierService.createCarrier(carrier);
        return ResponseEntity.ok(createdCarrier);
    }

    // Cập nhật thông tin đơn vị vận chuyển
    @PutMapping("/{id}")
    public ResponseEntity<Carrier> updateCarrier(@PathVariable Long id, @RequestBody Carrier carrier) {
        Carrier updatedCarrier = carrierService.updateCarrier(id, carrier);
        if (updatedCarrier != null) {
            return ResponseEntity.ok(updatedCarrier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa một đơn vị vận chuyển
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrier(@PathVariable Long id) {
        carrierService.deleteCarrier(id);
        return ResponseEntity.noContent().build();
    }
}
