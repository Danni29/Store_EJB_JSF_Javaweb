/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Ngocd
 */

public class CartShopping {
    private int proID;
    private String proName;
    private int quantity;
    private int price;
    private int totalprice;

    public CartShopping(int proID, String proName, int quantity, int price, int totalprice, String image) {
        this.proID = proID;
        this.proName = proName;
        this.quantity = quantity;
        this.price = price;
        this.totalprice = totalprice;
        this.image = image;
    }
    private String image;

    public CartShopping() {
    }


    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

}
