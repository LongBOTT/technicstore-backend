package com.example.technicstore.repository;

import com.example.technicstore.entity.Function;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FunctionRepository extends JpaRepository<Function, Long> {

    // Tìm kiếm theo tên chức năng
    List<Function> findFunctionByName(String name);
}
