angular.module('pontoInteresseApp',['ui.router','ngResource','pontoInteresseApp.controllers','pontoInteresseApp.services']);

angular.module('pontoInteresseApp').config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push(function ($q,$rootScope) {
        return {
            'responseError': function (responseError) {
                $rootScope.message = responseError.data.message;
                return $q.reject(responseError);
            }
        };
    });
}]);