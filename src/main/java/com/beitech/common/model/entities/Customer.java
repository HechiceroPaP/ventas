package com.beitech.common.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "CUSTOMER")
@NamedQueries({
	@NamedQuery(name = "CUSTOMER.findAll", query = "SELECT C FROM Customer C"),
	@NamedQuery(name = "CUSTOMER.consultarPorId", query = "SELECT C FROM Customer C where C.customerId=:customerId")
})

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CUSTOMER_ID")
	private Long customerId;
	private String name;
	private String email;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
