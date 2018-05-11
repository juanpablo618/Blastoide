package com.blastoide.jpa;

import com.blastoide.jsf.ProductoXDeposito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class ProductoXDepositoFacade extends AbstractFacade<ProductoXDeposito> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoXDepositoFacade() {
        super(ProductoXDeposito.class);
    }
    
}
