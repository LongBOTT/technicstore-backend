package com.example.technicstore.repository;

import com.example.technicstore.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    // Tìm kiếm theo tên nhà cung cấp
    Optional<Supplier> findSupplierByName(String name);

    // Tìm kiếm theo gần đúng tên nhà cung cấp
    List<Supplier> findSupplierByNameContainingIgnoreCase(String name);
}
