package com.example.technicstore.repository;

import com.example.technicstore.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {

    // Tìm kiếm theo ten thuoc tinh
    Optional<Attribute> findAttributeByName(String name);

    // Tìm kiếm theo gần đúng tên thuộc tính
    List<Attribute> findAttributeByNameContainingIgnoreCase(String name);
}
