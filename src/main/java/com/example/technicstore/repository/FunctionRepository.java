package com.example.technicstore.repository;

import com.example.technicstore.entity.Function;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FunctionRepository extends JpaRepository<Function, Long> {

    // Tìm kiếm theo tên chức năng
    Optional<Function> findFunctionByName(String name);

    // Tìm kiếm theo tên chức năng
    List<Function> findFunctionByNameContainingIgnoreCase(String name);
}
