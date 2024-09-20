package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Account;
import com.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public String createAccount(Account account) {
        if (account.getAmount() <= 1000) {
            return "Initial deposit must be greater than 1,000.";
        }
        if (accountRepository.existsByAccno(account.getAccno())) {
            return "Account number already exists.";
        }
        accountRepository.save(account);
        return "Account created successfully.";
    }

    public String deposit(Long accno, double amount) {
        if (amount > 50000) {
            return "PAN card number required for deposits over 50,000.";
        }
        Account account = accountRepository.findById(accno).orElse(null);
        if (account == null) {
            return "Account not found.";
        }
        account.setAmount(account.getAmount() + amount);
        accountRepository.save(account);
        return "Deposit successful.";
    }

    public String withdraw(Long accno, double amount) {
        Account account = accountRepository.findById(accno).orElse(null);
        if (account == null) {
            return "Account not found.";
        }
        if (account.getAmount() < 1000 + amount) {
            return "Insufficient funds. Minimum balance of 1,000 required.";
        }
        account.setAmount(account.getAmount() - amount);
        accountRepository.save(account);
        return "Withdrawal successful.";
    }

    public double checkBalance(Long accno) {
        Account account = accountRepository.findById(accno).orElse(null);
        return (account != null) ? account.getAmount() : -1;
    }
}
