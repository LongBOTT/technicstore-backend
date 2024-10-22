package com.example.technicstore.repository;

import com.example.technicstore.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {

    // Tìm kiếm theo ten thuoc tinh
    List<Attribute> findAttributesByName(String name);

    // Tìm kiếm theo thuộc tính cha
    List<Attribute> findAttributeByParent(String parent);

    // Tìm kiếm theo gần đúng tên thuộc tính
    List<Attribute> findAttributeByNameContainingIgnoreCase(String name);
}
