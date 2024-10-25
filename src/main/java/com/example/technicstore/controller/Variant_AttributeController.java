package com.example.technicstore.controller;
import com.example.technicstore.entity.Variant_Attribute;
import com.example.technicstore.service.Variant_AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/variant_attributes")
public class Variant_AttributeController {
    @Autowired
    private Variant_AttributeService variant_attributeService;

    // Tìm kiếm theo ID biến thể
    @GetMapping("/{variantId}")
    public List<Variant_Attribute> findByVariantId(@PathVariable Long variantId) {
        return variant_attributeService.findByVariantId(variantId);
    }

    // Tạo mới thuộc tính biến thể
    @PostMapping
    public ResponseEntity<Variant_Attribute> createVariant_Attribute(@RequestBody Variant_Attribute variant_Attribute) {
        Variant_Attribute createdVariant_Attribute = variant_attributeService.createVariant_Attribute(variant_Attribute);
        return ResponseEntity.ok(createdVariant_Attribute);
    }

    // Cập nhật thuộc tính biến thể
    @PutMapping("/{id}")
    public ResponseEntity<Variant_Attribute> updateVariant_Attribute(@PathVariable Long id, @RequestBody Variant_Attribute variant_Attribute) {
        Variant_Attribute updatedVariant_Attribute = variant_attributeService.updateVariant_Attribute(id, variant_Attribute);
        if (updatedVariant_Attribute != null) {
            return ResponseEntity.ok(updatedVariant_Attribute);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa thuộc tính biến thể
    @DeleteMapping("/{id}")
    public ResponseEntity deleteVariant_Attribute(@PathVariable Long id) {
        boolean deleted = variant_attributeService.deleteVariant_Attribute(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
