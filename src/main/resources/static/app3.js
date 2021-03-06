'use strict';

//
angular.module('myApp', [
	'ngCsvImport'
])

.controller('NovyProductController', ['$scope', '$http', '$log', function($scope, $http, $log) {
	
    $scope.csv = {
        	content: 'content',
        	header: true,
        	headerVisible: true,
        	separator: ';',
        	separatorVisible: true,
        	result: 'jaja',
        	encoding: 'ISO-8859-1',
        	encodingVisible: true,
            uploadButtonLabel: "upload a csv file"
        };
		
	$http({
		method: 'GET',
		url: 'poistovne'
	}).then(
			function ok(xxx) {
				$scope.poistovne = xxx.data;
			},
			function ko(xxx) {
				alert(xxx);
			}
	);
	
	$http({
		method: 'GET',
		url: 'typyProduktov'
	}).then(
			function ok(xxx) {
				$scope.typyProduktov = xxx.data;
			},
			function ko(xxx) {
				alert(xxx);
			}
	);
	
	$scope.onFormSubmit = function() {
		
		$http({
			method: 'POST',
			url: 'products',
			data: $scope.current
		})
		.then(
				function ok() {res},
				function ko() {res}
		);
		
	};
	
	$scope.onFormSubmit = function() {
		
		$http({
			method : 'POST',
			url : 'pridajProdukt',
			data: $scope.current
		})
		.then(
				function ok(response) {
					
				}, 
				function ko(response) {
					window.alert("V DB sa už daný produkt nachádza!");
				}
		);
		
	};
	
	
}])

.controller('PoistovneController', ['$log', '$http', '$scope', function($log, $http, $scope) {
	
	//$scope.poistovne = [{"id":1, "nazov":"poistovna 1"}, {"id":2, "nazov":"poistovna 2"}];
	
	$http({
		method: 'GET',
		url: 'typyProduktov'
	}).then(
			
			function ok(response) {
				
				$scope.typyProduktov = response.data
				
			},
			
			function ko(response) {
				
			}
			
	);
		
	
//	var data = {
//			"vek": 15,
//			"rizikovaSkupina": 1,
//			"nazovTypuProduktu": "Hospitalizacia",
//			"dobaPoistenia": 30,
//			"cielovaSumaPoistenia": 20000
//		};
//
//	
//	$http({
//		method : 'POST',
//		url : 'http://localhost:8080/vyhovujucePoistovne',
//		data: data
//	})
//	.then(
//			function ok(response) {
//
//				$log.debug(response.data);
//				
//				$scope.poistovne = response.data;
//								
//			}, 
//			function ko(response) {
//
//				alert(response);
//
//			}
//	);
	
	
	$scope.onFormSubmit = function() {
		
		$http({
			method : 'POST',
			url : 'vyhovujucePoistovne',
			data: $scope.current
		})
		.then(
				function ok(response) {

					$log.debug(response.data);
					
					$scope.poistovne = response.data;
									
				}, 
				function ko(response) {


					$log.error(response);
					
				}
		);
		
	};

	
}]);