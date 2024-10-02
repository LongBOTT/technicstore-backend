package com.example.technicstore.service;

import com.example.technicstore.entity.Module;
import com.example.technicstore.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    // Lấy tất cả module
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    // Lấy module theo ID
    public Optional<Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }

    // Tìm kiếm theo tên module
    public Optional<Module> findModuleByName(String name) {
        return moduleRepository.findModuleByName(name);
    }

    // Tìm kiếm theo tên module gần đúng
    public List<Module> findModulesByNameContainingIgnoreCase(String name) {
        return moduleRepository.findModuleByNameContainingIgnoreCase(name);
    }

    // Tạo mới một module
    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }

    // Cập nhật thông tin module
    public Module updateModule(Long id, Module updatedModule) {
        Optional<Module> moduleOptional = moduleRepository.findById(id);
        if (moduleOptional.isPresent()) {
            Module existingModule = moduleOptional.get();
            existingModule.setName(updatedModule.getName());
            return moduleRepository.save(existingModule);
        }
        return null;
    }

    // Xóa một module
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }


}
