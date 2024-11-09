package com.example.technicstore.repository;

import com.example.technicstore.entity.Product;
import com.example.technicstore.entity.StockReceive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  StockReceiveRepository extends JpaRepository<StockReceive, Long> {


    // lấy phiếu nhập theo id
    StockReceive findStockReceiveById(long id);
    // lấy phiếu nhập theo tên id nhà cung cấp
    List<StockReceive> findStockReceivesBySupplier_Id(long supplierId);
    // lấy phiếu nhập theo id gần đúng
    // Sử dụng truy vấn JPQL để tìm kiếm gần đúng ID
    @Query("SELECT s FROM StockReceive s WHERE str(s.id) LIKE %:id%")
    List<StockReceive> findStockReceivesByIdContaining(@Param("id") String  id);

}
