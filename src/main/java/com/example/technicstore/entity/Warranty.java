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

    // Số tháng bảo hành
    private int month_number;

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

    public int getMonth_number() {
        return month_number;
    }

    public void setMonth_number(int month_number) {
        this.month_number = month_number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // region


}
