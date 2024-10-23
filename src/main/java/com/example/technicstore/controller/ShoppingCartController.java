package com.example.technicstore.controller;

import com.example.technicstore.entity.ShoppingCart;
import com.example.technicstore.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/shopping-carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    // Lấy tất cả giỏ hàng
    @GetMapping
    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartService.getAllShoppingCarts();
    }

    // Lấy giỏ hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable Long id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartService.getShoppingCartById(id);
        return shoppingCart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lấy giỏ hàng theo variant
    @GetMapping("/variant/{variantId}")
    public List<ShoppingCart> getShoppingCartsByVariantId(@PathVariable Long variantId) {
        return shoppingCartService.getShoppingCartsByVariantId(variantId);
    }

    // Tìm kiếm giỏ hàng theo tài khoản
    @GetMapping("/account/{accountId}")
    public Optional<ShoppingCart> getShoppingCartsByAccountId(@PathVariable Long accountId) {
        return shoppingCartService.getShoppingCartByAccountId(accountId);
    }

    // Tạo giỏ hàng mới
    @PostMapping
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.createShoppingCart(shoppingCart);
    }

    // Cập nhật giỏ hàng
    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@PathVariable Long id, @RequestBody ShoppingCart shoppingCart) {
        ShoppingCart updatedShoppingCart = shoppingCartService.updateShoppingCart(id, shoppingCart);
        return updatedShoppingCart != null ? ResponseEntity.ok(updatedShoppingCart) : ResponseEntity.notFound().build();
    }

    // Xóa giỏ hàng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppingCart(@PathVariable Long id) {
        shoppingCartService.deleteShoppingCart(id);
        return ResponseEntity.noContent().build();
    }


}
