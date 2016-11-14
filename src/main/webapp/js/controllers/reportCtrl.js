/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    var app = angular.module('app');
    app.controller('reportCtrl', function ($scope, $location, columnNameService, $routeParams) {
        $scope.columnNames = [];

        $scope.userId = $routeParams.ownerId;
        columnNameService.fetchColumnNamesByOwner($scope.userId);
        
        $scope.$watch(function () {
            return columnNameService.getColumnNames();
        }, function (columnNames) {
            $scope.columnNames = columnNames;
        });

    });
})();
