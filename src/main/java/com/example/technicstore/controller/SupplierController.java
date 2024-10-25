package com.example.technicstore.controller;

import com.example.technicstore.entity.Customer;
import com.example.technicstore.entity.Supplier;
import com.example.technicstore.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    // Lấy tất cả nhà cung cấp
    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    // Lấy nhà cung cấp theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        Optional<Supplier> supplier = supplierService.getSupplierById(id);
        return supplier.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tìm nhà cung cấp theo tên chính xác
    @GetMapping("/search/name/exact")
    public ResponseEntity<Supplier> getSupplierByName(@RequestParam String name) {
        Optional<Supplier> supplier = supplierService.getSupplierByName(name);
        return supplier.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tìm nhà cung cấp theo tên gần đúng (chứa chuỗi name)
    @GetMapping("/search/name/containing")
    public List<Supplier> getSupplierByNameContaining(@RequestParam String name) {
        return supplierService.getSupplierByNameContaining(name);
    }

    // Phương thức lấy danh sách nhà cung cấp với tùy chọn lọc
    @GetMapping("/search/status")
    public List<Supplier> getSuppliersByStatus(
            @RequestParam String status) {
        return supplierService.getSuppliersByStatus(status);
    }

    // Tìm nhà cung cấp theo số điện thoại chính xác
    @GetMapping("/search/phone/exact")
    public ResponseEntity<Supplier> getSupplierByPhone(@RequestParam String phone) {
        Optional<Supplier> supplier = supplierService.getSupplierByPhone(phone);
        return supplier.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tìm nhà cung cấp theo số điện thoại gần đúng (chứa chuỗi phone)
    @GetMapping("/search/phone/containing")
    public List<Supplier> getSupplierByPhoneContaining(@RequestParam String phone) {
        return supplierService.getSupplierByPhoneContaining(phone);
    }

    // Tìm nhà cung cấp theo email chính xác
    @GetMapping("/search/email/exact")
    public ResponseEntity<Supplier> getSupplierByEmail(@RequestParam String email) {
        Optional<Supplier> supplier = supplierService.getSupplierByEmail(email);
        return supplier.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tìm nhà cung cấp theo email gần đúng (chứa chuỗi email)
    @GetMapping("/search/email/containing")
    public List<Supplier> getSupplierByEmailContaining(@RequestParam String email) {
        return supplierService.getSupplierByEmailContaining(email);
    }

    // Tìm nhà cung cấp theo số điện thoại hoặc email
    @GetMapping("/search/phone-or-email")
    public List<Supplier> getSupplierByPhoneOrEmail(@RequestParam String phone, @RequestParam String email) {
        return supplierService.getSupplierByPhoneContainingOrEmailContaining(phone, email);
    }

    // Tìm nhà cung cấp theo địa chỉ gần đúng (chứa chuỗi address)
    @GetMapping("/search/address/containing")
    public List<Supplier> getSupplierByAddress(@RequestParam String address) {
        return supplierService.getSupplierByAddressContaining(address);
    }

    // Tạo mới một nhà cung cấp
    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        Supplier createdSupplier = supplierService.createSupplier(supplier);
        return ResponseEntity.ok(createdSupplier);
    }


    // Cập nhật thông tin nhà cung cấp
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        if (updatedSupplier != null) {
            return ResponseEntity.ok(updatedSupplier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa một nhà cung cấp
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

    // Tìm kiếm một hoặc nhiều điều kiện
    @GetMapping("/search")
    public List<Supplier> searchAll(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String phone,
                                    @RequestParam(required = false) String email,
                                    @RequestParam(required = false) String address) {
        return supplierService.searchAll(name, phone, email, address);
    }

    // Kiểm tra sự tồn tại của nhà cung cấp
    @GetMapping("/check")
    public List<Supplier> checkExist(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String phone,
                                     @RequestParam(required = false) String email) {
        return supplierService.checkExist(name, phone, email);
    }
}

