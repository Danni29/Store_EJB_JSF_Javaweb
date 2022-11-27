package com.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-27T18:18:59")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Integer> amount;
    public static volatile SingularAttribute<OrderDetails, String> address;
    public static volatile SingularAttribute<OrderDetails, Integer> productID;
    public static volatile SingularAttribute<OrderDetails, Integer> orderID;
    public static volatile SingularAttribute<OrderDetails, String> phone;
    public static volatile SingularAttribute<OrderDetails, Integer> totalPrice;

}