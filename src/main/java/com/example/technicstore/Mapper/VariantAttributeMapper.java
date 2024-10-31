package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.VariantAttributeDTO;
import com.example.technicstore.entity.Variant_Attribute;
import com.example.technicstore.entity.Attribute;
import org.springframework.stereotype.Component;

@Component
public class VariantAttributeMapper {

//    public static Variant_Attribute toEntity(VariantAttributeDTO variantAttributeDTO) {
//        Variant_Attribute variantAttribute = new Variant_Attribute();
//        variantAttribute.setId(variantAttributeDTO.getId());
//        variantAttribute.setValue(variantAttributeDTO.getValue());
//        if (variantAttributeDTO.getAttribute() != null) {
//            Attribute attribute = new Attribute();
//            variantAttribute.setAttribute(attribute);
//        }
//        return variantAttribute;
//    }

    public static VariantAttributeDTO toDTO(Variant_Attribute variantAttribute) {
        VariantAttributeDTO variantAttributeDTO = new VariantAttributeDTO();
        variantAttributeDTO.setId(variantAttribute.getId());
        variantAttributeDTO.setAttribute(variantAttribute.getAttribute());
        variantAttributeDTO.setValue(variantAttribute.getValue());
        return variantAttributeDTO;
    }
}