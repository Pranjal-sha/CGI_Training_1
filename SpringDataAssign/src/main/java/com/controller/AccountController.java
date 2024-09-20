
package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Account;
import com.service.AccountService;
@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
//	@PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createAccount(@RequestBody Account account) {
		 accountService.createAccount(account);
		return "indexPage";

	}	
	
//	@GetMapping(value = "findbalance/{accno}")
	public String findBalance(@PathVariable("accno") Long accno) {
		 accountService.findBalance(accno);
		return "indexPage";

	}
	
//	@GetMapping(value = "findaccnumber/{emailid}")
	public int findAccountNumber(@PathVariable("accno") Long accno) {
		return accountService.findAccountNumber(accno);
	}
	
//	@PutMapping(value = "withdraw",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String withdraw(@RequestBody Account account) {
		 accountService.withdrawn(account);
		return "indexPage";

	}
	
	
//	@PutMapping(value = "deposit",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deposit(@RequestBody Account account) {
		 accountService.deposit(account);
		return "indexPage";
	}
	
}