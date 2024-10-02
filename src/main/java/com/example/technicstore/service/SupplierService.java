package com.example.technicstore.service;

import com.example.technicstore.entity.Supplier;
import com.example.technicstore.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    // tìm kiếm gần đúng theo số điện thoại
    public List<Supplier> getSupplierByPhoneContaining(String phone) {
        return supplierRepository.findSupplierByPhoneContainingIgnoreCase(phone);
    }

    // tìm kiếm gần đúng theo email
    public List<Supplier> getSupplierByEmailContaining(String email) {
        return supplierRepository.findSupplierByEmailContainingIgnoreCase(email);
    }

    // tìm kiếm gần đúng theo số điện thoại hoặc email
    public List<Supplier> getSupplierByPhoneContainingOrEmailContaining(String phone, String email) {
        return supplierRepository.findSupplierByPhoneContainingOrEmailContainingIgnoreCase(phone, email);
    }

    //tìm kiếm theo tên
    public List<Supplier> getSupplierByNameContaining(String name) {
        return supplierRepository.findSupplierByNameContainingIgnoreCase(name);
    }

    // tìm kiếm theo địa chỉ
    public List<Supplier> getSupplierByAddressContaining(String address) {
        return supplierRepository.findSupplierByAddressContainingIgnoreCase(address);
    }
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (supplierOptional.isPresent()) {
            Supplier existingSupplier = supplierOptional.get();
            existingSupplier.setName(updatedSupplier.getName());
            existingSupplier.setEmail(updatedSupplier.getEmail());
            existingSupplier.setPhone(updatedSupplier.getPhone());
            existingSupplier.setAddress(updatedSupplier.getAddress());
            return supplierRepository.save(existingSupplier);
        }
        return null;
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}

