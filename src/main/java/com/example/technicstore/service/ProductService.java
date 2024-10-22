package com.example.technicstore.service;

import com.example.technicstore.entity.Brand;
import com.example.technicstore.entity.Product;
import com.example.technicstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Lấy sản phẩm theo ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }


    // Tìm các sản phẩm gần đúng theo tên
    public List<Product> getProductsByNameContaining(String name) {
        return productRepository.findProductByNameContainingIgnoreCase(name);
    }

    // Tìm các sản phẩm gần đúng theo tên
    public List<Product> getProductsByBrand_Id(long id) {
        return productRepository.findProductsByBrand_Id(id);
    }

    public List<Product> getProductByCategory_Name(String name) {
        return productRepository.findProductsByCategory_Name(name);
    }


    // Tìm sản phẩm theo tên chính xác
    public Optional<Product> getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    // Tạo mới một sản phẩm
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Cập nhật thông tin sản phẩm
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setWeight(updatedProduct.getWeight());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setBrand(updatedProduct.getBrand());
            existingProduct.setWarranty(updatedProduct.getWarranty());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    // Xóa sản phẩm
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
