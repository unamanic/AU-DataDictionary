/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manicware.datadictionary.rest;

import com.manicware.datadictionary.dto.TableNameInfo;
import com.manicware.datadictionary.entities.TableName;
import com.manicware.datadictionary.entities.TableOwner;
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
@Path("tablename")
public class TableNameFacadeREST extends AbstractFacade<TableName> {

    @PersistenceContext(unitName = "DataDictionaryPU")
    private EntityManager em;

    public TableNameFacadeREST() {
        super(TableName.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TableNameInfo info) {
        TableName entity = new TableName();
        entity.setTableName(info.getTableName());
        entity.setTableOwner(em.find(TableOwner.class, info.getTableOwner()));
        entity.setDescription(info.getDescription());
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TableName entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TableName find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("owner/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TableName> findByOwner(@PathParam("id") Integer id) {
        TypedQuery<TableName> query = em.createQuery("select tn from TableName tn where tn.tableOwner.id = :id", TableName.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TableName> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TableName> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
