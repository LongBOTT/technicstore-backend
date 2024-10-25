package com.example.technicstore.controller;

import com.example.technicstore.entity.Imei;
import com.example.technicstore.service.ImeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/imeis")
public class ImeiController {

    @Autowired
    private ImeiService imeiService;

    // Lấy danh sách tất cả IMEI
    @GetMapping
    public List<Imei> getAllImeis() {
        return imeiService.getAllImeis();
    }

    // Lấy thông tin một IMEI theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Imei> getImeiById(@PathVariable Long id) {
        Optional<Imei> imei = imeiService.getImeiById(id);
        return imei.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lấy thông tin một IMEI theo mã IMEI
    @GetMapping("/imei_code/{imei_code}")
    public ResponseEntity<Imei> getImeiByImeiCode(@PathVariable String imei_code) {
        Optional<Imei> imei = imeiService.getImeiByImeiCode(imei_code);
        return imei.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới một IMEI
    @PostMapping
    public ResponseEntity<Imei> createImei(@RequestBody Imei imei) {
        Imei createdImei = imeiService.createImei(imei);
        return ResponseEntity.ok(createdImei);
    }

    // Cập nhật thông tin IMEI
    @PutMapping("/{id}")
    public ResponseEntity<Imei> updateImei(@PathVariable Long id, @RequestBody Imei imei) {
        Imei updatedImei = imeiService.updateImei(id, imei);
        if (updatedImei != null) {
            return ResponseEntity.ok(updatedImei);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa một IMEI
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImei(@PathVariable Long id) {
        imeiService.deleteImei(id);
        return ResponseEntity.noContent().build();
    }
}
