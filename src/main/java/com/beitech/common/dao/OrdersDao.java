package com.beitech.common.dao;

import java.util.List;

import com.beitech.common.model.dto.ListarOrdenesInDTO;
import com.beitech.common.model.entities.Orders;

/**
 * Interface para la clase que se encarga del acceso a datos de la tabla
 * ORDERS.
 * 
 * @author pablo.perez
 *
 */
public interface OrdersDao {

	/**
	 * Metodo que permite listar las ordenes de un cliente generadas en el mes
	 * actual.
	 * 
	 * @param listarOrdenesInDTO
	 * @return
	 */
	List<Orders> listarOrdenesPorMesActual(ListarOrdenesInDTO listarOrdenesInDTO);

	/**
	 * Metodo que permite consultar el listado de ordenes de un cliente en un
	 * rango de fechas dado.
	 * 
	 * @param listarOrdenesInDTO
	 * @return
	 */
	List<Orders> listarOrdenesPorRangoFechas(ListarOrdenesInDTO listarOrdenesInDTO);

	/**
	 * Metodo que permite registrar en base de datos una orden.
	 * 
	 * @param orders
	 */
	void save(Orders orders);

}
