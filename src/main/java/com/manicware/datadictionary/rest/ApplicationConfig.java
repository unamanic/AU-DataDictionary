/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manicware.datadictionary.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author unamanic
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:

        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.manicware.datadictionary.rest.TableColumnFacadeREST.class);
        resources.add(com.manicware.datadictionary.rest.TableNameFacadeREST.class);
        resources.add(com.manicware.datadictionary.rest.TableOwnerFacadeREST.class);
    }
    
}
