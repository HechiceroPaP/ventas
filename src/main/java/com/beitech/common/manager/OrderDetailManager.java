package com.beitech.common.manager;

import com.beitech.common.model.dto.GenerarOrdenInDTO;
import com.beitech.common.model.dto.GenerarOrdenOutDTO;
import com.beitech.common.model.entities.OrderDetail;
import com.beitech.common.model.entities.Orders;

/**
 * Interfaz para le manager que contiene la lógica relacionada a las ordenes.
 * 
 * @author pablo.perez
 *
 */
public interface OrderDetailManager {

	/**
	 * Metodo que permite formar la estructura para guardar un registro en la
	 * tabla OrderDetail
	 * 
	 * @param generarOrdenInDTO
	 * @param generarOrdenOutDTO
	 * @param orders
	 */
	void guardarDetalleOrden(GenerarOrdenInDTO generarOrdenInDTO, GenerarOrdenOutDTO generarOrdenOutDTO, Orders orders);

	/**
	 * Metodo que permite guardar un registro sobre la tabla OrderDetail
	 * 
	 * @param orderDetail
	 * @return
	 */
	void save(OrderDetail orderDetail);
}
