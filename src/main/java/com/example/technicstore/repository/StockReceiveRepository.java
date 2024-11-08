package com.example.technicstore.repository;

import com.example.technicstore.entity.Product;
import com.example.technicstore.entity.StockReceive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  StockReceiveRepository extends JpaRepository<StockReceive, Long> {


    // lấy phiếu nhập theo id
    StockReceive findStockReceiveById(long id);
    // lấy phiếu nhập theo tên id nhà cung cấp
    List<StockReceive> findStockReceivesBySupplier_Id(long supplierId);

}
