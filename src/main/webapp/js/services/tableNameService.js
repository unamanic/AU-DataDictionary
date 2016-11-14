/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    var module = angular.module('tableNameService', []);
    module.service('tableNameService', function (tableNameUrl, $http, $q) {
        var _tableNames = {value: []};
        var _owner = {value: null};

        var getTableNames = function () {
            return _tableNames.value;
        };

        var setOwner = function (owner) {
            _owner.value = owner;
            fetchTableNames();
        };

        var getOwner = function () {
            return _owner.value;
        };

        var fetchTableNames = function () {
            $http.get(tableNameUrl + '/owner/' + _owner.value).success(function (data) {
                _tableNames.value = data;
            });
        };
        
        var saveTableName = function (tableName){
            $http.put(tableNameUrl + '/' + tableName.id, tableName);
        };

        var delTableName = function (tableName){
            $http.delete(tableNameUrl + '/' + tableName.id);
        };

        var addTableName = function (newTableName) {
            $http.post(tableNameUrl, newTableName);
        };

        return {
            getTableNames: getTableNames,
            setOwner: setOwner,
            getOwner: getOwner,
            saveTableName:saveTableName,
            fetchTableNames: fetchTableNames,
            addTableName: addTableName,
            delTableName: delTableName
        };
    });
})();
