package com.beitech.common.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "available_products_customer")
@NamedQueries({
		@NamedQuery(name = "AVAILABLE_PRODUCTS_CUSTOMER.consultarDisponibilidadProductoCliente", query = "SELECT o FROM AvailableProductsCustomer o where o.customer.customerId=:customerId and o.product.productId=:productId and o.active=:active") })
public class AvailableProductsCustomer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="available_products_customer_id")
	private Long availableProductsCustomerId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private Date endDate;
	private String active;

	public Long getAvailableProductsCustomerId() {
		return availableProductsCustomerId;
	}

	public void setAvailableProductsCustomerId(Long availableProductsCustomerId) {
		this.availableProductsCustomerId = availableProductsCustomerId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
