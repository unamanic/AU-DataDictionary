/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    var app = angular.module('app');
    app.controller('tableNameCtrl', function ($scope, $location, tableNameService, columnNameService) {
        $scope.tableNames = [];

        $scope.$watch(function () {
            return tableNameService.getTableNames();
        }, function (tableNames) {
            $scope.tableNames = tableNames;
        });

        $scope.go = function (table) {
            columnNameService.setTable(table.id);
            $location.path('columnNames');
        };

        $scope.save = function (tableName) {
            tableNameService.saveTableName(tableName);
        };

        $scope.add = function (newTableName) {
            newTableName.tableOwner = tableNameService.getOwner();
            tableNameService.addTableName(newTableName);
            tableNameService.fetchTableNames();
        };

        $scope.del = function (tableName) {
            tableNameService.delTableName(tableName);
        };

    });
})();
