package com.example.technicstore.repository;

import com.example.technicstore.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface ReviewRepository extends JpaRepository<Review, Long>{

    // Tìm kiếm theo ID phiên bản
    List<Review> findReviewByProductId(Long productId);



}
