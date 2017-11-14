package com.beitech.common.manager.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beitech.common.dao.OrdersDao;
import com.beitech.common.manager.AvailableProductsCustomerManager;
import com.beitech.common.manager.ProductManager;
import com.beitech.common.model.dto.GenerarOrdenInDTO;
import com.beitech.common.model.dto.GenerarOrdenOutDTO;
import com.beitech.common.model.dto.ProductDTO;

/**
 * Implementación de la interfaz OrdersManager
 * 
 * @author pablo.perez
 *
 */
@Service
public class ProductManagerImpl implements ProductManager {

	@Autowired
	OrdersDao ordersDao;

	@Autowired
	AvailableProductsCustomerManager availableProductsCustomerManager;

	/**
	 * Metodo que permite ordenar la lista de productos.
	 * 
	 * @param listProductDTO
	 */
	private void ordernarListaProductos(List<ProductDTO> listProductDTO) {
		// Recorremos la lista de items de la orden

		listProductDTO.sort(new Comparator<ProductDTO>() {
			@Override
			public int compare(ProductDTO o1, ProductDTO o2) {
				return o2.getPrice().getProduct().getProductId().intValue()
						- o1.getPrice().getProduct().getProductId().intValue();
			}
		});
	}

	/**
	 * Metodo que permite obtener la lista de productos unificada por producto
	 * 
	 * @param listProductDTO
	 * @param listProductDTOFinal
	 */
	private void unificarListaProductos(List<ProductDTO> listProductDTO, List<ProductDTO> listProductDTOFinal) {

		long productId = -1;
		int quantity = 0;
		for (ProductDTO productDTO : listProductDTO) {
			// Si es la primera iteracion o el producto anterior es diferente al
			// actual iniciamos o reiniciamos variables auxiliares y agregamos a
			// la lista el nuevo producto.
			if (listProductDTOFinal.isEmpty()
					|| productId != productDTO.getPrice().getProduct().getProductId().longValue()) {
				// Obtenemos el id del producto para comparar con el siguiente
				productId = productDTO.getPrice().getProduct().getProductId().longValue();
				// Obtenemos la cantidad para incrementar la cantidad del
				// producto si es necesario
				quantity = productDTO.getQuantity();
				// Agregamos a la lista el nuevo producto
				listProductDTOFinal.add(productDTO);
			} else if (productId == productDTO.getPrice().getProduct().getProductId().longValue()) {
				// Si el producto es igual al anterior solamente incrementamos
				// la cantidad del producto anterior.
				listProductDTOFinal.get(listProductDTOFinal.size() - 1)
						.setQuantity(quantity + productDTO.getQuantity());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beitech.common.manager.ProductManager#validarListaProductos(com.
	 * beitech.common.model.dto.GenerarOrdenInDTO,
	 * com.beitech.common.model.dto.GenerarOrdenOutDTO)
	 */
	@Override
	public boolean validarListaProductos(GenerarOrdenInDTO generarOrdenInDTO, GenerarOrdenOutDTO generarOrdenOutDTO) {

		List<ProductDTO> listProductDTO = generarOrdenInDTO.getListProductDTO();

		if (listProductDTO.isEmpty()) {
			generarOrdenOutDTO.setSuccess(false);
			generarOrdenOutDTO
					.setMessage("La lista de productos se encuentra vacia. Por favor verifique y vuelva a intentar.");
			return false;
		}

		List<ProductDTO> listProductDTOFinal = new ArrayList<>();
		this.ordernarListaProductos(listProductDTO);
		this.unificarListaProductos(listProductDTO, listProductDTOFinal);

		generarOrdenOutDTO.setListUnavailableProducts(availableProductsCustomerManager
				.validarDisponibilidadProductoCliente(listProductDTOFinal, generarOrdenInDTO.getCustomer()));

		if (!generarOrdenOutDTO.getListUnavailableProducts().isEmpty() && listProductDTOFinal.isEmpty()) {
			generarOrdenOutDTO.setSuccess(false);
			generarOrdenOutDTO
					.setMessage("El listado de productos suministrado se encuentra inhabilitado para el cliente.");
			return false;
		}

		if ((generarOrdenInDTO.isTotalQuantity() && this.obtenerTotalQuantity(listProductDTOFinal) > 5)
				|| (!generarOrdenInDTO.isTotalQuantity() && listProductDTOFinal.size() > 5)) {
			generarOrdenOutDTO.setSuccess(false);
			generarOrdenOutDTO
					.setMessage("El número de productos de la orden es superior a limite permitido por cliente.");
			return false;
		}

		generarOrdenOutDTO.setListProcessProducts(listProductDTOFinal);

		return true;
	}

	/**
	 * Metodo que permite obtener el nro total de productos de la solicitud.
	 * 
	 * @param listProductDTOFinal
	 * @return
	 */
	private int obtenerTotalQuantity(List<ProductDTO> listProductDTOFinal) {
		int quatity = 0;
		for (ProductDTO productDTO : listProductDTOFinal) {
			quatity += productDTO.getQuantity();
		}
		return quatity;
	}

}
