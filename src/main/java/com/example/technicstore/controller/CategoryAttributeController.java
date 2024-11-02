package com.example.technicstore.controller;

import com.example.technicstore.entity.Category_Atrribute;
import com.example.technicstore.service.CategoryAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category-attributes")
public class CategoryAttributeController {

    @Autowired
    private CategoryAttributeService categoryAttributeService;

    // API để lấy tất cả Category_Attribute
    @GetMapping
    public ResponseEntity<List<Category_Atrribute>> getAllCategoryAttributes() {
        List<Category_Atrribute> categoryAttributes = categoryAttributeService.findAll();
        return ResponseEntity.ok(categoryAttributes);
    }

    // API để lấy Category_Attribute theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Category_Atrribute> getCategoryAttributeById(@PathVariable Long id) {
        return categoryAttributeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // API để lấy danh sách Category_Attribute theo Category ID
    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<List<Category_Atrribute>> getCategoryAttributesByCategoryId(@PathVariable Long categoryId) {
        List<Category_Atrribute> categoryAttributes = categoryAttributeService.findByCategoryId(categoryId);
        return ResponseEntity.ok(categoryAttributes);
    }

    // API để thêm mới Category_Attribute
    @PostMapping
    public ResponseEntity<Category_Atrribute> createCategoryAttribute(@RequestBody Category_Atrribute categoryAttribute) {
        Category_Atrribute createdCategoryAttribute = categoryAttributeService.save(categoryAttribute);
        return ResponseEntity.ok(createdCategoryAttribute);
    }

    // API để cập nhật Category_Attribute
    @PutMapping("/{id}")
    public ResponseEntity<Category_Atrribute> updateCategoryAttribute(
            @PathVariable Long id,
            @RequestBody Category_Atrribute categoryAttribute) {
        return categoryAttributeService.findById(id)
                .map(existingCategoryAttribute -> {
                    categoryAttribute.setId(id);
                    Category_Atrribute updatedCategoryAttribute = categoryAttributeService.save(categoryAttribute);
                    return ResponseEntity.ok(updatedCategoryAttribute);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // API để xóa Category_Attribute theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryAttribute(@PathVariable Long id) {
        if (categoryAttributeService.findById(id).isPresent()) {
            categoryAttributeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
