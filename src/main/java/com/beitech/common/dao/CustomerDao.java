package com.beitech.common.dao;

import java.util.List;

import com.beitech.common.model.entities.Customer;

/**
 * Interface de la clase que se encarga del acceso a datos de la tabla CUSTOMER.
 * 
 * @author pablo.perez
 *
 */
public interface CustomerDao {

	/**
	 * Metodo que permite consultar un cliente a partir del id.
	 * 
	 * @param customerId
	 * @return
	 */
	List<Customer> consultarPorId(Long customerId);

	/**
	 * Metodo que permite consultar todos los clientes.
	 * 
	 * @return
	 */
	List<Customer> listarClientes();

}
