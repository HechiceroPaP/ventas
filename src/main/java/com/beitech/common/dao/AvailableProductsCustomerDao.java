package com.beitech.common.dao;

import java.util.List;

import com.beitech.common.model.entities.AvailableProductsCustomer;
import com.beitech.common.model.entities.Customer;
import com.beitech.common.model.entities.Product;

/**
 * Interface para la clase que se encarga del acceso a datos de la tabla
 * AVAILABLE_PRODUCTS_CUSTOMER.
 * 
 * @author pablo.perez
 *
 */
public interface AvailableProductsCustomerDao {

	/**
	 * Metodo que permite consultar la disponibilidad de un producto para un
	 * cliente.
	 * 
	 * @param product
	 * @param customer
	 * @return
	 */
	public List<AvailableProductsCustomer> obtenerDisponibilidadProductoCliente(Product product, Customer customer);

}
