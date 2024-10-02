package com.example.technicstore.repository;

import com.example.technicstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Tìm kiếm sản phẩm theo tên chính xác
    Optional<Product> findProductByName(String name);

    // Tìm kiếm sản phẩm theo tên gần đúng
    List<Product> findProductByNameContainingIgnoreCase(String name);


}
