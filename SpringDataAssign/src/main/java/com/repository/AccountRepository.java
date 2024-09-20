package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	int findAccountNumber(Long accno);
	
	


}
