package com.example.technicstore.controller;

import com.example.technicstore.entity.Module;
import com.example.technicstore.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    // Lấy danh sách tất cả module
    @GetMapping
    public List<Module> getAllModules() {
        return moduleService.getAllModules();
    }

    // Lấy thông tin một module theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        Optional<Module> module = moduleService.getModuleById(id);
        return module.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Tìm kiếm theo tên module
    @GetMapping("/search/name/exact")
    public ResponseEntity<Module> findModuleByName(@RequestParam String name) {
        Optional<Module> module = moduleService.findModuleByName(name);
        return module.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tìm kiếm theo tên module gần đúng
    @GetMapping("/search/name/containing")
    public List<Module> findModulesByNameContaining(@RequestParam String name) {
        return moduleService.findModulesByNameContainingIgnoreCase(name);
    }

    // Tạo mới một module
    @PostMapping
    public ResponseEntity<Module> createModule(@RequestBody Module module) {
        Module createdModule = moduleService.createModule(module);
        return ResponseEntity.ok(createdModule);
    }

    // Cập nhật thông tin module
    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module module) {
        Module updatedModule = moduleService.updateModule(id, module);
        if (updatedModule != null) {
            return ResponseEntity.ok(updatedModule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa một module
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }

}
