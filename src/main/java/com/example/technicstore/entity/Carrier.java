package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`carrier`")
public class Carrier {

    // region Attributes
    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên đơn vị vận chuyển với độ dài 256
    @Column(length = 256)
    private String name;
    // endregion

    // region Constructor

    public Carrier() {
    }

    // endregion

    // region Getter and Setter

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

    // endregion
}
