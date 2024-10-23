package com.example.technicstore.controller;

import com.example.technicstore.entity.Product;
import com.example.technicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Lấy tất cả sản phẩm
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Lấy sản phẩm theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tìm các sản phẩm gần đúng theo tên
    @GetMapping("/search/name/containing")
    public List<Product> searchProductsByNameContaining(@RequestParam String name) {
        return productService.getProductsByNameContaining(name);
    }

    // Tìm các sản phẩm gần đúng theo tên
    @GetMapping("/search/brand/exact")
    public List<Product> searchProductsByBrand_Id(@RequestParam long id) {
        return productService.getProductsByBrand_Id(id);
    }

    // Tìm các sản phẩm gần đúng theo tên
    @GetMapping("/search/category/exact")
    public List<Product> searchProductsByCategory_Id(@RequestParam long id) {
        return productService.getProductByCategory_Id(id);
    }

    // Tìm sản phẩm theo tên chính xác
    @GetMapping("/search/name/exact")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        Optional<Product> product = productService.getProductByName(name)  ;
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới sản phẩm
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    // Cập nhật sản phẩm
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
