package com.example.technicstore.repository;

import com.example.technicstore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    // Tìm kiếm theo tên vai trò
    List<Role> findRoleByName(String name);
}
