package com.example.technicstore.repository;

import com.example.technicstore.entity.Brand;
import com.example.technicstore.entity.Product;
import com.example.technicstore.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(long id);

    // Tìm kiếm sản phẩm theo tên chính xác
    Optional<Product> findProductByName(String name);

    // Tìm kiếm sản phẩm theo tên gần đúng
    List<Product> findProductByNameContainingIgnoreCase(String name);

    // Tìm kiếm sản phẩm theo thể loại
    List<Product> findProductsByCategory_Id(long categoryId);

    List<Product> findProductsByBrand_Id(long id);


//    List<Product> findByProductInVariants(List<Variant> variants);
}
