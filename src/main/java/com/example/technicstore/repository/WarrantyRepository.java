package com.example.technicstore.repository;

import com.example.technicstore.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {

    // Tìm kiếm theo tên
    List<Warranty> findWarrantyByName(String name);
}
