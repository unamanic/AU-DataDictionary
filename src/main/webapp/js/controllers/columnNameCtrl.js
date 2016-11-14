/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    var app = angular.module('app');
    app.controller('columnNameCtrl', function ($scope, $location, columnNameService) {
        $scope.columnNames = [];

        $scope.newColumnName = {
            columnName: null,
            columnType: null,
            canNull: false,
            description: null,
            tableName: null
        };

        $scope.$watch(function () {
            return columnNameService.getColumnNames();
        }, function (columnNames) {
            $scope.columnNames = columnNames;
        });

        $scope.go = function (owner) {
            //tableNameService.setOwner(owner.id);
            $location.path('tableNames');
        };

        $scope.save = function (columnName) {
            columnNameService.saveColumnName(columnName);
        };


        $scope.add = function (columnName) {
            columnName.tableName = columnNameService.getTable();
            columnNameService.addColumnName(columnName);
            columnNameService.fetchColumnNames();
        };

        $scope.del = function (columnName) {
            columnNameService.delColumnName(columnName);
        };
    });
})();
