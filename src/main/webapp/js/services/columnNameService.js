/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    var module = angular.module('columnNameService', []);
    module.service('columnNameService', function (columnNameUrl, $http, $q) {
        var _columnNames = {value: []};
        var _table = {value: null};

        var getColumnNames = function () {
            return _columnNames.value;
        };

        var setTable = function (table) {
            _table.value = table;
            fetchColumnNames();
        };

        var getTable = function (){
            return _table.value;
        };

        var fetchColumnNames = function () {
            $http.get(columnNameUrl + '/table/' + _table.value).success(function (data) {
                _columnNames.value = data;
            });

        };

        var fetchColumnNamesByOwner = function (ownerId) {
            $http.get(columnNameUrl + '/owner/' + ownerId).success(function (data) {
                _columnNames.value = data;
            });
        };

        var saveColumnName = function (columnName) {
            $http.put(columnNameUrl + '/' + columnName.id, columnName);
        };


        var delColumnName = function (columnName){
            $http.delete(columnNameUrl + '/' + columnName.id);
        };

        var addColumnName = function (columnName) {
            $http.post(columnNameUrl, columnName);
        };

        return {
            getColumnNames: getColumnNames,
            setTable: setTable,
            getTable: getTable,
            saveColumnName: saveColumnName,
            fetchColumnNamesByOwner: fetchColumnNamesByOwner,
            fetchColumnNames: fetchColumnNames,
            delColumnName: delColumnName,
            addColumnName: addColumnName
        };
    });
})();
