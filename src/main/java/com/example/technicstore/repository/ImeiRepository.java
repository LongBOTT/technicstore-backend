package com.example.technicstore.repository;

import com.example.technicstore.entity.Imei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ImeiRepository extends JpaRepository<Imei, Long> {

    // Tìm kiếm theo mã IMEI
    Optional<Imei> findImeiByImeiCode(String imeiCode);


    // lấy imei theo id chi tiêt phiếu nhập
    List<Imei> findImeiByStockReceiveDetail_Id(long stockReceiveDetailId);

    @Query("SELECT i FROM Imei i WHERE i.imeiCode LIKE %:query% OR i.stockReceiveDetail.variant.name LIKE %:query%")
    List<Imei> searchByImeiCodeOrVariantName(@Param("query") String query);
}
