package com.Keshav.banking_application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Keshav.banking_application.Entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

}