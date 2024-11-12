package com.example.technicstore.controller;
import com.example.technicstore.DTO.Request.VariantAttributeCreation;
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
    @GetMapping("/search/variant/variantID")
    public List<Variant_Attribute> findByVariantId(@RequestParam long variantID) {
        return variant_attributeService.findVariant_AttributeByVariantId(variantID);
    }

    // Tạo mới thuộc tính biến thể
    @PostMapping
    public ResponseEntity<Variant_Attribute> createVariant_Attribute(@RequestBody VariantAttributeCreation  variantAttributeRequest) {
        Variant_Attribute createdVariant_Attribute = variant_attributeService.createVariant_Attribute(variantAttributeRequest);
        return ResponseEntity.ok(createdVariant_Attribute);
    }



    // Xóa thuộc tính biến thể
    @DeleteMapping("/{variantId}")
    public ResponseEntity deleteVariant_Attribute(@PathVariable Long variantId) {
        boolean deleted = variant_attributeService.deleteVariant_Attribute(variantId);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
