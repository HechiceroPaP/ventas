package com.beitech.common.manager;

import java.util.List;

import com.beitech.common.model.dto.GenerarOrdenInDTO;
import com.beitech.common.model.dto.GenerarOrdenOutDTO;
import com.beitech.common.model.dto.ListarOrdenesInDTO;
import com.beitech.common.model.entities.Orders;

/**
 * Interfaz para le manager que contiene la lógica relacionada a las ordenes.
 * 
 * @author pablo.perez
 *
 */
public interface OrdersManager {

	/**
	 * Metodo que permite generar un listado de ordenes segun unos parametros.
	 * 
	 * @param listarOrdenesInDTO
	 * @return
	 */
	List<Orders> listarOrdenes(ListarOrdenesInDTO listarOrdenesInDTO);

	/**
	 * 
	 * @param generarOrdenInDTO
	 * @return
	 */
	GenerarOrdenOutDTO generarOrden(GenerarOrdenInDTO generarOrdenInDTO);
}
