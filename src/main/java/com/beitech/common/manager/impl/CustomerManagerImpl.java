package com.beitech.common.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beitech.common.dao.CustomerDao;
import com.beitech.common.manager.CustomerManager;
import com.beitech.common.model.entities.Customer;

/**
 * Implementación de la interfaz OrdersManager
 * 
 * @author pablo.perez
 *
 */
@Service
public class CustomerManagerImpl implements CustomerManager {

	@Autowired
	CustomerDao customerDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beitech.common.manager.CustomerManager#listarClientes()
	 */
	@Transactional
	@Override
	public List<Customer> listarClientes() {
		return customerDao.listarClientes();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.beitech.common.manager.CustomerManager#consultarPorId(java.lang.Long)
	 */
	@Transactional
	@Override
	public List<Customer> consultarPorId(Long customerId) {

		return customerDao.consultarPorId(customerId);
	}

}
