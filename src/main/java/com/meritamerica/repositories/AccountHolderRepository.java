package com.meritamerica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.models.AccountHolder;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {
	
	

}
