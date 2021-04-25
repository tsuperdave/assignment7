package com.meritamerica.assignment5.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.assignment5.models.AccountHolder;
import com.meritamerica.assignment5.models.BankAccount;
import com.meritamerica.assignment5.models.CheckingAccount;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Integer>{

	List<CheckingAccount> findBankAccountByAccountHolder(AccountHolder accountHolder);
}
