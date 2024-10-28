package com.example.technicstore.service;

import com.example.technicstore.entity.Category_Atrribute;
import com.example.technicstore.repository.CategoryAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryAttributeService {
    @Autowired
    private CategoryAttributeRepository categoryAttributeRepository;

    // Lấy tất cả Category_Attribute
    public List<Category_Atrribute> findAll() {
        return categoryAttributeRepository.findAll();
    }

    public List<Category_Atrribute> findByCategoryId(Long categoryId) {
        return categoryAttributeRepository.findByCategoryId(categoryId);
    }
    // Tìm Category_Attribute theo ID
    public Optional<Category_Atrribute> findById(Long id) {
        return categoryAttributeRepository.findById(id);
    }

    // Thêm hoặc cập nhật Category_Attribute
    public Category_Atrribute save(Category_Atrribute categoryAttribute) {
        return categoryAttributeRepository.save(categoryAttribute);
    }

    // Xóa Category_Attribute theo ID
    public void deleteById(Long id) {
        categoryAttributeRepository.deleteById(id);
    }

}
