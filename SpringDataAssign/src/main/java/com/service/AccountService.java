package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Account;
import com.repository.AccountRepository;

@Service
public class AccountService {



		@Autowired
		AccountRepository accountRepository;
		
		public String createAccount(Account account) {
			accountRepository.save(account);
			return "Account created successfully";
		}
		
		public String findBalance(Long accno) {
			Optional<Account> result = accountRepository.findById(accno);
			if(result.isPresent()) {
				Account acc = result.get();
				return "Your balance "+acc.getAmount();
			}else {
				return "InValid account number";
			}
		}
		
		public int findAccountNumber(Long accno) {
			try {
			return accountRepository.findAccountNumber(accno);
			}catch(Exception e) {
				return -1;
			}
		}
		
		public String withdrawn(Account account) {			// accno and amount 
			Optional<Account> result = accountRepository.findById(account.getAccno());
			if(result.isPresent()) {
				Account acc = result.get();
				if(account.getAmount()<1000) {
					return"Low balance";
					
				}
				acc.setAmount(acc.getAmount()-account.getAmount());
				accountRepository.saveAndFlush(acc);
				return "Account withdrawn done successfully";
			}else {
				return "Withdraw not done";
			}
		}
		
		public String deposit(Account account) {
			Optional<Account> result = accountRepository.findById(account.getAccno());
			if(result.isPresent()) {
				Account acc = result.get();
				if(account.getAmount()>50000) {
					System.out.println("Pan card is required");
					acc.setAmount(acc.getAmount()+account.getAmount());
					accountRepository.saveAndFlush(acc);
					return "Account deposit done successfully";	
				}
				return"";
				
			}else {
				return "Deposit not done";
			}
		}
	}

