package com.example.technicstore.repository;

import com.example.technicstore.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    // Tìm kiếm theo tên thuong hieu
    Optional<Brand> findBrandByName(String name);

    // Tìm kiếm theo gần đúng tên thương hiệu
    List<Brand> findBrandByNameContainingIgnoreCase(String name);
}
