package com.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-11-30T02:38:29")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Integer> amount;
    public static volatile SingularAttribute<OrderDetails, String> address;
    public static volatile SingularAttribute<OrderDetails, Integer> productID;
    public static volatile SingularAttribute<OrderDetails, Integer> orderID;
    public static volatile SingularAttribute<OrderDetails, String> phone;
    public static volatile SingularAttribute<OrderDetails, Integer> totalPrice;

}