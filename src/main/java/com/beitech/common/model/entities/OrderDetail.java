package com.beitech.common.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ORDER_DETAIL")
@NamedQueries({ @NamedQuery(name = "ORDER_DETAIL.findAll", query = "SELECT od FROM OrderDetail od") })
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "order_detail_id")
	private Long orderDetailId;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "order_id", referencedColumnName = "order_id", updatable = false)
	@JsonIgnore // Se agrega para efectos de la prueba, para que no se vuelva
				// infinita la respuesta.
	private Orders orders;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "price_id")
	private Price price;

	private int quantity;

	@Column(name = "total_value")
	private Double totalValue;

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrder(Orders orders) {
		this.orders = orders;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

}
