package com.demo.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.library.dao.AccountRepository;
import com.demo.library.entity.Account;
import com.demo.library.entity.AccountDetails;

@Service
public class AccountService implements UserDetailsService{

	AccountDetails accountD;
	AccountRepository accountRepo;
	@Autowired
	AccountService(AccountDetails account, AccountRepository accountRepo)
	{
		this.accountD = account;
		this.accountRepo = accountRepo;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Account> userAccount = this.accountRepo.findByUsername(username);
		
			Account getUser = Optional.ofNullable(userAccount.get()).orElseThrow(()-> new UsernameNotFoundException("Username Not Found"));
			return new AccountDetails(getUser);
	}

}
