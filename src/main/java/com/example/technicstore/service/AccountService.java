package com.example.technicstore.service;

import com.example.technicstore.entity.Account;
import com.example.technicstore.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Lấy tất cả tài khoản
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    // Tìm tài khoản theo username chính xác
    public Optional<Account> getAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    // Tìm các tài khoản gần đúng theo username
    public List<Account> getAccountsByUsernameContaining(String username) {
        return accountRepository.findAccountByUsernameContainingIgnoreCase(username);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, Account updatedAccount) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            Account existingAccount = accountOptional.get();
            existingAccount.setUsername(updatedAccount.getUsername());
            existingAccount.setPassword(updatedAccount.getPassword());
              existingAccount.setPhone(updatedAccount.getPhone());
            existingAccount.setRole(updatedAccount.getRole());
            return accountRepository.save(existingAccount);
        }
        return null;
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}

