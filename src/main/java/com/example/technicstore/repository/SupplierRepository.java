package com.example.technicstore.repository;

import com.example.technicstore.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {


    // Tìm kiếm theo tên nhà cung cấp
    Optional<Supplier> findSupplierByName(String name);

    // Tìm kiếm theo gần đúng tên nhà cung cấp
    List<Supplier> findSupplierByNameContainingIgnoreCase(String name);

    // Tìm kiếm theo số điện thoại (chính xác)
    Optional<Supplier> findSupplierByPhone(String phone);

    // Tìm kiếm gần đúng theo số điện thoại (chứa chuỗi phone)
    List<Supplier> findSupplierByPhoneContainingIgnoreCase(String phone);

    // Tìm kiếm theo email (chính xác)
    List<Supplier> findSupplierByEmail(String email);

    // Tìm kiếm gần đúng theo email (chứa chuỗi email)
    List<Supplier> findSupplierByEmailContainingIgnoreCase(String email);

    // Tìm kiếm theo số điện thoại hoặc email (chính xác)
    Optional<Supplier> findSupplierByPhoneOrEmail(String phone, String email);

    // Tìm kiếm gần đúng theo số điện thoại hoặc email
    List<Supplier> findSupplierByPhoneContainingOrEmailContainingIgnoreCase(String phone, String email);

    // Tìm kiếm theo địa chỉ
    List<Supplier> findSupplierByAddressContainingIgnoreCase(String address);


}
