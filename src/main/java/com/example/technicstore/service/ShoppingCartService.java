package com.example.technicstore.service;

import com.example.technicstore.entity.ShoppingCart;
import com.example.technicstore.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    // Lấy tất cả giỏ hàng
    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    // Tìm kiếm giỏ hàng theo ID
    public Optional<ShoppingCart> getShoppingCartById(Long id) {
        return shoppingCartRepository.findById(id);
    }

    // Tìm kiếm giỏ hàng theo variant
    public List<ShoppingCart> getShoppingCartsByVariantId(Long variantId) {
        return shoppingCartRepository.findByVariantId(variantId);
    }

    // Tìm kiếm giỏ hàng theo tài khoản
    public Optional<ShoppingCart> getShoppingCartByAccountId(Long accountId) {
        return shoppingCartRepository.findByAccountId(accountId);
    }

    // Tạo giỏ hàng mới
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    // Cập nhật giỏ hàng
    public ShoppingCart updateShoppingCart(Long id, ShoppingCart shoppingCart) {
        if (shoppingCartRepository.existsById(id)) {
            shoppingCart.setId(id);
            return shoppingCartRepository.save(shoppingCart);
        }
        return null; // Hoặc ném ra Exception
    }

    // Xóa giỏ hàng
    public void deleteShoppingCart(Long id) {
        shoppingCartRepository.deleteById(id);
    }

}
