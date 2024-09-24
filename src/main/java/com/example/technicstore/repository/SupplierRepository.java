package com.example.technicstore.repository;

import com.example.technicstore.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    // Tìm kiếm theo tên the loai
    List<Supplier> findSupplierByName(String name);
}
