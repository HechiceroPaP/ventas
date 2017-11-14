package com.beitech.common.service;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beitech.common.manager.CustomerManager;
import com.beitech.common.model.entities.Customer;

/**
 * Clase que permite definir los servicios relacionados a un cliente.
 * 
 * @author pablo.perez
 *
 */
@Component
@Path("public/custumer")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class CustumerSR {

	@Autowired
	CustomerManager customerManager;

	/**
	 * Servicio que permite listar todos los clientes.
	 * 
	 * @return
	 */
	@GET
	@Path("listarClientes")
	public List<Customer> listarClientes() {
		return customerManager.listarClientes();
	}
}
