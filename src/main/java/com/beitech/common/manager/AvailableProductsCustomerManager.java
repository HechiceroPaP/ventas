package com.beitech.common.manager;

import java.util.List;

import com.beitech.common.model.dto.ProductDTO;
import com.beitech.common.model.entities.Customer;
import com.beitech.common.model.entities.Product;

/**
 * Interfaz para el manager que contiene la lógica relacionada a la
 * disponibilidad de productos para un cliente.
 * 
 * @author pablo.perez
 *
 */
public interface AvailableProductsCustomerManager {

	/**
	 * Metodo que permite obtener el listado de productos que no se encuentran
	 * disponibles para un cliente.
	 * 
	 * @param listProductDTO
	 * @param customer
	 * @return El listado de productos que no estan disponibles para el cliente.
	 */
	List<Product> validarDisponibilidadProductoCliente(List<ProductDTO> listProductDTO, Customer customer);

}
