package com.beitech.common.manager.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beitech.common.dao.OrdersDao;
import com.beitech.common.manager.CustomerManager;
import com.beitech.common.manager.OrderDetailManager;
import com.beitech.common.manager.OrdersManager;
import com.beitech.common.manager.ProductManager;
import com.beitech.common.model.dto.GenerarOrdenInDTO;
import com.beitech.common.model.dto.GenerarOrdenOutDTO;
import com.beitech.common.model.dto.ListarOrdenesInDTO;
import com.beitech.common.model.dto.ProductDTO;
import com.beitech.common.model.entities.Customer;
import com.beitech.common.model.entities.Orders;

/**
 * Implementación de la interfaz OrdersManager
 * 
 * @author pablo.perez
 *
 */
@Service
public class OrdersManagerImpl implements OrdersManager {

	@Autowired
	OrdersDao ordersDao;

	@Autowired
	ProductManager productManager;

	@Autowired
	CustomerManager customerManager;

	@Autowired
	OrderDetailManager orderDetailManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.beitech.common.manager.OrdersManager#generarOrden(com.beitech.common.
	 * model.dto.GenerarOrdenInDTO)
	 */
	@Transactional
	@Override
	public GenerarOrdenOutDTO generarOrden(GenerarOrdenInDTO generarOrdenInDTO) {

		GenerarOrdenOutDTO generarOrdenOutDTO = new GenerarOrdenOutDTO();
		if (this.validarOrden(generarOrdenInDTO, generarOrdenOutDTO)) {
			Orders orders = this.guardarOrden(generarOrdenInDTO, generarOrdenOutDTO);
			orderDetailManager.guardarDetalleOrden(generarOrdenInDTO, generarOrdenOutDTO, orders);
			generarOrdenOutDTO.setSuccess(true);
			generarOrdenOutDTO.setMessage("El registro de la orden se generó satisfactoriamente.");
		}

		return generarOrdenOutDTO;
	}

	/**
	 * Metodo que permite generar la fecha correspondiente al año y mes de un
	 * dia especifico
	 * 
	 * @param initial
	 * @param day
	 * @return
	 */
	private Date generateDateFromLocalDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Metodo que permite generar la estructura para guardar un registro sobre
	 * la tabla orders
	 * 
	 * @param generarOrdenInDTO
	 * @param generarOrdenOutDTO
	 * @return
	 */
	private Orders guardarOrden(GenerarOrdenInDTO generarOrdenInDTO, GenerarOrdenOutDTO generarOrdenOutDTO) {
		Orders orders = new Orders();
		orders.setCreationDate(new Date());
		orders.setCustomer(generarOrdenInDTO.getCustomer());
		orders.setDeliveryAddress(generarOrdenInDTO.getDeliveryAddress());
		orders.setTotal(this.obtenerTotalOrden(generarOrdenOutDTO.getListProcessProducts()));

		ordersDao.save(orders);

		return orders;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.beitech.common.manager.OrdersManager#listarOrdenes(com.beitech.common
	 * .entities.ListarOrdenesInDTO)
	 */
	@Transactional
	@Override
	public List<Orders> listarOrdenes(ListarOrdenesInDTO listarOrdenesInDTO) {
		if (listarOrdenesInDTO.getStartDate() == null && listarOrdenesInDTO.getEndDate() == null) {

			LocalDate localDate = LocalDate.now();

			// Se setea la fecha inicial con el primer dia del mes actual.
			listarOrdenesInDTO.setStartDate(this.generateDateFromLocalDate(localDate.withDayOfMonth(1)));

			// Se setea la fecha final con el ultimo dia del mes actual.
			listarOrdenesInDTO
					.setEndDate(this.generateDateFromLocalDate(localDate.withDayOfMonth(localDate.lengthOfMonth())));
		}

		return ordersDao.listarOrdenesPorRangoFechas(listarOrdenesInDTO);
	}

	/**
	 * Metodo que permite obtener el valor total de la orden.
	 * 
	 * @param listProcessProducts
	 * @return
	 */
	private Double obtenerTotalOrden(List<ProductDTO> listProcessProducts) {

		Double total = 0d;

		for (ProductDTO productDTO : listProcessProducts) {
			total += (productDTO.getQuantity() * productDTO.getPrice().getValue());
		}

		return total;
	}

	/**
	 * Metodo que permite validar la informacion de entrada para el registro de
	 * una orden.
	 * 
	 * @param generarOrdenInDTO
	 * @param generarOrdenOutDTO
	 * @return
	 */
	private boolean validarOrden(GenerarOrdenInDTO generarOrdenInDTO, GenerarOrdenOutDTO generarOrdenOutDTO) {
		// Validamos que el cliente exista en la base de datos.
		List<Customer> lstCustomer = customerManager.consultarPorId(generarOrdenInDTO.getCustomer().getCustomerId());
		if (lstCustomer.isEmpty()) {
			generarOrdenOutDTO.setSuccess(false);
			generarOrdenOutDTO.setMessage("No fue posible encontrar el cliente");
			return false;
		}

		// Validamos la lista de productos
		return productManager.validarListaProductos(generarOrdenInDTO, generarOrdenOutDTO);
	}

}
