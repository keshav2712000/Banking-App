package com.Keshav.banking_application.Service_Impl;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Keshav.banking_application.Entity.Account;
import com.Keshav.banking_application.Repository.AccountRepo;
import com.Keshav.banking_application.Service.AccountService;
import com.Keshav.banking_application.dto.AccountDto;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public AccountDto create_Account(AccountDto accountDto) {
		// TODO Auto-generated method stub
		
		Account account=new Account(accountDto.getId(),accountDto.getAccount_holder_name(),accountDto.getBalance());
		Account saved_account=accountRepo.save(account);
		
		AccountDto new_account=new AccountDto(saved_account.getId(),saved_account.getAccountHolderName(),saved_account.getBalance());
		return new_account;
	}

	@Override
	public AccountDto getAccount(Long id) {
		// TODO Auto-generated method stub
		Account saved_account=accountRepo.findById(id).get();
		return new AccountDto(saved_account.getId(),saved_account.getAccountHolderName(),saved_account.getBalance());
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		// TODO Auto-generated method stub
		Account account=accountRepo.findById(id).get();
		account.setBalance(account.getBalance()+amount);
		accountRepo.save(account);
		return new AccountDto(account.getId(),account.getAccountHolderName(),account.getBalance());
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		// TODO Auto-generated method stub
		Account account=accountRepo.findById(id).get();
		if(account==null) {
			throw new RuntimeException("Account Does Not Exists");
		}
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		account.setBalance(account.getBalance()-amount);
		accountRepo.save(account);
		return new AccountDto(account.getId(),account.getAccountHolderName(),account.getBalance());
		
	}

	@Override
	public List<AccountDto> getAll() {
		// TODO Auto-generated method stub
		List<Account>accounts=accountRepo.findAll();
		Stream<Account>s=accounts.stream();
		List<AccountDto>lst=s.map(account-> new AccountDto(account.getId(),account.getAccountHolderName(),account.getBalance())).toList();
		return lst;
	}

	@Override
	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found"));
		
		accountRepo.deleteById(id);
		
		
		return "Successfully Deleted Account";
	}

}
