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

    // tìm kiếm theo tên nhà cung cấp chính xác
    public Optional<Supplier> getSupplierByName(String name) {
        return supplierRepository.findSupplierByName(name);
    }

    // tìm kiếm gần đúng theo tên nhà cung cấp gần đúng (chứa chuỗi name)
    public List<Supplier> getSupplierByNameContaining(String name) {
        return supplierRepository.findSupplierByNameContainingIgnoreCase(name);
    }

    // tìm kiếm gần đúng theo số điện thoại (chứa chuỗi phone)
    public List<Supplier> getSupplierByPhoneContaining(String phone) {
        return supplierRepository.findSupplierByPhoneContainingIgnoreCase(phone);
    }

    // tìm kiếm chính xác theo số điện thoại
    public Optional<Supplier> getSupplierByPhone(String phone) {
        return supplierRepository.findSupplierByPhone(phone);
    }

    // tìm kiếm chính xác theo email
    public Optional<Supplier> getSupplierByEmail(String email) {
        return supplierRepository.findSupplierByEmail(email);
    }

    // tìm kiếm gần đúng theo email (chứa chuỗi email)
    public List<Supplier> getSupplierByEmailContaining(String email) {
        return supplierRepository.findSupplierByEmailContainingIgnoreCase(email);
    }

    // tìm kiếm gần đúng theo số điện thoại hoặc email
    public List<Supplier> getSupplierByPhoneContainingOrEmailContaining(String phone, String email) {
        return supplierRepository.findSupplierByPhoneContainingOrEmailContainingIgnoreCase(phone, email);
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
    // tìm kiếm một hoặc nhiều điều kiện
    public List<Supplier> searchAll(String name, String phone, String email, String address) {
        return supplierRepository.searchAll(name, phone, email, address);
    }

    // check tồn tại chính xác dùng khi thêm hoặc sửa
    public List<Supplier> checkExist(String name,String phone, String email) {
        return supplierRepository.checkExist(name,phone, email);
    }


    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}

