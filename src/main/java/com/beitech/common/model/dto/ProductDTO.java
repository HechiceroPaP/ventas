package com.beitech.common.model.dto;

import java.io.Serializable;

import com.beitech.common.model.entities.Price;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Price price;
	private int quantity;

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

}
