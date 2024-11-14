package com.example.technicstore.controller;

import com.example.technicstore.DTO.Request.ImeiRequest;
import com.example.technicstore.entity.Imei;
import com.example.technicstore.entity.Product;
import com.example.technicstore.service.ImeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    // kiểm tra imei có tồn tại chưa
    @GetMapping("/check-existence/{imei_code}")
    public ResponseEntity<Map<String, Boolean>> checkImeiExistence(@PathVariable String imei_code) {
        boolean exists = imeiService.getImeiByImeiCode(imei_code).isPresent();
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Imei>> searchImeis(@RequestParam String query) {
        List<Imei> results = imeiService.searchImeis(query);
        return ResponseEntity.ok(results);
    }

    // Tạo mới một IMEI
    @PostMapping
    public ResponseEntity<Imei> createImei(@RequestBody ImeiRequest request) {
        Imei createdImei = imeiService.createImei(request);
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

    // xóa sản phẩm bằng cách cập nhật  trạng thái theo id
    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<Imei> updateStatus(@PathVariable Long id) {
        Imei updatedImei = imeiService.updateImeiStatus(id);
        if (updatedImei != null) {
            return ResponseEntity.ok(updatedImei);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
