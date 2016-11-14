/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function () {
    var app = angular.module('app', ['tableOwnerService', 'tableNameService', 'columnNameService', 'ngRoute', 'angular.filter']);
    app.constant('tableOwnerUrl', 'rest/tableowner');
    app.constant('tableNameUrl', 'rest/tablename');
    app.constant('columnNameUrl', 'rest/tablecolumn');
    app.controller("defaultCtrl", function ($scope) {
        $scope.tableOwner = null;
        $scope.tableName = null;        
    });
    app.config(function ($routeProvider, $httpProvider) {
        //Maintain Auth
        $httpProvider.defaults.withCredentials = true;

        //Routes
        $routeProvider.when("/tableNames", {
            templateUrl: "views/tableNames.html"
        }).when("/columnNames", {
            templateUrl: "views/columnNames.html"
        }).when("/report/:ownerId", {
            templateUrl: "views/report.html"
        }).otherwise({
            templateUrl: "views/default.html"
        });
    });
})();
