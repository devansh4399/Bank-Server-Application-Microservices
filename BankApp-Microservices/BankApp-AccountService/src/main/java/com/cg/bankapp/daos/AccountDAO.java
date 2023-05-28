package com.cg.bankapp.daos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankapp.entities.Account;
public interface AccountDAO extends JpaRepository<Account, Integer>{

}