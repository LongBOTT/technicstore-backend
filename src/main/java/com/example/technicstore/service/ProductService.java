package com.example.technicstore.service;

import com.example.technicstore.entity.Brand;
import com.example.technicstore.entity.Product;
import com.example.technicstore.entity.Variant;
import com.example.technicstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<Product> getProductByCategory_Id(long id) {
        return productRepository.findProductsByCategory_Id(id);
    }

    public List<Product> getProductInVariants(List<Variant> variants) {
        Set<Long> productIds = new HashSet<>();  // Sử dụng Set để theo dõi các ID sản phẩm đã được thêm
        List<Product> products = new ArrayList<>();  // Danh sách các sản phẩm kết quả

        for (Variant variant : variants) {
            Product product = variant.getProducts();  // Lấy sản phẩm từ variant

            if (product != null && !productIds.contains(product.getId())) {  // Kiểm tra sản phẩm có tồn tại trong Set không
                products.add(product);  // Thêm sản phẩm vào danh sách
                productIds.add(product.getId());  // Thêm ID sản phẩm vào Set để theo dõi
            }
        }

        return products;  // Trả về danh sách các sản phẩm duy nhất
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
