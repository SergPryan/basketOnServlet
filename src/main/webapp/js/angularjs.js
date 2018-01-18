app = angular.module('basketApp',['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/basket', {
            templateUrl: 'pages/basket.html',
            controller: 'appCtrl'
        })
        .when('/list_product', {
            templateUrl: 'pages/list_product.html',
            controller: 'appCtrl'
        })
        .otherwise({redirectTo:'/'});
}]);

app.controller('appCtrl',function ($scope,$http) {
    $http.get('/product').then(function (response) {
        $scope.products = response.data
    });
    $http.get('/basket').then(function (response) {
        $scope.productsInBasket = response.data
    });
    $scope.addToBasket = function (index) {
        $http.put('/basket',$scope.products[index]);
        $http.get('/basket').then(function (response) {
            $scope.productsInBasket = response.data
        })

    };
    $scope.deleteFromBasket = function (index) {
        var idElement = $scope.productsInBasket[index]['id'];
        $http.delete('/basket?id='+idElement);
        $scope.productsInBasket.splice(index,1)

    };
    $scope.createOrder = function () {
        var data = { "fullName": $scope.fullName,
            "telephone":$scope.telephone
        };
        $scope.fullName ='';
        $scope.telephone = '';
        $scope.productsInBasket = [];
        $http.post('/basket',data)
    }
});