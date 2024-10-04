package com.example.technicstore.repository;

import com.example.technicstore.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {


    // Tìm kiếm theo tên nhà cung cấp
    Optional<Supplier> findSupplierByName(String name);

    // Tìm kiếm theo gần đúng tên nhà cung cấp (chứa chuỗi name)
    List<Supplier> findSupplierByNameContainingIgnoreCase(String name);

    // Tìm kiếm theo số điện thoại (chính xác)
    Optional<Supplier> findSupplierByPhone(String phone);

    // Tìm kiếm gần đúng theo số điện thoại (chứa chuỗi phone)
    List<Supplier> findSupplierByPhoneContainingIgnoreCase(String phone);

    // Tìm kiếm theo email (chính xác)
    Optional<Supplier> findSupplierByEmail(String email);

    // Tìm kiếm gần đúng theo email (chứa chuỗi email)
    List<Supplier> findSupplierByEmailContainingIgnoreCase(String email);


    // Tìm kiếm gần đúng theo số điện thoại hoặc email chính xác (chứa chuỗi phone hoặc email)
    List<Supplier> findSupplierByPhoneContainingOrEmailContainingIgnoreCase(String phone, String email);

    // Tìm kiếm theo địa chỉ
    List<Supplier> findSupplierByAddressContainingIgnoreCase(String address);

    @Query("SELECT s FROM Supplier s WHERE "
            + "(:name IS NULL OR :name = '' OR s.name LIKE %:name%) AND "
            + "(:phone IS NULL OR :phone = '' OR s.phone LIKE %:phone%) AND "
            + "(:email IS NULL OR :email = '' OR s.email LIKE %:email%) AND "
            + "(:address IS NULL OR :address = '' OR s.address LIKE %:address%)")
    List<Supplier> searchAll(@Param("name") String name,
                             @Param("phone") String phone,
                             @Param("email") String email,
                             @Param("address") String address);

    // check tồn tại chính xác dùng khi thêm hoặc sửa
    @Query("SELECT s FROM Supplier s WHERE "
            + "(:name = '' OR s.name = :name) OR "
            + "(:phone = '' OR s.phone = :phone) OR "
            + "(:email = '' OR s.email = :email) ")
    List<Supplier> checkExist(@Param("name") String name,
                              @Param("phone") String phone,
                              @Param("email") String email);

}
