package com.beitech.common.model.dto;

import java.io.Serializable;
import java.util.List;

import com.beitech.common.model.entities.Customer;

public class GenerarOrdenInDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Customer customer;
	private List<ProductDTO> listProductDTO;
	private boolean totalQuantity;
	private String deliveryAddress;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ProductDTO> getListProductDTO() {
		return listProductDTO;
	}
	
	public void setListProductDTO(List<ProductDTO> listProductDTO) {
		this.listProductDTO = listProductDTO;
	}

	public void setTotalQuantity(boolean totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public boolean isTotalQuantity() {
		return totalQuantity;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

}
