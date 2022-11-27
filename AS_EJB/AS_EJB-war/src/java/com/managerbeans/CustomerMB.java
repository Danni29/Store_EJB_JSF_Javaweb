/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managerbeans;

import com.entities.Customers;
import com.sessionbeans.CustomersFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ngocd
 */
@Named(value = "customerMB")
@RequestScoped
public class CustomerMB {

    @EJB
    private CustomersFacadeLocal customersFacade;
        private String username;
        private String password;
        private String firstname;
        private String address;
        private int phone;
    /**
     * Creates a new instance of CustomerMB
     */
    public List<Customers> showAllCustomer(){
        return customersFacade.findAll();
    }
    
    public Customers cusInfo(String username){
        return customersFacade.find(username);      
    }
    
    public CustomerMB() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
}
