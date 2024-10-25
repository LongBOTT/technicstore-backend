package com.example.technicstore.controller;

import com.example.technicstore.entity.Brand;
import com.example.technicstore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    // Lấy danh sách tất cả các thương hiệu
    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    // Lấy thông tin thương hiệu theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        Optional<Brand> brand = brandService.getBrandById(id);
        return brand.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lấy danh sách thương hiệu theo tên chính xác
    @GetMapping("/search/name/exact")
    public Optional<Brand> getBrandByNameContaining(@RequestParam String name) {
        return brandService.getBrandByName(name);
    }

    // Lấy danh sách thương hiệu theo tên chứa chuỗi name
    @GetMapping("/search/name/containing")
    public List<Brand> getBrandByName(@RequestParam String name) {
        return brandService.getBrandByNameContaining(name);
    }

//    @GetMapping("/search/category/exact")
//    public List<Brand> getBrandByCategoryName(@RequestParam String name) {
//        return brandService.getBrandsByCategory(name);
//    }

    @GetMapping("/search/category/exact")
    public List<Brand> getBrandByCategoryId(@RequestParam long id) {
        return brandService.getBrandsByCategoryId(id);
    }


    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        Brand createdBrand = brandService.createBrand(brand);
        return ResponseEntity.ok(createdBrand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        Brand updatedBrand = brandService.updateBrand(id, brand);
        if (updatedBrand != null) {
            return ResponseEntity.ok(updatedBrand);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}
