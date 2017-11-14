package com.beitech.common.manager.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beitech.common.dao.AvailableProductsCustomerDao;
import com.beitech.common.manager.AvailableProductsCustomerManager;
import com.beitech.common.model.dto.ProductDTO;
import com.beitech.common.model.entities.AvailableProductsCustomer;
import com.beitech.common.model.entities.Customer;
import com.beitech.common.model.entities.Product;

/**
 * Implementación de la interfaz AvailableProductsCustomerManager
 * 
 * @author pablo.perez
 *
 */
@Service
public class AvailableProductsCustomerManagerImpl implements AvailableProductsCustomerManager {

	@Autowired
	AvailableProductsCustomerDao availableProductsCustomerDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beitech.common.manager.AvailableProductsCustomerManager#
	 * validarDisponibilidadProductoCliente(java.util.List,
	 * com.beitech.common.model.entities.Customer)
	 */
	@Override
	public List<Product> validarDisponibilidadProductoCliente(List<ProductDTO> listProductDTO, Customer customer) {

		List<Product> listUnavailableProducts = new ArrayList<>();

		Iterator<ProductDTO> iter = listProductDTO.iterator();
		while (iter.hasNext()) {
			ProductDTO productDTO = iter.next();

			List<AvailableProductsCustomer> listAvailableProductsCustomer = availableProductsCustomerDao
					.obtenerDisponibilidadProductoCliente(productDTO.getPrice().getProduct(), customer);

			// Si la consulta no retorna ninguna valor el producto no se
			// encuentra disponible para el cliente.
			if (listAvailableProductsCustomer.isEmpty()) {
				// Agregamos el producto a la lista de productos no disponibles
				// para el cliente.
				listUnavailableProducts.add(productDTO.getPrice().getProduct());
				// Eliminamos de la lista final el producto pues no se puede
				// procesar.
				iter.remove();
			}
		}

		return listUnavailableProducts;
	}

}
