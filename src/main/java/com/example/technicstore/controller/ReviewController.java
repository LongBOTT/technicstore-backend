package com.example.technicstore.controller;

import com.example.technicstore.entity.Customer;
import com.example.technicstore.entity.Order;
import com.example.technicstore.entity.Product;
import com.example.technicstore.entity.Review;
import com.example.technicstore.service.CustomerService;
import com.example.technicstore.service.ProductService;
import com.example.technicstore.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    // Lấy đánh giá theo ID phiên bản
    @GetMapping("/search/productID")
    public List<Review> getReviewByVariantId(@RequestParam Long productID) {
        return reviewService.findByProductId(productID);
    }

    // Tạo mới đánh giá
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        // Kiểm tra nếu thông tin khách hàng không có hoặc số điện thoại trống
        if (review.getCustomer() == null || review.getCustomer().getPhone() == null || review.getCustomer().getPhone().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Trả về lỗi nếu không có thông tin khách hàng hoặc số điện thoại
        }

        // Tìm kiếm khách hàng dựa trên số điện thoại
        Optional<Customer> existingCustomer = customerService.findByPhone(review.getCustomer().getPhone());

        if (existingCustomer.isPresent()) {
            Optional<Product> existingProduct = productService.getProductById(review.getProduct().getId());
            // Nếu khách hàng đã tồn tại, thiết lập khách hàng vào order
            review.setCustomer(existingCustomer.get());
            review.setProduct(existingProduct.get());
            Review createdReview = reviewService.createReview(review);
            return ResponseEntity.ok(createdReview);
        }
        return ResponseEntity.notFound().build();
    }

    // Cập nhật đánh giá
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(id, review);
        if (updatedReview != null) {
            return ResponseEntity.ok(updatedReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa đánh giá
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReview(@PathVariable Long id) {
        boolean deleted = reviewService.deleteReview(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
