package com.livingit.basicbank.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livingit.basicbank.model.Transaction;
import com.livingit.basicbank.repository.AccountRepository;
import com.livingit.basicbank.repository.TransactionRepository;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	EntityManager entityManager;

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction save(Transaction entity) {
		return transactionRepository.save(entity);
	}

	@Override
	public Transaction getById(Serializable id) {
		return transactionRepository.findOne((Long) id);
	}

	@Override
	public List<Transaction> getAll() {
		return transactionRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		transactionRepository.delete((Long) id);

	}

	public List<Transaction> getTransactionsByAccountId(Long id) {

		return entityManager
				.createQuery("Select t from Transaction t where t.sourceAccount.idaccount =:sourceAccount", Transaction.class)
				.setParameter("sourceAccount", id).getResultList();

	}

}
