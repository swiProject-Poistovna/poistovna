//
angular.module('myApp', [])

.run(function($rootScope){
})

.controller('ReceptyController', ['$log', '$http', '$scope', function($log, $http, $scope) {
	
	getReceptyList();
	
	/*
	 * Nacitanie zoznamu receptov zo servra.
	 */
	function getReceptyList()
	{
		$http({
			method : 'GET',
			url : 'http://localhost:8080/recepty'
		})
		.then(
				function ok(response) {					
					$scope.recepty = response.data;					
				},
				
				function ko(response) {
					$log.log(response);
					$log.log('getReceptyList');
					$log.log('error');					
					alert(response.data.message);
				}
			);		
	}
	
	$scope.onReceptyClick = function(r)
	{
		$log.log(r);
		$scope.current = r;
	}
	
	$scope.onReceptDelete = function(r)
	{
		if (confirm("delete?")) {
			
			$http({
				method : 'DELETE',
				url : 'http://localhost:8080/recepty/' + r.id
			}).then(function ok(response) {

				// znova nacitame zoznam receptov
				getReceptyList();
								
			}, function ko(response) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
				
				$log.log(response);
				$log.log('onReceptDelete');
				$log.log('error');
				
				alert(response.data.message);
			});
			
		}
	}
	
	/*
	 * ? udalosti pridania ingrediencie
	 */
	$scope.onIngrediencieAdd = function() 
	{
		if ( ! $scope.current) {
			$scope.current = new Object();
		}
		if ( ! $scope.current.zoznamIngrediencii) {
			$scope.current.zoznamIngrediencii = [];
		}
		$scope.current.zoznamIngrediencii.push(new Object());
	}
	
	/*
	 * ? submit formulara
	 */
	$scope.onFormSubmit = function()
	{
		$log.log($scope.current);
		
		if ($scope.current.id) {
			$http({
				method : 'PUT',
				url : 'http://localhost:8080/recepty/' + $scope.current.id,
				data: $scope.current			
			}).then(function ok(response) {

				// znova nacitame zoznam receptov
				getReceptyList();
								
			}, function ko(response) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
				
				$log.log(response);
				$log.log('update');
				$log.log('error');
				
				alert(response.data.message);
			});
		}
		else {
			$http({
				method : 'POST',
				url : 'http://localhost:8080/recepty/',
				data: $scope.current			
			}).then(function ok(response) {

				// znova nacitame zoznam receptov
				getReceptyList();
								
			}, function ko(response) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
				
				$log.log(response);
				$log.log('pridanie');
				$log.log('error');
				
				alert(response.data.message);
			});
		}		
	}
	
	$scope.onReceptAdd = function()
	{
		$scope.current = new Object();
	}
	
	$scope.onSearchClick = function(fulltextSearch)
	{
		$http({
			method : 'GET',
			url : 'http://localhost:8080/recepty?retazec=' + fulltextSearch
		}).then(function ok(response) {

			// znova nacitame zoznam receptov
			$scope.recepty = response.data;
							
		}, function ko(response) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			$log.log(response);
			$log.log('onSearchClick');
			$log.log('error');
			
			alert(response.data.message);
		});		
	}
	
	$scope.onSearchRemove = function()
	{
		$scope.fulltextSearch = "";
		getReceptyList();
	}
	
	
	$scope.onAsterixClick = function(fulltextSearch)
	{
		$http({
			method : 'GET',
			url : 'http://localhost:8080/receptyext?retazec=' + fulltextSearch
		}).then(function ok(response) {

			// znova nacitame zoznam receptov
			$scope.recepty = response.data;
							
		}, function ko(response) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
			
			$log.log(response);
			$log.log('onAsterixClick');
			$log.log('error');
			
			alert(response.data.message);
		});		
	}

}]);