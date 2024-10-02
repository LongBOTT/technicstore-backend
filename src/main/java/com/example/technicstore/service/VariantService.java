package com.example.technicstore.service;

import com.example.technicstore.entity.Variant;
import com.example.technicstore.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariantService {

    @Autowired
    private VariantRepository variantRepository;

    // Lấy tất cả biến thể
    public List<Variant> getAllVariants() {
        return variantRepository.findAll();
    }

    // Lấy biến thể theo ID
    public Optional<Variant> getVariantById(Long id) {
        return variantRepository.findById(id);
    }

    // Lấy biến thể theo ID sản phẩm
    public List<Variant> getVariantsByProductId(Long productId) {
        return variantRepository.findByProductsId(productId);
    }



    // Tạo mới biến thể
    public Variant createVariant(Variant variant) {
        return variantRepository.save(variant);
    }

    // Cập nhật biến thể
    public Variant updateVariant(Long id, Variant updatedVariant) {
        Optional<Variant> variantOptional = variantRepository.findById(id);
        if (variantOptional.isPresent()) {
            Variant existingVariant = variantOptional.get();
            existingVariant.setProducts(updatedVariant.getProducts());
            existingVariant.setPrice(updatedVariant.getPrice());
            existingVariant.setQuantity(updatedVariant.getQuantity());
            existingVariant.setImage(updatedVariant.getImage());
            return variantRepository.save(existingVariant);
        }
        return null;
    }

    // Xóa biến thể
    public void deleteVariant(Long id) {
        variantRepository.deleteById(id);
    }
}
