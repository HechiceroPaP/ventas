var app = angular.module("app", [ "ngRoute", "ngResource" ]);

app.controller("ctrlIndex", [
		"$scope",
		"$location",
		"$rootScope",
		function($scope, $location, $rootScope) {

			/**
			 * Metodo que permite llamar la pagina que contiene el listado de
			 * ordenes de un cliente.
			 */
			$scope.listarOrdenes = function() {
				$location.path('/listarOrdenes').search({
					token : Math.random().toString(36).substr(2, 11)
				});
			};

			// Se inicializa la página
			$scope.init = function() {
				// Seteamos la lista de clientes en vacia.
				$scope.lstClientes = {};
				// Llamamos al metodo que permite invocar el servicio que lista
				// los clientes.
				$scope.listarClientes();
			};

			/**
			 * Metodo que permite listar los clientes.
			 */
			$scope.listarClientes = function() {
				$.ajax({
					url : "api/public/custumer/listarClientes",
					success : function(result) {
						$scope.lstClientes = result;
						$scope.$digest();
						if ($scope.lstClientes.length == 1) {
							$scope.customer = $scope.lstClientes[0];
						}
					}
				});
			}

			/**
			 * Metodo que se encarga de realizar la logica previa a la carga del
			 * listado de ordenes de un cliente
			 */
			$scope.cargarOrdenes = function() {
				// Se valida que se haya seleccionado un cliente
				if ($scope.customer == undefined) {
					alert('Por favor seleccione un cliente');
				} else {
					if (sessionStorage.getItem("customer") != undefined) {
						delete sessionStorage.customer;
					}

					// Seteamos en el sessionStorage el id del client
					// selecionado.
					sessionStorage.setItem("customer", JSON
							.stringify($scope.customer));
					// Cargamos la lista de ordenes.
					$scope.listarOrdenes();
				}
			}

			$scope.init();
		} ]);

app.config(function($routeProvider, $locationProvider) {
	$routeProvider.when('/listarOrdenes', {
		templateUrl : 'app/componentes/listar-ordenes/listar-ordenes.html',
		controller : 'ctrlListarOrdenes',
	}).otherwise({
		redirectTo : '/'
	});
});