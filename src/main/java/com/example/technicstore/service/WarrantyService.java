package com.example.technicstore.service;

import com.example.technicstore.entity.Warranty;
import com.example.technicstore.repository.WarrantyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarrantyService {

    @Autowired
    private WarrantyRepository warrantyRepository;

    // Lấy tất cả chính sách bảo hành
    public List<Warranty> getAllWarranties() {
        return warrantyRepository.findAll();
    }

    // Lấy chính sách bảo hành theo ID
    public Optional<Warranty> getWarrantyById(Long id) {
        return warrantyRepository.findById(id);
    }

    public Warranty findById(Long id) {
        return warrantyRepository.findById(id).orElseThrow(() -> new RuntimeException("Warranty not found"));
    }

    // Tìm chính sách bảo hành theo tên gần đúng
    public List<Warranty> getWarrantyByNameContaining(String name) {
        return warrantyRepository.findWarrantiesByNameContainsIgnoreCase(name);
    }

    // Tìm chính sách bảo hành theo tên chính xác
    public Optional<Warranty> getWarrantyByName(String name) {
        return warrantyRepository.findWarrantyByName(name);
    }
    // Tạo mới chính sách bảo hành
    public Warranty createWarranty(Warranty warranty) {
        return warrantyRepository.save(warranty);
    }

    // Cập nhật chính sách bảo hành
    public Warranty updateWarranty(Long id, Warranty updatedWarranty) {
        Optional<Warranty> warrantyOptional = warrantyRepository.findById(id);
        if (warrantyOptional.isPresent()) {
            Warranty existingWarranty = warrantyOptional.get();
            existingWarranty.setName(updatedWarranty.getName());
            existingWarranty.setValue(updatedWarranty.getValue());
            existingWarranty.setUnit(updatedWarranty.getUnit());
            existingWarranty.setNote(updatedWarranty.getNote());
            return warrantyRepository.save(existingWarranty);
        }
        return null;
    }

    // Xóa chính sách bảo hành
    public void deleteWarranty(Long id) {
        warrantyRepository.deleteById(id);
    }
}

