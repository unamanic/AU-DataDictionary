/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manicware.datadictionary.rest;

import com.manicware.datadictionary.dto.TableColumnInfo;
import com.manicware.datadictionary.entities.TableColumn;
import com.manicware.datadictionary.entities.TableName;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author unamanic
 */
@Stateless
@Path("tablecolumn")
public class TableColumnFacadeREST extends AbstractFacade<TableColumn> {

    @PersistenceContext(unitName = "DataDictionaryPU")
    private EntityManager em;

    public TableColumnFacadeREST() {
        super(TableColumn.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(TableColumnInfo info) {
        TableColumn entity = new TableColumn();
        entity.setCanNull(info.getCanNull());
        entity.setColumnName(info.getColumnName());
        entity.setColumnType(info.getColumnType());
        entity.setDescription(info.getDescription());
        entity.setTableName(em.find(TableName.class, info.getTableName()));
        
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TableColumn entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public TableColumn find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("table/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TableColumn> findByTable(@PathParam("id") Integer id) {
        TypedQuery<TableColumn> query = em.createQuery("select tc from TableColumn tc where tc.tableName.id = :id", TableColumn.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
    
    @GET
    @Path("owner/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TableColumn> findByOwner(@PathParam("id") Integer id) {
        TypedQuery<TableColumn> query = em.createQuery("select tc from TableColumn tc where tc.tableName.tableOwner.id = :id", TableColumn.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<TableColumn> findAll() {
        TypedQuery<TableColumn> query = em.createQuery("select tc from TableColumn tc order by tc.tableName.tableName", TableColumn.class);
        return query.getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<TableColumn> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
