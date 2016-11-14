/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manicware.datadictionary.dto;

/**
 *
 * @author unamanic
 */
public class TableColumnInfo {
    private Integer id;
    private String columnName;
    private String columnType;
    private Boolean canNull;
    private String description;
    private Integer tableName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public Boolean getCanNull() {
        return canNull;
    }

    public void setCanNull(Boolean canNull) {
        this.canNull = canNull;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTableName() {
        return tableName;
    }

    public void setTableName(Integer tableName) {
        this.tableName = tableName;
    }
    
    
}
