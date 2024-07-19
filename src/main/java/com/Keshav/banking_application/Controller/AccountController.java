package com.Keshav.banking_application.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Keshav.banking_application.Service.AccountService;
import com.Keshav.banking_application.dto.AccountDto;

@RestController
@CrossOrigin
@RequestMapping("/api/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	
	@PostMapping
	public ResponseEntity<AccountDto> addAccount( @RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.create_Account(accountDto),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccount(@PathVariable Long id){
		return new ResponseEntity<>(accountService.getAccount(id),HttpStatus.OK);
	}
	
	@PutMapping("/deposit/{id}")
	public ResponseEntity<AccountDto> deposit(@RequestBody Map<String,Long>mp,@PathVariable Long id){
		return new ResponseEntity<>(accountService.deposit(id, mp.get("amount")),HttpStatus.OK);
	}
	
	@PutMapping("/withdraw/{id}")
	public ResponseEntity<AccountDto> withdraw(@RequestBody Map<String,Long>mp,@PathVariable Long id){
		return new ResponseEntity<>(accountService.withdraw(id, mp.get("amount")),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAll(){
		return new ResponseEntity<>(accountService.getAll(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		return new ResponseEntity<>(accountService.deleteAccount(id),HttpStatus.OK);
	}
}
