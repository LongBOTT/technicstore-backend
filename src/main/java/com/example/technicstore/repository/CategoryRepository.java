package com.example.technicstore.repository;

import com.example.technicstore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Tìm kiếm theo tên the loai
    Optional<Category> findCategoryByName(String name);

    // Tìm kiếm theo gần đúng tên the loai
    List<Category> findCategoryByNameContainingIgnoreCase(String name);
}
