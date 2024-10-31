package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.VariantDTO;
import com.example.technicstore.entity.Variant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VariantMapper {

    private final VariantAttributeMapper variantAttributeMapper = new VariantAttributeMapper();

    public static Variant toEntity(VariantDTO variantDTO) {
        Variant variant = new Variant();
        variant.setId(variantDTO.getId());
        variant.setCostPrice(variantDTO.getCostPrice());
        variant.setImage(variantDTO.getImage());
        variant.setMinStock(variantDTO.getMinStock());
        variant.setPrice(variantDTO.getPrice());
        variant.setQuantity(variantDTO.getQuantity());
        variant.setAvailable(variantDTO.getAvailable());
        variant.setName(variantDTO.getName());

        return variant;
    }

    public static VariantDTO toDTO(Variant variant) {
        VariantDTO variantDTO = new VariantDTO();
        variantDTO.setId(variant.getId());
        variantDTO.setCostPrice(variant.getCostPrice());
        variantDTO.setImage(variant.getImage());
        variantDTO.setMinStock(variant.getMinStock());
        variantDTO.setName(variant.getName());
        variantDTO.setPrice(variant.getPrice());
        variantDTO.setQuantity(variant.getQuantity());
        variantDTO.setAvailable(variant.getAvailable());

        return variantDTO;
    }
}