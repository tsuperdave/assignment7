package com.meritamerica.assignment5.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.models.AccountHolderContact;
import com.meritamerica.assignment5.repositories.*;


@RestController
public class AccountHolderContactsController {
	
	@Autowired
	private ContactRepo contactRepo;
	
	@GetMapping(value = "/account-holder-contacts/all")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolderContact> getContacts() {
		return contactRepo.findAll();
	}
	
	@PostMapping(value = "/account-holder-contacts")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolderContact postAccountHolderContact(@RequestBody @Valid AccountHolderContact accHolder ) {
		contactRepo.save(accHolder);
		return accHolder;
	}
	
	
}
