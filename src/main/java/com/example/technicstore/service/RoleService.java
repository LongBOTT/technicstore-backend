package com.example.technicstore.service;

import com.example.technicstore.entity.Role;
import com.example.technicstore.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Lấy tất cả vai trò
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Lấy role theo ID
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    // Tìm role gần đúng theo tên
    public List<Role> getRoleByNameContaining(String name) {
        return roleRepository.findRoleByNameContainingIgnoreCase(name);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, Role updatedRole) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isPresent()) {
            Role existingRole = roleOptional.get();
            existingRole.setName(updatedRole.getName());
            return roleRepository.save(existingRole);
        }
        return null;
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
