package com.beitech.common.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beitech.common.dao.OrderDetailDao;
import com.beitech.common.model.entities.OrderDetail;

/**
 * Clase encargada del acceso a datos de la tabla ORDER_DETAIL.
 * 
 * @author pablo.perez
 *
 */
@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beitech.common.dao.OrderDetailDao#save(com.beitech.common.model.
	 * entities.OrderDetail)
	 */
	@Override
	public void save(OrderDetail orderDetail) {
		sessionFactory.getCurrentSession().persist(orderDetail);
	}

}
