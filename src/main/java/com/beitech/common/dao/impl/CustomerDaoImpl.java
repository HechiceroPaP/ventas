package com.beitech.common.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beitech.common.dao.CustomerDao;
import com.beitech.common.model.entities.Customer;

/**
 * Clase encargada del acceso a datos para la tabla CUSTOMER.
 * 
 * @author pablo.perez
 *
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beitech.common.dao.CustomerDao#consultarPorId(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> consultarPorId(Long customerId) {
		return sessionFactory.getCurrentSession().getNamedQuery("CUSTOMER.consultarPorId")
				.setParameter("customerId", customerId).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beitech.common.dao.CustomerDao#listarClientes()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listarClientes() {
		return sessionFactory.getCurrentSession().getNamedQuery("CUSTOMER.findAll").list();
	}

}
