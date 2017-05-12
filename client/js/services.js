angular
	.module('pontoInteresseApp.services',[])
	.factory('Poi', PoiService);
	
function PoiService($resource){
	return $resource('http://localhost:8085/pontoInteresse',{},
	{
		queryNearby: {
			method: 'GET', 
			isArray: true, 
			url: 'http://localhost:8085/pontoInteresse/:x/:y/:distance',
				params: {x: "@x", y: "@y", distance: "@distance"}}
    });
}