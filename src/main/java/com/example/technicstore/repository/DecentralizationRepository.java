package com.example.technicstore.repository;

import com.example.technicstore.entity.Decentralization;
import com.example.technicstore.entity.Function;
import com.example.technicstore.entity.Module;
import com.example.technicstore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DecentralizationRepository extends JpaRepository<Decentralization, Long> {

    // Tìm kiếm theo role, module, function
    Optional<Decentralization> findDecentralizationByRoleAndModuleAndFunction(Role role, Module module, Function function);

}
