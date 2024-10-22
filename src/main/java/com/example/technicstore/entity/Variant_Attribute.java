package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`variant_attribute`")
public class Variant_Attribute {
    // region Attribute
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "variant_id")
    private Variant variant;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    @Column(columnDefinition = "TEXT")
    private String value;

    // endregion

    // region constructor

    public Variant_Attribute() {
    }

    // endregion

    // region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // end region

}
