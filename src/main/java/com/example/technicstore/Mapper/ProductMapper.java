package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.ProductDTO;
import com.example.technicstore.entity.Product;
import com.example.technicstore.entity.Variant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private final VariantMapper variantMapper = new VariantMapper();

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setWeight(productDTO.getWeight());
        product.setImage(productDTO.getImage());
        product.setCategory(productDTO.getCategory());
        product.setBrand(productDTO.getBrand());
        product.setWarranty(productDTO.getWarranty());
        return product;
    }

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setWeight(product.getWeight());
        productDTO.setImage(product.getImage());
        productDTO.setCategory(product.getCategory());
        productDTO.setBrand(product.getBrand());
        productDTO.setWarranty(product.getWarranty());
        return productDTO;
    }
}
