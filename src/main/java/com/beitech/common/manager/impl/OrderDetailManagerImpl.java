package com.beitech.common.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beitech.common.dao.OrderDetailDao;
import com.beitech.common.manager.OrderDetailManager;
import com.beitech.common.model.dto.GenerarOrdenInDTO;
import com.beitech.common.model.dto.GenerarOrdenOutDTO;
import com.beitech.common.model.dto.ProductDTO;
import com.beitech.common.model.entities.OrderDetail;
import com.beitech.common.model.entities.Orders;

/**
 * Implementación de la interfaz OrdersManager
 * 
 * @author pablo.perez
 *
 */
@Service
public class OrderDetailManagerImpl implements OrderDetailManager {

	@Autowired
	OrderDetailDao orderDetailDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.beitech.common.manager.CustomerManager#consultarPorId(java.lang.Long)
	 */
	@Transactional
	@Override
	public void save(OrderDetail orderDetail) {
		orderDetailDao.save(orderDetail);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.beitech.common.manager.OrderDetailManager#guardarDetalleOrden(com.
	 * beitech.common.model.dto.GenerarOrdenInDTO,
	 * com.beitech.common.model.dto.GenerarOrdenOutDTO,
	 * com.beitech.common.model.entities.Orders)
	 */
	@Override
	public void guardarDetalleOrden(GenerarOrdenInDTO generarOrdenInDTO, GenerarOrdenOutDTO generarOrdenOutDTO,
			Orders orders) {

		for (ProductDTO productDTO : generarOrdenOutDTO.getListProcessProducts()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(orders);
			orderDetail.setPrice(productDTO.getPrice());
			orderDetail.setQuantity(productDTO.getQuantity());
			orderDetail.setTotalValue(productDTO.getQuantity() * productDTO.getPrice().getValue());
			this.save(orderDetail);
		}

	}

}
