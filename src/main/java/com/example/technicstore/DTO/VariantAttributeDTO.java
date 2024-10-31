package com.example.technicstore.DTO;

import com.example.technicstore.entity.Attribute;

public class VariantAttributeDTO {
    private Long id;
    private String value;
    private Attribute attribute;
    private Long variantId;

    public VariantAttributeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Long getVariantId() {
        return variantId;
    }

    public void setVariantId(Long variantId) {
        this.variantId = variantId;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}