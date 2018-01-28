package com.livingit.basicbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author BytesTree
 *
 */

@Entity
@Table(name = "bankuser")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6447416794596398975L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iduser", unique = true, nullable = false)
	private Long iduser;

	@Column(name = "firstname", length = 50)
	private String firstname;

	@Column(name = "lastname", length = 50)
	private String lastname;

	public User() {
	}

	public User(Long iduser) {
		this.iduser = iduser;
	}

	public User(Long iduser, String firstname, String lastname, String designation, Integer salary) {
		this.iduser = iduser;
		this.firstname = firstname;
		this.lastname = lastname;

	}

	public User(String firstname, String lastname, String designation, Integer salary) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	
	
	

	// @Override
	// public String toString() {
	// StringBuffer sb = new StringBuffer();
	// sb.append("Id: ").append(this.id).append(", firstName:
	// ").append(this.firstname).append(", lastName: ")
	// .append(this.lastname);
	// return sb.toString();
	// }

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (iduser == null || obj == null || getClass() != obj.getClass())
			return false;
		User toCompare = (User) obj;
		return iduser.equals(toCompare.iduser);
	}

	@Override
	public int hashCode() {
		return iduser == null ? 0 : iduser.hashCode();
	}

}
