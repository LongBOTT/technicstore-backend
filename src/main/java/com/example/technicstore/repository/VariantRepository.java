package com.example.technicstore.repository;

import com.example.technicstore.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.technicstore.entity.Product;
import java.util.List;
import java.util.Optional;

public interface VariantRepository extends JpaRepository<Variant, Long> {

    // Tìm kiếm theo ID sản phẩm
    List<Variant> findByProductsId(Long productId);

    // Tim kiem theo ID bien the
    Optional<Variant> findById(Long id);

    // Tìm các biến thể có giá nằm trong khoảng
    List<Variant> findByPriceBetween(Double minPrice, Double maxPrice);

    // Phương thức để tìm các phiên bản có giá trong khoảng và thuộc các sản phẩm trong mảng
    List<Variant> findByProductsInAndPriceBetween(List<Product> products, Double minPrice, Double maxPrice);

    List<Variant> findByProductsIdAndPrice(Long productId, double price);

}
