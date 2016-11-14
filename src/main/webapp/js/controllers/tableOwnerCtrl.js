/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    var app = angular.module('app');
    app.controller('tableOwnerCtrl', function ($scope, $location, tableOwnerService, tableNameService, columnNameService) {
        $scope.tableOwners = [];

        $scope.newTableOwner;

        $scope.$watch(function () {
            return tableOwnerService.getTableOwners();
        }, function (tableOwners) {
            $scope.tableOwners = tableOwners;
        });

        $scope.go = function (owner) {
            tableNameService.setOwner(owner.id);
            $location.path('tableNames');
        };

        $scope.report = function (id) {
            columnNameService.setTable(null);
            $location.path('report/' + id);
        };

        $scope.add = function() {
            tableOwnerService.createTableOwner({
                tableOwner: $scope.newTableOwner
            });
            $scope.newTableOwner;
        }
    });
})();
