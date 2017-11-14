package com.beitech.common.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beitech.common.dao.AvailableProductsCustomerDao;
import com.beitech.common.model.entities.AvailableProductsCustomer;
import com.beitech.common.model.entities.Customer;
import com.beitech.common.model.entities.Product;

/**
 * Clase encargada del acceso a datos de la tabla AVAILABLE_PRODUCTS_CUSTOMER
 * 
 * @author pablo.perez
 *
 */
@Repository
public class AvailableProductsCustomerDaoImpl implements AvailableProductsCustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beitech.common.dao.AvailableProductsCustomerDao#
	 * obtenerDisponibilidadProductoCliente(com.beitech.common.model.entities.
	 * Product, com.beitech.common.model.entities.Customer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AvailableProductsCustomer> obtenerDisponibilidadProductoCliente(Product product, Customer customer) {
		return sessionFactory.getCurrentSession()
				.getNamedQuery("AVAILABLE_PRODUCTS_CUSTOMER.consultarDisponibilidadProductoCliente")
				.setParameter("productId", product.getProductId()).setParameter("customerId", customer.getCustomerId())
				.setParameter("active", "S").list();
	}

}
