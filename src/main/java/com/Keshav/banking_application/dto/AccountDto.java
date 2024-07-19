package com.Keshav.banking_application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class AccountDto {

	
		private Long id;
		private String account_holder_name;
		private double balance;

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAccount_holder_name() {
			return account_holder_name;
		}
		public void setAccount_holder_name(String account_holder_name) {
			this.account_holder_name = account_holder_name;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public AccountDto(Long id, String account_holder_name, double balance) {
			super();
			this.id = id;
			this.account_holder_name = account_holder_name;
			this.balance = balance;
		}
		
}
