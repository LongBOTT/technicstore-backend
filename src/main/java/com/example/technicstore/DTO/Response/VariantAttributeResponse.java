package com.example.technicstore.DTO.Response;

import com.example.technicstore.entity.Attribute;

public class VariantAttributeResponse {
    private Long id;
    private String value;
    private AttributeResponse attribute;
    private VariantResponse variant;

    public VariantAttributeResponse() {
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


    public VariantResponse getVariant() {
        return variant;
    }

    public void setVariant(VariantResponse variant) {
        this.variant = variant;
    }

    public AttributeResponse getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeResponse attribute) {
        this.attribute = attribute;
    }
}