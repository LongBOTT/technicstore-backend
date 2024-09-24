package com.example.technicstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`warranty`")
public class Warranty {

    // region Attributes

    // Khai báo khoá chính của bảng và tự động generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên chính sách bảo hành
    private String name;

    // Thời gian bảo hành
    private int value;

    // Đơn vị
    private String unit;

    // Ghi chú với độ dài 4096
    @Column(length = 4096)
    private String note;
    //endregion

    // region Constructor

    public Warranty() {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
// region


}
