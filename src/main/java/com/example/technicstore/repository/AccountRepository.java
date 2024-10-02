package com.example.technicstore.repository;

import com.example.technicstore.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // Tìm kiếm theo tên tài khoản
    Optional<Account> findAccountByUsername(String name);

    // Tìm kiếm theo gần đúng tên tài khoản
    List<Account> findAccountByUsernameContainingIgnoreCase(String name);


}
