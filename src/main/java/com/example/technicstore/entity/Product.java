package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "`product`")
public class Product {

    // region Thuộc tính

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

    // Giá bán của sản phẩm
    private double price;

    // Số lượng sản phẩm trong kho
    private int stock_quantity;

    // Thể loại sản phẩm
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    //endregion
}
