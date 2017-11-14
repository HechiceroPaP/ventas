package com.beitech.common.service;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beitech.common.manager.OrdersManager;
import com.beitech.common.model.dto.GenerarOrdenInDTO;
import com.beitech.common.model.dto.GenerarOrdenOutDTO;
import com.beitech.common.model.dto.ListarOrdenesInDTO;
import com.beitech.common.model.entities.Orders;

/**
 * Clase que permite definir los servicios relacionados a una orden.
 * 
 * @author pablo.perez
 *
 */
@Component
@Path("public/orders")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class OrdersSR {

	@Autowired
	OrdersManager ordersManager;

	/**
	 * Servicio encargado de listar las ordenes de un cliente.
	 * 
	 * @param listarOrdenesInDTO
	 * @return
	 */
	@POST
	@Path("listarOrdenes")
	public List<Orders> listarOrdenes(ListarOrdenesInDTO listarOrdenesInDTO) {
		return ordersManager.listarOrdenes(listarOrdenesInDTO);
	}

	/**
	 * Servicio que se encarga de generar una orden.
	 * 
	 * @param generarOrdenInDTO
	 * @return
	 */
	@POST
	@Path("generarOrden")
	public GenerarOrdenOutDTO generarOrden(GenerarOrdenInDTO generarOrdenInDTO) {
		return ordersManager.generarOrden(generarOrdenInDTO);
	}

}
