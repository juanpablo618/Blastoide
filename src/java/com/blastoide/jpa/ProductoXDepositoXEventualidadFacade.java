package com.blastoide.jpa;

import com.blastoide.jsf.ProductoXDepositoXEventualidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class ProductoXDepositoXEventualidadFacade extends AbstractFacade<ProductoXDepositoXEventualidad> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoXDepositoXEventualidadFacade() {
        super(ProductoXDepositoXEventualidad.class);
    }
    
}
