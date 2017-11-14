package com.beitech.common.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beitech.common.dao.OrdersDao;
import com.beitech.common.model.dto.ListarOrdenesInDTO;
import com.beitech.common.model.entities.Orders;

/**
 * Clase encargada del acceso a dataos de la tabla ORDERS.
 * 
 * @author pablo.perez
 *
 */
@Repository
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.beitech.common.dao.OrdersDao#listarOrdenesPorMesActual(com.beitech.
	 * common.model.dto.ListarOrdenesInDTO)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> listarOrdenesPorMesActual(ListarOrdenesInDTO listarOrdenesInDTO) {
		return sessionFactory.getCurrentSession().getNamedQuery("ORDERS.listarOrdenesPorMesActual")
				.setParameter("customerId", listarOrdenesInDTO.getCustomerId()).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.beitech.common.dao.OrdersDao#listarOrdenesPorMesActual(com.beitech.
	 * common.model.dto.ListarOrdenesInDTO)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> listarOrdenesPorRangoFechas(ListarOrdenesInDTO listarOrdenesInDTO) {
		org.hibernate.Query query = sessionFactory.getCurrentSession()
				.getNamedQuery("ORDERS.listarOrdenesPorRangoFechas");

		query.setParameter("startDate", listarOrdenesInDTO.getStartDate());
		query.setParameter("endDate", listarOrdenesInDTO.getEndDate());
		query.setParameter("customerId", listarOrdenesInDTO.getCustomerId());

		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.beitech.common.dao.OrdersDao#save(com.beitech.common.model.entities.
	 * Orders)
	 */
	@Override
	public void save(Orders orders) {
		sessionFactory.getCurrentSession().persist(orders);
	}

}
