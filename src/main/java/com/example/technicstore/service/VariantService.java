package com.example.technicstore.service;

import com.example.technicstore.entity.Product;
import com.example.technicstore.entity.Variant;
import com.example.technicstore.repository.ProductRepository;
import com.example.technicstore.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VariantService {

    @Autowired
    private VariantRepository variantRepository;
    @Autowired
    private ProductRepository productRepository;
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

    // Lấy biến thể theo ID sản phẩm
    public List<Variant> getVariantsByCategoryId(Long categoryId) {
        List<Product> products = productRepository.findProductsByCategory_Id(categoryId);
        return variantRepository.findByProductsIn(products);
    }

    // Lấy biến thể theo ID sản phẩm
    public List<Variant> getVariantsByBrandId(Long brandId) {
        List<Product> products = productRepository.findProductsByBrand_Id(brandId);
        return variantRepository.findByProductsIn(products);
    }


    // Tìm các biến thể trong khoảng giá
    public List<Variant> getVariantsByPriceRange(Double minPrice, Double maxPrice, List<Variant> variants) {
        // Get the list of variants within the price range
        List<Variant> variantList = variantRepository.findByPriceBetween(minPrice, maxPrice);

        // Create a set of variant IDs for fast lookup
        Set<Long> variantIds = variants.stream()
                .map(Variant::getId)
                .collect(Collectors.toSet());

        // Filter the variants that exist in the provided variants list
        List<Variant> result = new ArrayList<>();
        for (Variant variant : variantList) {
            if (variantIds.contains(variant.getId())) {
                result.add(variant);
            }
        }

        return result;
    }



    // Hàm tìm kiếm phiên bản theo mảng sản phẩm và khoảng giá
    public List<Variant> getVariantsByProductsAndPriceRange(List<Product> products, Double minPrice, Double maxPrice) {
        return variantRepository.findByProductsInAndPriceBetween(products, minPrice, maxPrice);
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
