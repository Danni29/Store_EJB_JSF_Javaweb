package com.cart;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateful;


@Stateful
public class CartSessionBean implements CartSessionBeanLocal {

    Map<Integer, Integer> mycart = new HashMap();

    @Override
    public void addCart(Integer id, int quanlity) {
        if (mycart.containsKey(id)) {
            mycart.replace(id, mycart.get(id).intValue() + 1);
        } else {
            mycart.put(id, 1);
        }
    }

    @Override
    public void removeCart(Integer id) {
        mycart.remove(id);
    }

    @Override
    public void updateCart(Integer id,boolean flag) {
        if(flag) {
            mycart.replace(id, mycart.get(id).intValue() + 1);
        }else{
            mycart.replace(id, mycart.get(id).intValue() - 1);
        }
    }

    @Override
    public Map<Integer, Integer> showCartMap() {
        return mycart;
    }

    @Override
    public void emptyCart() {
        mycart.clear();
    }

    @Override
    public int countCart() {
        return mycart.size();
    }
}
