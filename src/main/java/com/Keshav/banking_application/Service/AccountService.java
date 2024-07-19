package com.Keshav.banking_application.Service;


import java.util.List;

import com.Keshav.banking_application.dto.AccountDto;

public interface AccountService {

	AccountDto create_Account(AccountDto account);
	AccountDto getAccount(Long id);
	AccountDto deposit(Long id,double amount);
	AccountDto withdraw(Long id,double amount);
	List<AccountDto> getAll();
	String deleteAccount(Long id);
	
}
