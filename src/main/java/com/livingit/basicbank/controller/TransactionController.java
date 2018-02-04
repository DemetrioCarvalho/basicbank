package com.livingit.basicbank.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.livingit.basicbank.model.Transaction;
import com.livingit.basicbank.service.TransactionService;

@CrossOrigin
@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction Transaction) {
		transactionService.save(Transaction);

		return new ResponseEntity<Transaction>(Transaction, HttpStatus.CREATED);
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<Transaction>> getAllTransactions() {
//		List<Transaction> transactions = transactionService.getAll();
//		if (transactions.isEmpty()) {
//
//			return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);
//		}
//
//		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getTransactionsByAccountId(@PathVariable("id") Long id) {
		List<Transaction> transactions = transactionService.getTransactionsByAccountId(id);
		if (transactions.isEmpty()) {

			return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
}
