package com.example.technicstore.Mapper;

import com.example.technicstore.DTO.AttributeDTO;
import com.example.technicstore.entity.Attribute;
import org.springframework.stereotype.Component;

@Component
public class AttributeMapper {

    public Attribute toEntity(AttributeDTO attributeDTO) {
        Attribute attribute = new Attribute();
        attribute.setId(attributeDTO.getId());
        attribute.setName(attributeDTO.getName());
        attribute.setParent(attributeDTO.getParent());
        return attribute;
    }

    public AttributeDTO toDTO(Attribute attribute) {
        AttributeDTO attributeDTO = new AttributeDTO();
        attributeDTO.setId(attribute.getId());
        attributeDTO.setName(attribute.getName());
        attributeDTO.setParent(attribute.getParent());
        return attributeDTO;
    }
}