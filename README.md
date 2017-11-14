Por medio de la siguiente url se puede probar el servicio a través del cual se puede generar una orden.

http://localhost:8080/facturacionWeb/api/public/orders/generarOrden

Como parametros es necesario enviar la siguiente estructura JSON

* ERROR productos inhabilitados
	{
	  "customer": {
		"customerId": 1,
		"name": "PABLO PEREZ",
		"email": "ingsispablo@gmail.com"
	  },
	  "totalQuantity": false,
	  "deliveryAddress": "Transversal 77 # 51a - 33",
	  "listProductDTO": [
		{
		  "price": {
			"priceId": 3,
			"product": {
			  "productId": 2,
			  "name": "PAPAS"
			},
			"value": 30000,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 3
		}
	  ]
	}
	
* ERROR mas de 5 productos (Es necesario habilitar todos los productos sobre la tabla available_products_customer)
	{
	  "customer": {
		"customerId": 1,
		"name": "PABLO PEREZ",
		"email": "ingsispablo@gmail.com"
	  },
	  "totalQuantity": false,
	  "deliveryAddress": "Transversal 77 # 51a - 33",
	  "listProductDTO": [
		{
		  "price": {
			"priceId": 3,
			"product": {
			  "productId": 2,
			  "name": "PAPAS"
			},
			"value": 30000,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 3
		},
		{
		  "price": {
			"priceId": 4,
			"product": {
			  "productId": 4,
			  "name": "TOMATES"
			},
			"value": 10000,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 30
		},
		{
		  "price": {
			"priceId": 1,
			"product": {
			  "productId": 3,
			  "name": "ARROZ"
			},
			"value": 50000,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 5
		},
		{
		  "price": {
			"priceId": 2,
			"product": {
			  "productId": 1,
			  "name": "HUEVOS"
			},
			"value": 20000,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 12
		},
		{
		  "price": {
			"priceId": 5,
			"product": {
			  "productId": 5,
			  "name": "NARANJAS"
			},
			"value": 2500,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 20
		},
		{
		  "price": {
			"priceId": 6,
			"product": {
			  "productId": 6,
			  "name": "LIMONES"
			},
			"value": 2000,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 10
		}
	  ]
	}
	
* SUCCESS (Una vez habilitados todos los productos, simplemente eliminamos un producto de la lista anterior).
	{
	  "customer": {
		"customerId": 1,
		"name": "PABLO PEREZ",
		"email": "ingsispablo@gmail.com"
	  },
	  "totalQuantity": false,
	  "deliveryAddress": "Transversal 77 # 51a - 33",
	  "listProductDTO": [
		{
		  "price": {
			"priceId": 3,
			"product": {
			  "productId": 2,
			  "name": "PAPAS"
			},
			"value": 30000,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 3
		},
		{
		  "price": {
			"priceId": 4,
			"product": {
			  "productId": 4,
			  "name": "TOMATES"
			},
			"value": 10000,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 30
		},
		{
		  "price": {
			"priceId": 1,
			"product": {
			  "productId": 3,
			  "name": "ARROZ"
			},
			"value": 50000,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 5
		},
		{
		  "price": {
			"priceId": 2,
			"product": {
			  "productId": 1,
			  "name": "HUEVOS"
			},
			"value": 20000,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 12
		},
		{
		  "price": {
			"priceId": 5,
			"product": {
			  "productId": 5,
			  "name": "NARANJAS"
			},
			"value": 2500,
			"startDate": "2017-11-10",
			"endDate": "2017-11-10",
			"active": "S"
		  },
		  "quantity": 20
		}
	  ]
	}
	