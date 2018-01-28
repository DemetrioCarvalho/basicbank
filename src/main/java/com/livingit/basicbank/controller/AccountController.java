package com.livingit.basicbank.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.livingit.basicbank.model.Account;
import com.livingit.basicbank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	final static Logger logger = Logger.getLogger(AccountController.class);

	@Autowired
	AccountService accountService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Account> addEmployee(@RequestBody Account Account) {
		accountService.save(Account);

		return new ResponseEntity<Account>(Account, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@RequestBody Account Account) {
		Account existingEmp = accountService.getById(Account.getId());
		if (existingEmp == null) {
			logger.debug("Account with id " + Account.getId() + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			accountService.save(Account);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Account> getUser(@PathVariable("id") Long id) {
		Account Account = accountService.getById(id);
		if (Account == null) {
			logger.debug("Employee with id " + id + " does not exists");
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Employee:: " + Account);
		return new ResponseEntity<Account>(Account, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getAllEmployees() {
		List<Account> users = accountService.getAll();
		if (users.isEmpty()) {
			logger.debug("Employees does not exists");
			return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + users.size() + " Employees");
		logger.debug(Arrays.toString(users.toArray()));
		return new ResponseEntity<List<Account>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
		Account Account = accountService.getById(id);
		if (Account == null) {
			logger.debug("Employee with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			accountService.delete(id);
			logger.debug("Employee with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
