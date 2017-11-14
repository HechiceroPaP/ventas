package com.beitech.common.dao;

import com.beitech.common.model.entities.OrderDetail;

/**
 * Interface para la clase que se encarga del acceso a datos de la tabla
 * ORDER_DETAIL
 * 
 * @author pablo.perez
 *
 */
public interface OrderDetailDao {

	/**
	 * Metodo que permite realizar el registro de un detalle de una orden.
	 * 
	 * @param orderDetail
	 */
	public void save(OrderDetail orderDetail);
}
