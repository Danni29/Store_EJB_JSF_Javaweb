/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managerbeans;

import com.cart.CartSessionBeanLocal;
import com.entities.Customers;
import com.entities.Order1;
import com.entities.OrderDetails;
import com.entities.Product;
import com.model.CartShopping;
import com.sessionbeans.CustomersFacadeLocal;
import com.sessionbeans.Order1FacadeLocal;
import com.sessionbeans.OrderDetailsFacadeLocal;
import com.sessionbeans.ProductFacadeLocal;
import com.sessionbeans.ProductTypeFacadeLocal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Ngocd
 */
@Named(value = "checkoutMB")
@RequestScoped
public class CheckoutMB {

    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private ProductTypeFacadeLocal productTypeFacade;

    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;

    @EJB
    private Order1FacadeLocal order1Facade;

    @EJB
    private CustomersFacadeLocal customersFacade;

    @EJB
    private CartSessionBeanLocal cartSessionBean;

    public CheckoutMB() {
    }

   private CartShopping cart = new CartShopping();
   private OrderDetails orderdetail = new OrderDetails();
   private Order1 order= new Order1();
   private Customers cus = new Customers();
      List<Integer> numCart = new ArrayList<>();
   private int price;
   private Integer quality;
   private String message;
   
   public String saveCart(String uname){
       try{
       List<CartShopping> listCart = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> setCart = cartSessionBean.showCartMap().entrySet();
        int totalMoneyCart = 0;
        int totalProCart = 0;
        for (Map.Entry<Integer, Integer> e : setCart) {
            Integer id = e.getKey();
            quality = e.getValue();
            Product pro = productFacade.find(id);
            price = pro.getPrice().intValue();
            CartShopping cShop = new CartShopping(id, pro.getProductName(), quality, price, quality * price, pro.getPic());
            listCart.add(cShop);
            numCart.add(quality);
            totalMoneyCart +=  price * quality;
            totalProCart += quality;
        }
       
   int random_int = (int)Math.floor(Math.random()*(100000-1+1)+1);
   cus=customersFacade.find(uname);
    order.setOrderID(random_int);
    order.setUserName(cus);
    order1Facade.create(order);
    orderdetail.setOrderID(random_int);
    orderdetail.setAddress(cus.getAddress());
    orderdetail.setPhone(cus.getPhone());
    orderdetail.setAmount(quality);
    orderdetail.setTotalPrice(price);
    
    orderDetailsFacade.create(orderdetail);
    message = "Order Successfully !";
   return "index";
       }
  catch(Exception e){
       return "index";
       }
   
   }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
