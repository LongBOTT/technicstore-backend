package com.example.technicstore.repository;

import com.example.technicstore.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VariantRepository extends JpaRepository<Variant, Long> {

    // Tìm kiếm theo ID sản phẩm
    List<Variant> findByProductsId(Long productId);

    // Tìm kiếm theo giá
    List<Variant> findByPrice(double price);

}
