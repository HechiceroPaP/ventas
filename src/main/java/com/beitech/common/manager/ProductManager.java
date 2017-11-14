package com.beitech.common.manager;

import com.beitech.common.model.dto.GenerarOrdenInDTO;
import com.beitech.common.model.dto.GenerarOrdenOutDTO;

/**
 * Interfaz para le manager que contiene la lógica relacionada a los productos.
 * 
 * @author pablo.perez
 *
 */
public interface ProductManager {

	/**
	 * Metodo que permite validar la lista de productos a registrar en la orden
	 * 
	 * @param generarOrdenInDTO
	 * @param generarOrdenOutDTO
	 * @return 
	 */
	public boolean validarListaProductos(GenerarOrdenInDTO generarOrdenInDTO, GenerarOrdenOutDTO generarOrdenOutDTO);

}
