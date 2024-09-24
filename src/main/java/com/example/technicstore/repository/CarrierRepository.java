package com.example.technicstore.repository;

import com.example.technicstore.entity.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarrierRepository extends JpaRepository<Carrier, Long> {

    // Tìm kiếm theo tên don vi van chuyen
    List<Carrier> findCarrierByName(String name);
}
