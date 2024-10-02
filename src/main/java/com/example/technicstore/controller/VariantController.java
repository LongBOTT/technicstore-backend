package com.example.technicstore.controller;

import com.example.technicstore.entity.Variant;
import com.example.technicstore.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/variants")
public class VariantController {

    @Autowired
    private VariantService variantService;

    // Lấy danh sách tất cả biến thể
    @GetMapping
    public List<Variant> getAllVariants() {
        return variantService.getAllVariants();
    }

    // Lấy thông tin một biến thể theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Variant> getVariantById(@PathVariable Long id) {
        Optional<Variant> variant = variantService.getVariantById(id);
        return variant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới một biến thể
    @PostMapping
    public ResponseEntity<Variant> createVariant(@RequestBody Variant variant) {
        Variant createdVariant = variantService.createVariant(variant);
        return ResponseEntity.ok(createdVariant);
    }

    // Cập nhật thông tin biến thể
    @PutMapping("/{id}")
    public ResponseEntity<Variant> updateVariant(@PathVariable Long id, @RequestBody Variant variant) {
        Variant updatedVariant = variantService.updateVariant(id, variant);
        if (updatedVariant != null) {
            return ResponseEntity.ok(updatedVariant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa một biến thể
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariant(@PathVariable Long id) {
        variantService.deleteVariant(id);
        return ResponseEntity.noContent().build();
    }
}
