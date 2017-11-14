package com.beitech.common.model.dto;

import java.io.Serializable;
import java.util.Date;

public class ListarOrdenesInDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long customerId;
	
	private Date startDate;
	
	private Date endDate;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
}
