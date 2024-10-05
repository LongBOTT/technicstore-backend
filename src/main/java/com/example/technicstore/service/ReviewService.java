package com.example.technicstore.service;

import com.example.technicstore.entity.Review;
import com.example.technicstore.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    // Tìm kiếm theo ID phiên bản
    public List<Review> findByVariantId(Long variantId) {
        return reviewRepository.findByVariantId(variantId);
    }

    // Tạo mới đánh giá
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // Cập nhật đánh giá
    public Review updateReview(Long id, Review review) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (!reviewOptional.isPresent()) {
            return null;
        }
        review.setId(id);
        return reviewRepository.save(review);
    }

    // Xóa đánh giá
    public boolean deleteReview(Long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (!reviewOptional.isPresent()) {
            return false;
        }
        reviewRepository.deleteById(id);
        return true;
    }
}
