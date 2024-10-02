package com.example.technicstore.repository;

import com.example.technicstore.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    // Tìm kiếm giỏ hàng theo tài khoản
    Optional<ShoppingCart> findByAccountId(Long accountId);

    // Tìm kiếm giỏ hàng theo variant
    List<ShoppingCart> findByVariantId(Long variantId);
}
