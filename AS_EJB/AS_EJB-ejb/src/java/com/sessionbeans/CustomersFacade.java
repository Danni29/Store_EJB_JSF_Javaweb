/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbeans;

import com.entities.Customers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ngocd
 */
@Stateless
public class CustomersFacade extends AbstractFacade<Customers> implements CustomersFacadeLocal {

    @PersistenceContext(unitName = "AS_EJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomersFacade() {
        super(Customers.class);
    }
     @Override
    public Customers checkUsernamePassword(String uname, String pword) {
        try {
            TypedQuery<Customers> query = em.createQuery("select e from Customers e where e.username = :username and e.password = :password", Customers.class);
            query.setParameter("username", uname);
            query.setParameter("password", pword);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Customers checkRegister(String uname) {
        try {
            TypedQuery<Customers> query = em.createQuery("select e from Customers e where e.username = :username", Customers.class);
            query.setParameter("username", uname);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
    
}
