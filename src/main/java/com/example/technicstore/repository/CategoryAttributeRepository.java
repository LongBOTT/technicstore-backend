package com.example.technicstore.repository;

import com.example.technicstore.entity.Category_Atrribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryAttributeRepository extends JpaRepository<Category_Atrribute, Long> {
    // lấy danh sách theo id thể loại
    List<Category_Atrribute> findByCategoryId(Long categoryId);
    // lấy danh sách theo id thể loại và id  thuộc tính
    List<Category_Atrribute> findByCategoryIdAndAttributeId(Long categoryId, Long attributeId);

}
