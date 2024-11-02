package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.Request.VariantAttributeCreation;
import com.example.technicstore.DTO.Response.AttributeResponse;
import com.example.technicstore.DTO.Response.VariantAttributeResponse;
import com.example.technicstore.DTO.Response.VariantResponse;
import com.example.technicstore.entity.Attribute;
import com.example.technicstore.entity.Variant_Attribute;
import org.springframework.stereotype.Component;

@Component
public class VariantAttributeMapper {

    public static Variant_Attribute toEntity( VariantAttributeCreation variantAttributeRequest){
        Variant_Attribute variantAttribute = new Variant_Attribute();
        variantAttribute.setValue(variantAttributeRequest.getValue());
        return variantAttribute;
    }

    public static VariantAttributeResponse toDTO(Variant_Attribute variantAttribute) {
        VariantAttributeResponse variantAttributeDTO = new VariantAttributeResponse();
        variantAttributeDTO.setId(variantAttribute.getId());
        VariantResponse variantResponse = VariantMapper.toDTO(variantAttribute.getVariant());
        AttributeResponse attributeResponse = AttributeMapper.toDTO(variantAttribute.getAttribute());
        variantAttributeDTO.setVariant(variantResponse);
        variantAttributeDTO.setAttribute(attributeResponse);
        variantAttributeDTO.setValue(variantAttribute.getValue());
        return variantAttributeDTO;
    }
}