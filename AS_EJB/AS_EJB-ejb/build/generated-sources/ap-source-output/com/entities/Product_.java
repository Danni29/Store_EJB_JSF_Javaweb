package com.entities;

import com.entities.ProductType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-29T01:58:46")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> amount;
    public static volatile SingularAttribute<Product, Integer> productID;
    public static volatile SingularAttribute<Product, Integer> price;
    public static volatile SingularAttribute<Product, ProductType> typeid;
    public static volatile SingularAttribute<Product, String> pic;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, String> productInfo;

}