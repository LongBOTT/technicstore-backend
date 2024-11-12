package com.example.technicstore.service;

import com.example.technicstore.DTO.Request.VariantCreationRequest;
import com.example.technicstore.Mapper.VariantMapper;
import com.example.technicstore.entity.Product;
import com.example.technicstore.entity.Variant;
import com.example.technicstore.repository.ProductRepository;
import com.example.technicstore.repository.VariantRepository;
import jakarta.transaction.Transactional;
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

    @Autowired
    private Variant_AttributeService variant_attributeService;

    @Autowired
    private VariantMapper variantMapper;

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
        return variantRepository.findByProductsIdAndStatus(productId,"active");
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

    public Variant createVariant(VariantCreationRequest variantReques) {
        // Sử dụng VariantMapper để map VariantDTO sang Variant
        Variant variant = variantMapper.toEntity(variantReques);
        Product product = productRepository.findById(variantReques.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        variant.setProducts(product);
        return variantRepository.save(variant);
    }

    // Cập nhật biến thể
    public Variant updateVariant(Long id, VariantCreationRequest request) {
        Optional<Variant> variantOptional = variantRepository.findById(id);

        if (variantOptional.isEmpty()) {
            throw new RuntimeException("Variant not found");
        }

        Variant existingVariant = variantOptional.get();
        Product product = productRepository.findById(request.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        existingVariant.setName(request.getName());
        existingVariant.setProducts(product);
        existingVariant.setPrice(request.getPrice());
        existingVariant.setQuantity(request.getQuantity());
        existingVariant.setCostPrice(request.getCostPrice());
        existingVariant.setImage(request.getImage());

        return variantRepository.save(existingVariant);

    }




    // Xóa biến thể theo mã sản phẩm
    @Transactional
    public void deleteVariantByProductId(Long productId) {
        List<Variant> variants = variantRepository.findByProductsIdAndStatus(productId,"active");
        for (Variant variant : variants) {
            // Xóa variant_attributes của biến thể
            variant_attributeService.deleteVariant_AttributeByVariantId(variant.getId());
            updateStatus(variant.getId(), "inactive");
        }
    }

    // Cập nhật trạng thái biến thể theo mã biến thể
    public void deleteVariantById(Long id) {
        variant_attributeService.deleteVariant_AttributeByVariantId(id);
        updateStatus(id, "inactive");
    }

    public void updateStatus(Long id, String status) {
        Optional<Variant> variantOptional = variantRepository.findById(id);

        if (variantOptional.isEmpty()) {
            throw new RuntimeException("Variant not found");
        }

        Variant existingVariant = variantOptional.get();
        existingVariant.setStatus(status);
        variantRepository.save(existingVariant);
    }

}
