package com.example.technicstore.controller;

import com.example.technicstore.entity.Warranty;
import com.example.technicstore.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/warranties")
public class WarrantyController {

    @Autowired
    private WarrantyService warrantyService;

    // Lấy danh sách tất cả chính sách bảo hành
    @GetMapping
    public List<Warranty> getAllWarranties() {
        return warrantyService.getAllWarranties();
    }

    // Lấy thông tin một chính sách bảo hành theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Warranty> getWarrantyById(@PathVariable Long id) {
        Optional<Warranty> warranty = warrantyService.getWarrantyById(id);
        return warranty.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lấy danh sách chính sách bảo hành theo tên gần đúng
    @GetMapping("/search/name/containing")
    public List<Warranty> getWarrantyByNameContaining(@RequestParam String name) {
        return warrantyService.getWarrantyByNameContaining(name);
    }
    // Lấy danh sách chính sách bảo hành theo tên chính xác
    @GetMapping("/search/name/exact")
    public Optional<Warranty> getWarrantyByName(@RequestParam String name) {
        return warrantyService.getWarrantyByName(name);
    }

    // Tạo mới một chính sách bảo hành
    @PostMapping
    public ResponseEntity<Warranty> createWarranty(@RequestBody Warranty warranty) {
        Warranty createdWarranty = warrantyService.createWarranty(warranty);
        return ResponseEntity.ok(createdWarranty);
    }

    // Cập nhật thông tin chính sách bảo hành
    @PutMapping("/{id}")
    public ResponseEntity<Warranty> updateWarranty(@PathVariable Long id, @RequestBody Warranty warranty) {
        Warranty updatedWarranty = warrantyService.updateWarranty(id, warranty);
        if (updatedWarranty != null) {
            return ResponseEntity.ok(updatedWarranty);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa một chính sách bảo hành
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarranty(@PathVariable Long id) {
        warrantyService.deleteWarranty(id);
        return ResponseEntity.noContent().build();
    }
}
