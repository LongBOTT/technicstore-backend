package com.example.technicstore.repository;

import com.example.technicstore.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {

    // Tìm kiếm theo tên
    Optional<Warranty> findWarrantyByName(String name);

    // Tìm kiếm theo gần đúng tên
    List<Warranty> findWarrantiesByNameContainsIgnoreCase(String name);
}
