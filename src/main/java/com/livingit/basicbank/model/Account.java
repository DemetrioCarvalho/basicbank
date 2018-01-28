package com.livingit.basicbank.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "accounts")
public class Account implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2612578813518671670L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name", length = 50)
	private String name;

	//@NotNull
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name = "iduser", insertable = false, updatable = false)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// @Override
	// public String toString() {
	// StringBuffer sb = new StringBuffer();
	// sb.append("Id: ").append(this.id).append(", Name: ").append(this.name);
	// return sb.toString();
	// }

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (id == null || obj == null || getClass() != obj.getClass())
			return false;
		Account toCompare = (Account) obj;
		return id.equals(toCompare.id);
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
}
