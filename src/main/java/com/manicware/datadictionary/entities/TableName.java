/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manicware.datadictionary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author unamanic
 */
@Entity
@Table(name = "table_name")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableName.findAll", query = "SELECT t FROM TableName t"),
    @NamedQuery(name = "TableName.findById", query = "SELECT t FROM TableName t WHERE t.id = :id"),
    @NamedQuery(name = "TableName.findByTableName", query = "SELECT t FROM TableName t WHERE t.tableName = :tableName"),
    @NamedQuery(name = "TableName.findByDescription", query = "SELECT t FROM TableName t WHERE t.description = :description")})
public class TableName implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "table_name")
    private String tableName;
    @Size(max = 2048)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "table_owner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TableOwner tableOwner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tableName")
    private List<TableColumn> tableColumnList;

    public TableName() {
    }

    public TableName(Integer id) {
        this.id = id;
    }

    public TableName(Integer id, String tableName) {
        this.id = id;
        this.tableName = tableName;
    }

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

    public TableOwner getTableOwner() {
        return tableOwner;
    }

    public void setTableOwner(TableOwner tableOwner) {
        this.tableOwner = tableOwner;
    }

    @XmlTransient
    @JsonIgnore
    public List<TableColumn> getTableColumnList() {
        return tableColumnList;
    }

    public void setTableColumnList(List<TableColumn> tableColumnList) {
        this.tableColumnList = tableColumnList;
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
        if (!(object instanceof TableName)) {
            return false;
        }
        TableName other = (TableName) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.manicware.datadictionary.entities.TableName[ id=" + id + " ]";
    }
    
}
