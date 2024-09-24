package com.example.technicstore.repository;

import com.example.technicstore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Tìm kiếm theo tên the loai
    List<Category> findCategoryByName(String name);
}
