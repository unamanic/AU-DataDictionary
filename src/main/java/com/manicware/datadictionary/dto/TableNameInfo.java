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
public class TableNameInfo {
    private Integer id;
    private String tableName;
    private String description;
    private Integer tableOwner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTableOwner() {
        return tableOwner;
    }

    public void setTableOwner(Integer tableOwner) {
        this.tableOwner = tableOwner;
    }
    
    
}
