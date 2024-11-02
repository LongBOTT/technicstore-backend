package com.example.technicstore.controller;

import com.example.technicstore.DTO.Request.VariantCreationRequest;
import com.example.technicstore.DTO.Response.VariantResponse;
import com.example.technicstore.entity.Variant;
import com.example.technicstore.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.technicstore.entity.Product;
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
    // Lấy thông tin biến thể theo ID sản phẩm
    @GetMapping("/search/product/productID")
    public List<Variant> getAllVariantsByProductID(@RequestParam Long productID) {
        return variantService.getVariantsByProductId(productID);
    }
    // Tìm các biến thể trong khoảng giá
    @PostMapping("/search/price")
    public List<Variant> getVariantsByPriceRange(@RequestParam Double minPrice,
                                                 @RequestParam Double maxPrice,
                                                 @RequestBody List<Variant> variants) {
        return variantService.getVariantsByPriceRange(minPrice, maxPrice, variants);
    }

    // tìm kiếm phiên bản theo mảng sản phẩm và khoảng giá
    @PostMapping("/search")
    public ResponseEntity<List<Variant>> searchVariantsByProductsAndPrice(
            @RequestBody List<Product> products,
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice
    ) {
        List<Variant> variants = variantService.getVariantsByProductsAndPriceRange(products, minPrice, maxPrice);
        return ResponseEntity.ok(variants);
    }
    // Tạo mới một biến thể
    @PostMapping
    public ResponseEntity<Variant> createVariant(@RequestBody VariantCreationRequest variantRequest) {
        Variant createdVariant = variantService.createVariant(variantRequest);
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

    // Lấy thông tin biến thể theo ID sản phẩm
    @GetMapping("/search/category/categoryID")
    public List<Variant> getAllVariantsByCategoryId(@RequestParam Long categoryID) {
        return variantService.getVariantsByCategoryId(categoryID);
    }

    // Lấy thông tin biến thể theo ID sản phẩm
    @GetMapping("/search/brand/brandID")
    public List<Variant> getAllVariantsByBrandId(@RequestParam Long brandID) {
        return variantService.getVariantsByBrandId(brandID);
    }
}
