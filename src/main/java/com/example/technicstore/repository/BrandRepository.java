package com.example.technicstore.repository;

import com.example.technicstore.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    // Tìm kiếm theo tên thuong hieu
    List<Brand> findBrandByName(String name);
}
