package com.example.technicstore.repository;

import com.example.technicstore.entity.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarrierRepository extends JpaRepository<Carrier, Long> {

    // Tìm kiếm theo tên don vi van chuyen
    Optional<Carrier> findCarrierByName(String name);

    // Tìm kiếm theo gần đúng tên don vi van chuyen
    List<Carrier> findCarrierByNameContainingIgnoreCase(String name);
}
