package com.livingit.basicbank.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "transactions")
public class Transaction {

	
	
	public Transaction() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtransaction", unique = true, nullable = false)
	private Long idtransaction;

	private BigDecimal amount;

	//@NotNull
	@ManyToOne//(cascade = { CascadeType.ALL })
	@JoinColumn(name = "SOURCE_ACCOUNT")
	private Account sourceAccount;

	//@NotNull
	@ManyToOne//(cascadeidaccount= CascadeType.ALL)
	@JoinColumn(name = "TARGET_ACCOUNT")
	private Account targetAccount;

	
	public Long getIdtransaction() {
		return idtransaction;
	}

	public void setIdtransaction(Long idtransaction) {
		this.idtransaction = idtransaction;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Account getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public Account getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(Account targetAccount) {
		this.targetAccount = targetAccount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (idtransaction == null || obj == null || getClass() != obj.getClass())
			return false;
		Transaction toCompare = (Transaction) obj;
		return idtransaction.equals(toCompare.idtransaction);
	}

	@Override
	public int hashCode() {
		return idtransaction == null ? 0 : idtransaction.hashCode();
	}

	@Override
	public String toString() {
		return "Transaction [idtransaction=" + idtransaction + ", amount=" + amount + ", sourceAccount=" + sourceAccount
				+ ", targetAccount=" + targetAccount + "]";
	}
	
	
	
}
