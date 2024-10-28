package com.example.technicstore.service;

import com.example.technicstore.entity.Category;
import com.example.technicstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // Tìm kiếm danh mục theo tên chính xác
    public Optional<Category> getCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    // Tim kiem danh muc theo tên gần đúng (chứa chuỗi name)
    public List<Category> getCategoryByNameContaining(String name) {
        return categoryRepository.findCategoryByNameContainingIgnoreCase(name);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category existingCategory = categoryOptional.get();
            existingCategory.setName(updatedCategory.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
