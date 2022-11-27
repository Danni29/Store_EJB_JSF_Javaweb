/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbeans;

import com.entities.Customers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ngocd
 */
@Local
public interface CustomersFacadeLocal {

    void create(Customers customers);

    void edit(Customers customers);

    void remove(Customers customers);

    Customers find(Object id);

    List<Customers> findAll();

    List<Customers> findRange(int[] range);

    int count();
    public Customers checkUsernamePassword(String uname, String pword);
    
    public Customers checkRegister(String uname);
    
}
