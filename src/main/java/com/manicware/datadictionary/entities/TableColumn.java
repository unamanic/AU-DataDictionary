/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manicware.datadictionary.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author unamanic
 */
@Entity
@Table(name = "table_column")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableColumn.findAll", query = "SELECT t FROM TableColumn t"),
    @NamedQuery(name = "TableColumn.findById", query = "SELECT t FROM TableColumn t WHERE t.id = :id"),
    @NamedQuery(name = "TableColumn.findByColumnName", query = "SELECT t FROM TableColumn t WHERE t.columnName = :columnName"),
    @NamedQuery(name = "TableColumn.findByColumnType", query = "SELECT t FROM TableColumn t WHERE t.columnType = :columnType"),
    @NamedQuery(name = "TableColumn.findByCanNull", query = "SELECT t FROM TableColumn t WHERE t.canNull = :canNull"),
    @NamedQuery(name = "TableColumn.findByDescription", query = "SELECT t FROM TableColumn t WHERE t.description = :description")})
public class TableColumn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 128)
    @Column(name = "column_name")
    private String columnName;
    @Size(max = 128)
    @Column(name = "column_type")
    private String columnType;
    @Column(name = "can_null")
    private Boolean canNull;
    @Size(max = 2048)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "table_name_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TableName tableName;

    public TableColumn() {
    }

    public TableColumn(Integer id) {
        this.id = id;
    }

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

    public TableName getTableName() {
        return tableName;
    }

    public void setTableName(TableName tableName) {
        this.tableName = tableName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableColumn)) {
            return false;
        }
        TableColumn other = (TableColumn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.manicware.datadictionary.entities.TableColumn[ id=" + id + " ]";
    }
    
}
