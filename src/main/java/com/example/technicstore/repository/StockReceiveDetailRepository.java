package com.example.technicstore.repository;

import com.example.technicstore.entity.StockReceiveDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockReceiveDetailRepository extends JpaRepository<StockReceiveDetail, Long> {
    // lấy tất cả chi tiết phiếu nhập theo id phiếu nhập
   List<StockReceiveDetail> findStockReceiveDetailsByStockReceive_Id(long stockReceiveId);

   // lấy chi tiết phiếu nhập theo id chi tiết phiếu nhập
   Optional<StockReceiveDetail> findStockReceiveDetailById(long stockReceiveDetailId);

   // lấy chi tiết phiếu nhập theo id phiếu nhập và id phiên bản
    Optional<StockReceiveDetail> findStockReceiveDetailByStockReceive_IdAndVariant_Id(long stockReceiveId, long variantId);

}
