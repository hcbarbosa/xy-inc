angular
	.module('pontoInteresseApp.controllers',[])
	.controller('PontoInteresseController', PoiController);

function PoiController($scope,$stateParams,Poi){
	$scope.APP_TITLE = "XY Inc - Poi";
    $scope.addPoi = addPoi;
	$scope.consultaPois = consultaPois;
    $scope.filtraPois = filtraPois;
	$scope.ordenarPor = ordenarPor;
		
	function addPoi(){
		$scope.pois = [];
		Poi.save(
			$scope.poi,
			function(response){
			  $scope.pois = response;
			  $scope.poi = {};
			  consultaPois();
			});
	}
	
	function filtraPois(){
		$scope.pois = [];
		Poi.queryNearby(
			{x: $scope.x, y: $scope.y, distance: $scope.distance},
			function(response){
			  $scope.pois = response;
			  $scope.x = "";
			  $scope.y = "";
			  $scope.distance = "";
			});
	}
	
	function consultaPois(){
		$scope.pois = [];
		Poi.query(
			function(response){
			  $scope.pois = response;
			});
	}
	
	function ordenarPor(chave){
		$scope.chaveOrdenacao = chave;
	}
}