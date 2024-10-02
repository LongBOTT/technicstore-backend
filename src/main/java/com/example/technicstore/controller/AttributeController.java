package com.example.technicstore.controller;

import com.example.technicstore.entity.Attribute;
import com.example.technicstore.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    // Lấy danh sách tất cả thuộc tính
    @GetMapping
    public List<Attribute> getAllAttributes() {
        return attributeService.getAllAttributes();
    }

    // Lấy thông tin một thuộc tính theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Attribute> getAttributeById(@PathVariable Long id) {
        Optional<Attribute> attribute = attributeService.getAttributeById(id);
        return attribute.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lấy danh sách thuộc tính theo tên gần đúng
    @GetMapping("/search/name")
    public List<Attribute> getAttributeByNameContaining(@RequestParam String name) {
        return attributeService.getAttributeByName(name);
    }

    // Tạo mới một thuộc tính
    @PostMapping
    public ResponseEntity<Attribute> createAttribute(@RequestBody Attribute attribute) {
        Attribute createdAttribute = attributeService.createAttribute(attribute);
        return ResponseEntity.ok(createdAttribute);
    }

    // Cập nhật thông tin thuộc tính
    @PutMapping("/{id}")
    public ResponseEntity<Attribute> updateAttribute(@PathVariable Long id, @RequestBody Attribute attribute) {
        Attribute updatedAttribute = attributeService.updateAttribute(id, attribute);
        if (updatedAttribute != null) {
            return ResponseEntity.ok(updatedAttribute);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa một thuộc tính
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable Long id) {
        attributeService.deleteAttribute(id);
        return ResponseEntity.noContent().build();
    }
}
