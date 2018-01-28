package com.livingit.basicbank.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livingit.basicbank.model.Account;
import com.livingit.basicbank.repository.AccountRepository;
import com.livingit.basicbank.repository.UserRepository;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserService userService;

	@Override
	public Account save(Account entity) {
		return accountRepository.save(entity);
	}

	@Override
	public Account getById(Serializable id) {
		return accountRepository.findOne((Long) id);
	}

	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		accountRepository.delete((Long) id);

	}
}
