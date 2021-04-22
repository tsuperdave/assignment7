package com.meritamerica.assignment5.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.models.AccountHolder;
import com.meritamerica.assignment5.models.CheckingAccount;
import com.meritamerica.assignment5.models.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment5.models.NoSuchResourceFoundException;
import com.meritamerica.assignment5.repositories.AccountHolderRepository;


@RestController
public class AccountHolderController {
	
	@Autowired
	private AccountHolderRepository accHolderRepo;
	
	
	
	@PostMapping("/account-holders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder postAccountHolder(@RequestBody @Valid AccountHolder accHolder ) {
		accHolderRepo.save(accHolder);
		return accHolder;
	}
	
	@GetMapping(value = "/account-holders")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getAccountHolders() {
		return accHolderRepo.findAll();
	}
	
	@GetMapping("/account-holders/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<AccountHolder> getAccountHolderById(@PathVariable Integer id) throws NoSuchResourceFoundException{
		if (!accHolderRepo.existsById(id)) {
			throw new NoSuchResourceFoundException("Account Holder does not exist.");
		} else {
			return accHolderRepo.findById(id);
		}
	}
	
	@PostMapping("/account-holders/{id}/checking-accounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount postCheckingAccount(
			@PathVariable Integer id, @RequestBody @Valid CheckingAccount checkingAccount ) 
					throws NoSuchResourceFoundException, NegativeAmountException, ExceedsCombinedBalanceLimitException { {
			checkingAccount.getAccountHolder().
			return checkingAccount;
		}
	}
	
	@GetMapping("/account-holders/{id}/checking-accounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CheckingAccount> getCheckingAccountsById(
			@PathVariable int id) throws NoSuchResourceFoundException{
		if (id < 0 || id < (MeritBank.getAccountHolders().size() - 1) && MeritBank.getAccountHolders().get(id-1).getCheckingAccounts() != null) {
			throw new NoSuchResourceFoundException("Account Holder does not exist.");
		} else {
			return MeritBank.getAccountHolders().get(id-1).getCheckingAccounts();
		}
	}
	
	@PostMapping("/account-holders/{id}/savings-accounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount postSavingsAccount(
			@PathVariable int id, @RequestBody @Valid SavingsAccount savingsAccount ) 
					throws NoSuchResourceFoundException, NegativeAmountException, ExceedsCombinedBalanceLimitException {
		if (savingsAccount.getBalance() + MeritBank.getAccountHolders().get(id-1).getCombinedBalance() >= 250000 ){
			throw new ExceedsCombinedBalanceLimitException("Exceeds combined balance limit.");
		} else {
			MeritBank.getAccountHolders().get(id-1).addSavingsAccount(savingsAccount);
			return savingsAccount;
		}
	}
	
	@GetMapping("/account-holders/{id}/savings-accounts")
	@ResponseStatus(HttpStatus.OK)
	public List<SavingsAccount> getSavingsAccountsById(
			@PathVariable int id) throws NoSuchResourceFoundException{
		if (id < 0 || id > (MeritBank.getAccountHolders().size() - 1) && MeritBank.getAccountHolders().get(id-1).getSavingsAccounts() != null) {
			throw new NoSuchResourceFoundException("Account Holder does not exist.");
		} else {
			return MeritBank.getAccountHolders().get(id-1).getSavingsAccounts();
		}
	}
	
	@PostMapping("/account-holders/{id}/cd-accounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount postCDAccount(
			@PathVariable int id, @RequestBody @Valid CDAccountCreator cdAccountCreator)
					throws NoSuchResourceFoundException, NegativeAmountException, ExceedsCombinedBalanceLimitException {
		if (cdAccountCreator.getCdAccount().getBalance() + MeritBank.getAccountHolders().get(id-1).getCombinedBalance() >= 250000 ){
			throw new ExceedsCombinedBalanceLimitException("Exceeds combined balance limit.");
		} else {
			CDOfferingRepository newOffering = MeritBank.getCDOfferings().get(cdAccountCreator.getCdOffering().getId() - 1);
			CDAccount newAccount = new CDAccount(newOffering,
					cdAccountCreator.getBalance());
			MeritBank.getAccountHolders().get(id-1).addCDAccount(newAccount);
			return newAccount;
		}
	}
	
	@GetMapping("/account-holders/{id}/cd-accounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CDAccount> getCDAccountsById(
			@PathVariable int id) throws NoSuchResourceFoundException{
		if (id < 0 || id > (MeritBank.getAccountHolders().size() - 1) && MeritBank.getAccountHolders().get(id-1).getCDAccounts() != null) {
			throw new NoSuchResourceFoundException("Account Holder does not exist.");
		} else {
			return MeritBank.getAccountHolders().get(id-1).getCDAccounts();
		}
	}*/
	
	public AccountHolderRepository getAccHolderRepo() {
		return accHolderRepo;
	}

	public void setAccHolderRepo(AccountHolderRepository accHolderRepo) {
		this.accHolderRepo = accHolderRepo;
	}

}
