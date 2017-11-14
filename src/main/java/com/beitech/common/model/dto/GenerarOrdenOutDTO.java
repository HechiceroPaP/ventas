package com.beitech.common.model.dto;

import java.io.Serializable;
import java.util.List;

import com.beitech.common.model.entities.Product;

public class GenerarOrdenOutDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	private boolean success;
	private List<Product> listUnavailableProducts;
	private List<ProductDTO> listProcessProducts;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<Product> getListUnavailableProducts() {
		return listUnavailableProducts;
	}

	public void setListUnavailableProducts(List<Product> listUnavailableProducts) {
		this.listUnavailableProducts = listUnavailableProducts;
	}

	public List<ProductDTO> getListProcessProducts() {
		return listProcessProducts;
	}

	public void setListProcessProducts(List<ProductDTO> listProcessProducts) {
		this.listProcessProducts = listProcessProducts;
	}

}
