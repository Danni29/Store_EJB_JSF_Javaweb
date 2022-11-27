/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managerbeans;

import com.entities.Customers;
import com.sessionbeans.CustomersFacadeLocal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Ngocd
 */
@Named(value = "registerMB")
@RequestScoped
public class RegisterMB {

    @EJB
    private CustomersFacadeLocal customersFacade;

    /**
     * Creates a new instance of RegisterMB
     */
    private String username;
    private String password;
    private String repassword;
    private String address;
    private String phone;
    private String firstname;
   private String message;
    
    public List<Customers> showCustomer(){
        return customersFacade.findAll();
    }
    public String register() throws NoSuchAlgorithmException {
        Customers customers = customersFacade.checkRegister(username);
        if (customers != null) {
            setMessage("Username already exists");
            return "login";
        } else {
            if (password.equals(repassword)) {
                Customers customer = new Customers();
                customer.setUsername(username);
                customer.setAddress(address);
                customer.setPhone(phone);
                customer.setFirstname(firstname);
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] digest = md.digest();
                String hash = DatatypeConverter
                        .printHexBinary(digest).toUpperCase();
                customer.setPassword(hash);
                customersFacade.create(customer);
                return "index";
            } else {
                setMessage("Passwords do not match.");
                return "login";
            }

        }
    }
    
    
    public RegisterMB() {
    }

    public CustomersFacadeLocal getCustomersFacade() {
        return customersFacade;
    }

    public void setCustomersFacade(CustomersFacadeLocal customersFacade) {
        this.customersFacade = customersFacade;
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

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
