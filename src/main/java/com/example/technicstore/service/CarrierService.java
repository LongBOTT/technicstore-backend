package com.example.technicstore.service;

import com.example.technicstore.entity.Carrier;
import com.example.technicstore.repository.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrierService {

    @Autowired
    private CarrierRepository carrierRepository;

    // Lấy tất cả đơn vị vận chuyển
    public List<Carrier> getAllCarriers() {
        return carrierRepository.findAll();
    }

    // Lấy đơn vị vận chuyển theo ID
    public Optional<Carrier> getCarrierById(Long id) {
        return carrierRepository.findById(id);
    }

    // Tìm đơn vị vận chuyển theo tên
    public Optional<Carrier> getCarrierByName(String name) {
        return carrierRepository.findCarrierByName(name);
    }

    // Tìm các đơn vị vận chuyển gần đúng theo tên
    public List<Carrier> getCarriersByNameContaining(String name) {
        return carrierRepository.findCarrierByNameContainingIgnoreCase(name);
    }

    // Tạo mới đơn vị vận chuyển
    public Carrier createCarrier(Carrier carrier) {
        return carrierRepository.save(carrier);
    }

    // Cập nhật đơn vị vận chuyển
    public Carrier updateCarrier(Long id, Carrier updatedCarrier) {
        Optional<Carrier> carrierOptional = carrierRepository.findById(id);
        if (carrierOptional.isPresent()) {
            Carrier existingCarrier = carrierOptional.get();
            existingCarrier.setName(updatedCarrier.getName());
            return carrierRepository.save(existingCarrier);
        }
        return null;
    }

    // Xóa đơn vị vận chuyển
    public void deleteCarrier(Long id) {
        carrierRepository.deleteById(id);
    }
}
