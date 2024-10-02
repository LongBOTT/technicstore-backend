package com.example.technicstore.service;

import com.example.technicstore.entity.Decentralization;
import com.example.technicstore.entity.Function;
import com.example.technicstore.entity.Module;
import com.example.technicstore.entity.Role;
import com.example.technicstore.repository.DecentralizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DecentralizationService {

    @Autowired
    private DecentralizationRepository decentralizationRepository;

    // Lấy tất cả phân quyền
    public List<Decentralization> getAllDecentralizations() {
        return decentralizationRepository.findAll();
    }

    // Lấy phân quyền theo ID
    public Optional<Decentralization> getDecentralizationById(Long id) {
        return decentralizationRepository.findById(id);
    }

    // Lấy phân quyền theo role, module, function
    public Optional<Decentralization> getDecentralizationByRoleAndModuleAndFunction(Role role, Module module, Function function) {
        return decentralizationRepository.findDecentralizationByRoleAndModuleAndFunction(role, module, function);
    }

    // Tạo mới phân quyền
    public Decentralization createDecentralization(Decentralization decentralization) {
        return decentralizationRepository.save(decentralization);
    }

    // Cập nhật phân quyền
    public Decentralization updateDecentralization(Long id, Decentralization updatedDecentralization) {
        Optional<Decentralization> decentralizationOptional = decentralizationRepository.findById(id);
        if (decentralizationOptional.isPresent()) {
            Decentralization existingDecentralization = decentralizationOptional.get();
            existingDecentralization.setRole(updatedDecentralization.getRole());
            existingDecentralization.setFunction(updatedDecentralization.getFunction());
            existingDecentralization.setModule(updatedDecentralization.getModule());
            return decentralizationRepository.save(existingDecentralization);
        }
        return null;
    }

    // Xóa phân quyền
    public void deleteDecentralization(Long id) {
        decentralizationRepository.deleteById(id);
    }

}
