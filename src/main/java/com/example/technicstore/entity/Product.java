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

    // Tổng số lượng tồn của tất cả phiên bản cộng lại
    private int total;

    // Số lượng sản phẩm có thể bán
    private int available;

    // khối lượng
    private double weight;


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

    @ManyToOne
    @JoinColumn(name = "warranty_id")
    private Warranty warranty;

   // xóa sản phẩm
    private int deleted; // 0: chưa xóa, 1: đã xóa

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
    public void setTotal(int total) {
        this.total = total;
    }
    public int getTotal() {
        return total;
    }
    public void setAvailable(int available) {
        this.available = available;
    }
    public int getAvailable() {
        return available;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public int getDeleted() {
        return deleted;
    }
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    //endregion
}
