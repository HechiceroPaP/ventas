package com.beitech.common.manager;

import java.util.List;

import com.beitech.common.model.entities.Customer;

public interface CustomerManager {

	/**
	 * Metodo que permite listar un cliente a partir del Id.
	 * 
	 * @param customerId
	 * @return
	 */
	List<Customer> consultarPorId(Long customerId);

	/**
	 * Metodo que permite listar todos los clientes.
	 * 
	 * @return
	 */
	List<Customer> listarClientes();

}
