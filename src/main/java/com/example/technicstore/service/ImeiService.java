package com.example.technicstore.service;

import com.example.technicstore.entity.Imei;
import com.example.technicstore.repository.ImeiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImeiService {

    @Autowired
    private ImeiRepository imeiRepository;

    // Lấy tất cả IMEI
    public List<Imei> getAllImeis() {
        return imeiRepository.findAll();
    }

    // Lấy IMEI theo ID
    public Optional<Imei> getImeiById(Long id) {
        return imeiRepository.findById(id);
    }

    // Tạo mới IMEI
    public Imei createImei(Imei imei) {
        return imeiRepository.save(imei);
    }

    // Cập nhật IMEI
    public Imei updateImei(Long id, Imei updatedImei) {
        Optional<Imei> imeiOptional = imeiRepository.findById(id);
        if (imeiOptional.isPresent()) {
            Imei existingImei = imeiOptional.get();
            existingImei.setIMEI_code(updatedImei.getIMEI_code());
            existingImei.setStock_receive_detail(updatedImei.getStock_receive_detail());
            return imeiRepository.save(existingImei);
        }
        return null;
    }

    // Xóa IMEI
    public void deleteImei(Long id) {
        imeiRepository.deleteById(id);
    }
}
