/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbeans;

import com.entities.ProductType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ngocd
 */
@Local
public interface ProductTypeFacadeLocal {

    void create(ProductType productType);

    void edit(ProductType productType);

    void remove(ProductType productType);

    ProductType find(Object id);

    List<ProductType> findAll();

    List<ProductType> findRange(int[] range);

    int count();
    
}
