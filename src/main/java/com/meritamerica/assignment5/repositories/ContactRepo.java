package com.meritamerica.assignment5.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment5.models.AccountHolderContact;

public interface ContactRepo extends JpaRepository<AccountHolderContact, Integer>{

	
}
