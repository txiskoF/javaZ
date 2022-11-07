/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.pruebaejbjpa.servicio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.zabalburu.pruebaejbjpa.modelo.Supplier;

/**
 *
 * @author ichueca
 */
@Stateless
public class SupplierFacade extends AbstractFacade<Supplier> {

    @PersistenceContext(unitName = "PruebaEJBJPAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupplierFacade() {
        super(Supplier.class);
    }
    
}
