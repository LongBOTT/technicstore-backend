package com.example.technicstore.controller;

import com.example.technicstore.DTO.Request.ProductCreationRequest;
import com.example.technicstore.DTO.Response.ProductResponese;
import com.example.technicstore.entity.*;
import com.example.technicstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private WarrantyService warrantyService;

    @Autowired
    private VariantService variantService;
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
    // Tìm các sản phẩm trong danh sách biến thể
    @PostMapping("/search/variants")
    public List<Product> searchProductsInVariants(@RequestBody List<Variant> variants) {
        // Logic xử lý để trả về danh sách Product dựa trên Variant
        return productService.getProductInVariants(variants);
    }

    // Tìm sản phẩm theo tên chính xác
    @GetMapping("/search/name/exact")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        Optional<Product> product = productService.getProductByName(name)  ;
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/getProductsAndVariants")
    public ResponseEntity<List<ProductResponese>> getProductsAndVariants() {
        List<ProductResponese> productsWithVariants = productService.getProductsAndVariants(); // Retrieve from service
        return ResponseEntity.ok(productsWithVariants); // Wrap in ResponseEntity
    }
    // tìm kiếm sản phẩm và variant theo tên sản phẩm gần đúng
    @GetMapping("/search/name/searchProductWithVariantByName")
    public ResponseEntity<List<ProductResponese>> searchProductWithVariantByName(@RequestParam String name) {
        List<ProductResponese> productsWithVariants = productService.searchProductWithVariantByName(name); // Retrieve from service
        return ResponseEntity.ok(productsWithVariants); // Wrap in ResponseEntity
    }

    // tìm kiếm sản phẩm và variant theo category
    @GetMapping("/search/category/searchProductWithVariantByCategoryId/{id}")
    public ResponseEntity<List<ProductResponese>> searchProductWithVariantByCategory(@PathVariable Long id) {
        List<ProductResponese> productsWithVariants = productService.searchProductWithVariantByCategory(id); // Retrieve from service
        return ResponseEntity.ok(productsWithVariants); // Wrap in ResponseEntity
    }

    // tìm kiếm sản phẩm và variant theo brand
    @GetMapping("/search/brand/searchProductWithVariantByBrandId/{id}")
    public ResponseEntity<List<ProductResponese>> searchProductWithVariantByBrand(@PathVariable Long id) {
        List<ProductResponese> productsWithVariants = productService.searchProductWithVariantByBrand(id); // Retrieve from service
        return ResponseEntity.ok(productsWithVariants); // Wrap in ResponseEntity
    }

    @GetMapping("/getProductAndVariantsAndAttributes/{id}")
    public ResponseEntity<ProductResponese> getProductsAndVariantsAndAttributes(@PathVariable Long id) {
        ProductResponese productsWithVariants = productService.getProductsAndVariantsAndAttributes(id); // Retrieve from service
        return ResponseEntity.ok(productsWithVariants); // Wrap in ResponseEntity
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductCreationRequest request) {
        Product createdProduct = productService.createProduct(request);
        return ResponseEntity.ok(createdProduct);
    }

    // Cập nhật sản phẩm
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductCreationRequest request) {
        Product updatedProduct = productService.updateProduct(id, request);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        variantService.deleteVariantByProductId(id);
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
