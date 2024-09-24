package com.example.technicstore.repository;

import com.example.technicstore.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    // Tìm kiếm theo tên module
    Optional<Module> findModuleByName(String name);

    // Tìm kiếm theo gần đúng tên module
    List<Module> findModuleByNameContainingIgnoreCase(String name);
}
