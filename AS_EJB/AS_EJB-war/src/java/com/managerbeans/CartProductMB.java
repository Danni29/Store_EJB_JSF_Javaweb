package com.managerbeans;




import com.cart.CartSessionBeanLocal;
import com.entities.Order1;
import com.entities.Product;
import com.model.CartShopping;
import com.sessionbeans.Order1FacadeLocal;
import com.sessionbeans.OrderDetailsFacadeLocal;
import com.sessionbeans.ProductFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;


@Named(value = "cartProductMB")
@SessionScoped
public class CartProductMB implements Serializable {
HttpServletRequest request;
    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private CartSessionBeanLocal cartSessionBean;


    private int num;
    List<Integer> numCart = new ArrayList<>();
    private double totalMoneyCart;
    private int totalProCart;

    public CartProductMB() {
    }

    public String addCartProduct(Integer idPro) {
        cartSessionBean.addCart(idPro, 1);
        return "cart";
    }

    public List<CartShopping> showCartMB() {
        List<CartShopping> listCart = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> setCart = cartSessionBean.showCartMap().entrySet();
        totalMoneyCart = 0;
        totalProCart = 0;
        for (Map.Entry<Integer, Integer> e : setCart) {
            Integer id = e.getKey();
            Integer quality = e.getValue();
            Product pro = productFacade.find(id);
            int price = pro.getPrice().intValue();
            CartShopping cShop = new CartShopping(id, pro.getProductName(), quality, price, quality * price, pro.getPic());
            listCart.add(cShop);
            numCart.add(quality);
            totalMoneyCart +=  price * quality;
            totalProCart += quality;
        }
        return listCart;
    }


    public void updateCart(int id, boolean flag) {
        cartSessionBean.updateCart(id, flag);
    }

    public String removeCart(int id) {
        cartSessionBean.removeCart(id);
        return "cart";
    }

    public String emptyCart() {
        cartSessionBean.emptyCart();
        return "cart";
    }

    public int countCart() {
        return cartSessionBean.countCart();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getTotalMoneyCart() {
        return totalMoneyCart;
    }

    public void setTotalMoneyCart(double totalCart) {
        this.totalMoneyCart = totalCart;
    }

    public int getTotalProCart() {
        return totalProCart;
    }

    public void setTotalProCart(int totalProCart) {
        this.totalProCart = totalProCart;
    }

}
