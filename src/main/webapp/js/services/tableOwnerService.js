/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    var module = angular.module('tableOwnerService', []);
    module.service('tableOwnerService', function (tableOwnerUrl, $http, $q) {
        var _tableOwners = {value: []};

        var getTableOwners = function () {
            return _tableOwners.value;
        };

        var fetchTableOwners = function () {
            $http.get(tableOwnerUrl).success(function (data) {
                _tableOwners.value = data;
            });
        };

        var createTableOwner = function (tableOwner) {
            $http.post(tableOwnerUrl, tableOwner).success(function (){
                //do something
            });
        };
        
        fetchTableOwners();

        return {
            getTableOwners: getTableOwners,
            fetchTableOwners: fetchTableOwners,
            createTableOwner: createTableOwner
        };
    });
})();
