package com.example.technicstore.repository;

import com.example.technicstore.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {

    // Tìm kiếm theo ten thuoc tinh
    List<Attribute> findAttributeByName(String name);
}
