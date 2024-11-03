package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.Request.ProductCreationRequest;
import com.example.technicstore.DTO.Response.ProductResponese;
import com.example.technicstore.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final VariantMapper variantMapper = new VariantMapper();

    public static Product toEntity(ProductCreationRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setWeight(productRequest.getWeight());
        product.setUnit(productRequest.getUnit());
        product.setImage(productRequest.getImage());
        product.setStatus(productRequest.getStatus());
        return product;
    }

    public static ProductResponese toDTO(Product product) {
        ProductResponese productDTO = new ProductResponese();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setUnit(product.getUnit());
        productDTO.setDescription(product.getDescription());
        productDTO.setWeight(product.getWeight());
        productDTO.setImage(product.getImage());
        productDTO.setCategory(product.getCategory());
        productDTO.setBrand(product.getBrand());
        productDTO.setWarranty(product.getWarranty());
        productDTO.setStatus(product.getStatus());
        return productDTO;
    }
}
