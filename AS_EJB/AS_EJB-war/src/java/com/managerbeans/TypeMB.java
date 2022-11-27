/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managerbeans;

import com.entities.ProductType;
import com.sessionbeans.ProductTypeFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ngocd
 */
@Named(value = "typeMB")
@RequestScoped
public class TypeMB {
   private String typename;
   private ProductType types = new ProductType();
    private String message;
    public ProductTypeFacadeLocal getProductTypeFacade() {
        return productTypeFacade;
    }

    @EJB
    private ProductTypeFacadeLocal productTypeFacade;


    public TypeMB() {
    }
    public String create(){
        types.setTypename(typename);
        productTypeFacade.create(types);
         setMessage("Add Complete !");
        return "index";
    }
    
    public  List<ProductType> showType(){
    return  productTypeFacade.findAll();
    }
        public String delete(int id) {
        productTypeFacade.remove(productTypeFacade.find(id));
        setMessage("Deleted !");
        return "index";
    }
    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public ProductType getTypes() {
        return types;
    }

    public void setTypes(ProductType types) {
        this.types = types;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
