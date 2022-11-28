/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbeans;

import com.entities.Customers;
import com.entities.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 *
 * @author Ngocd
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {

    @PersistenceContext(unitName = "AS_EJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

   @Override
    public List<Product> searchByTitle(String title) {
         try {
            TypedQuery<Product> query = em.createQuery("select p from Product p where p.productName LIKE :title", Product.class);
            query.setParameter("title", "%"+title+"%");
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }


  
    
    
    
}
