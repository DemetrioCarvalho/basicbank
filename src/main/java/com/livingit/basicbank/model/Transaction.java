package com.livingit.basicbank.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private BigDecimal amount;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinTable(name = "account_sources")
	private Account sources;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "account_targets")
	private Account targets;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Account getSources() {
		return sources;
	}

	public void setSources(Account sources) {
		this.sources = sources;
	}

	public Account getTargets() {
		return targets;
	}

	public void setTargets(Account targets) {
		this.targets = targets;
	}


}
