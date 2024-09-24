package com.example.technicstore.repository;

import com.example.technicstore.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    // Tìm kiếm theo tên module
    List<Module> findModuleByName(String name);
}
