package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.Request.VariantCreationRequest;
import com.example.technicstore.DTO.Response.VariantResponse;
import com.example.technicstore.entity.Product;
import com.example.technicstore.entity.Variant;
import com.example.technicstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VariantMapper {

    private final VariantAttributeMapper variantAttributeMapper = new VariantAttributeMapper();
    @Autowired
    private ProductRepository productRepository;

    public Variant toEntity(VariantCreationRequest variantRequest) {
        Variant variant = new Variant();
        variant.setName(variantRequest.getName());
        variant.setCostPrice(variantRequest.getCostPrice());
        variant.setImage(variantRequest.getImage());
        variant.setPrice(variantRequest.getPrice());
        variant.setQuantity(variantRequest.getQuantity());
        variant.setStatus(variantRequest.getStatus());
        return variant;
    }

    public static VariantResponse toDTO(Variant variant) {
        VariantResponse variantDTO = new VariantResponse();
        variantDTO.setId(variant.getId());
        variantDTO.setCostPrice(variant.getCostPrice());
        variantDTO.setImage(variant.getImage());
        variantDTO.setName(variant.getName());
        variantDTO.setPrice(variant.getPrice());
        variantDTO.setQuantity(variant.getQuantity());
        variantDTO.setProductId(variant.getProducts().getId());
        return variantDTO;
    }
}