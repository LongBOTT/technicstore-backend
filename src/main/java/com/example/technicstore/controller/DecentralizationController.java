package com.example.technicstore.controller;

import com.example.technicstore.entity.Decentralization;
import com.example.technicstore.entity.Function;
import com.example.technicstore.entity.Module;
import com.example.technicstore.entity.Role;
import com.example.technicstore.service.DecentralizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/decentralizations")
public class DecentralizationController {

    @Autowired
    private DecentralizationService decentralizationService;

    // Lấy danh sách tất cả phân quyền
    @GetMapping
    public List<Decentralization> getAllDecentralizations() {
        return decentralizationService.getAllDecentralizations();
    }

    // Lấy thông tin một phân quyền theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Decentralization> getDecentralizationById(@PathVariable Long id) {
        Optional<Decentralization> decentralization = decentralizationService.getDecentralizationById(id);
        return decentralization.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tìm kiếm theo role, module, function
    @GetMapping("/search")
    public ResponseEntity<Decentralization> findDecentralization(@RequestParam Long roleId, @RequestParam Long moduleId, @RequestParam Long functionId) {
        Role role = new Role();
        role.setId(roleId);

        Module module = new Module();
        module.setId(moduleId);

        Function function = new Function();
        function.setId(functionId);

        Optional<Decentralization> decentralization = decentralizationService.getDecentralizationByRoleAndModuleAndFunction(role, module, function);
        return decentralization.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới một phân quyền
    @PostMapping
    public ResponseEntity<Decentralization> createDecentralization(@RequestBody Decentralization decentralization) {
        Decentralization createdDecentralization = decentralizationService.createDecentralization(decentralization);
        return ResponseEntity.ok(createdDecentralization);
    }

    // Cập nhật thông tin phân quyền
    @PutMapping("/{id}")
    public ResponseEntity<Decentralization> updateDecentralization(@PathVariable Long id, @RequestBody Decentralization decentralization) {
        Decentralization updatedDecentralization = decentralizationService.updateDecentralization(id, decentralization);
        if (updatedDecentralization != null) {
            return ResponseEntity.ok(updatedDecentralization);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa một phân quyền
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDecentralization(@PathVariable Long id) {
        decentralizationService.deleteDecentralization(id);
        return ResponseEntity.noContent().build();
    }


}
