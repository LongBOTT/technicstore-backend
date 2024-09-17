package com.example.technicstore.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "`category`")
public class Category {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên thể loại với độ dài 256
    @Column(length = 256)
    private String name;

    // endregion

    // region Constructor

    public Category() {
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

    //endregion
}
