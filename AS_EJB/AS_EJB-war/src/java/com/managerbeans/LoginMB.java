/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managerbeans;

import com.entities.Customers;
import com.sessionbeans.CustomersFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Ngocd
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {
HttpServletRequest request;
    @EJB
    private CustomersFacadeLocal customersFacade;

    /**
     * Creates a new instance of LoginMB
     */
     private String username;
    private String password ;
    private String message;

      public String checkLogin(ComponentSystemEvent event) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
            if (username == null) {
                navigationHandler.handleNavigation(context, null, "login.xhtml");
            }
        } catch (Exception e) {
            return "login";
        }
    return "login";

    }
     public void checkIndex(ComponentSystemEvent event) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
            if (username != null) {
                navigationHandler.handleNavigation(context, null, "index.xhtml");
            }
        } catch (Exception e) {
            return;
        }

    }
      public String Logout() {
        username = null;
        password = null;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "login";
    }
  public void checkLoginAdmin(ComponentSystemEvent event) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
            if (!"admin".equals(username) && !"Admin29@".equals(password)) {
                navigationHandler.handleNavigation(context, null, "../login");
            }
        } catch (Exception e) {
            return;
        }

    }
    public String login(){
   
           try {
            if (username.equals("admin") && password.equals("Admin29@")) {
                return "admin/index";
            }
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
            Customers customer = customersFacade.checkUsernamePassword(username, myHash);
            if (customer != null) {
                return "index";
            }
            setMessage("Username or password is valid !");
            return "login";
        } catch (NoSuchAlgorithmException e) {
            setMessage("Username or password is valid !");
            return "login";
        }
           
    }
    public LoginMB() {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
