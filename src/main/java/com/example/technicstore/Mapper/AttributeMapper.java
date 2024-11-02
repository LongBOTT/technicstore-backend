package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.Response.AttributeResponse;
import com.example.technicstore.entity.Attribute;
import org.springframework.stereotype.Component;

@Component
public class AttributeMapper {

    public Attribute toEntity(AttributeResponse attributeDTO) {
        Attribute attribute = new Attribute();
        attribute.setId(attributeDTO.getId());
        attribute.setName(attributeDTO.getName());
        attribute.setParent(attributeDTO.getParent());
        return attribute;
    }

    public static AttributeResponse toDTO(Attribute attribute) {
        AttributeResponse attributeDTO = new AttributeResponse();
        attributeDTO.setId(attribute.getId());
        attributeDTO.setName(attribute.getName());
        attributeDTO.setParent(attribute.getParent());
        return attributeDTO;
    }
}