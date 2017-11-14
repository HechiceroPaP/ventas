app.controller("ctrlListarOrdenes",["$scope","$rootScope","$routeParams","$location",
    function($scope,$rootScope,$routeParams,$location){

		$scope.init = function () {
			$scope.customer = JSON.parse(sessionStorage.customer);
			console.log ("$scope.customer", $scope.customer);
			$scope.lstOrdenes = {};
			$scope.obtenerOrdenes ();
		}
		
		// Cargamos el listado de ordenes del cliente que nos llegue como parametro en el sessionStorage
		$scope.obtenerOrdenes = function () {
			console.log ('Cargamos la lista de ordenes para el cliente con id:', $scope.customer);
			
			$.ajax({
				url: "api/public/orders/listarOrdenes"
				, contentType: "application/json; charset=utf-8"
				, method: 'POST'
				, dataType: 'json'
				, data: JSON.stringify({customerId: $scope.customer.customerId})
				, success: function(result){
					$scope.lstOrdenes = result;
					
					console.log ('Mostramos la respuesta de listar ordenes');
					console.log ($scope.lstOrdenes);
					$scope.$digest();
				}
			});
		}
		
		$scope.init ();
	}
]);


