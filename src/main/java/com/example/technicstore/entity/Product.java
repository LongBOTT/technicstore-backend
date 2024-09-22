package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "`product`")
public class Product {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên sản phẩm với độ dài 256
    @Column(length = 256)
    private String name;

    // Mô tả sản phẩm với độ dài 4096
    @Column(length = 4096)
    private String description;

    // Thể loại sản phẩm
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Thương hiệu
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    // Nhà cung cấp sản phẩm
    @ManyToMany
    @JoinTable(
            name = "product_supplier", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "product_id"), // Khóa ngoại tới bảng Product
            inverseJoinColumns = @JoinColumn(name = "supplier_id") // Khóa ngoại tới bảng Supplier
    )
    private Set<Supplier> suppliers;

    // endregion

    // region Constructor

    public Product() {
    }

    // endregion

    //region Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    //endregion
}
