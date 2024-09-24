package com.example.technicstore.repository;

import com.example.technicstore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {

    // Tìm kiếm theo tên vai trò
    Optional<Role> findRoleByName(String name);

    // Tìm kiếm gần đúng tên vai trò
    List<Role> findRoleByNameContainingIgnoreCase(String name);
}
