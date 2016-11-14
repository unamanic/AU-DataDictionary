/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manicware.datadictionary.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author unamanic
 */
@Entity
@Table(name = "table_owner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOwner.findAll", query = "SELECT t FROM TableOwner t"),
    @NamedQuery(name = "TableOwner.findById", query = "SELECT t FROM TableOwner t WHERE t.id = :id"),
    @NamedQuery(name = "TableOwner.findByTableOwner", query = "SELECT t FROM TableOwner t WHERE t.tableOwner = :tableOwner")})
public class TableOwner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "table_owner")
    private String tableOwner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tableOwner")
    private List<TableName> tableNameList;

    public TableOwner() {
    }

    public TableOwner(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableOwner() {
        return tableOwner;
    }

    public void setTableOwner(String tableOwner) {
        this.tableOwner = tableOwner;
    }

    @XmlTransient
    @JsonIgnore
    public List<TableName> getTableNameList() {
        return tableNameList;
    }

    public void setTableNameList(List<TableName> tableNameList) {
        this.tableNameList = tableNameList;
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
        if (!(object instanceof TableOwner)) {
            return false;
        }
        TableOwner other = (TableOwner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.manicware.datadictionary.entities.TableOwner[ id=" + id + " ]";
    }
    
}
