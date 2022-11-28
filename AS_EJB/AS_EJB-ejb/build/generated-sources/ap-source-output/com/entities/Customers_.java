package com.entities;

import com.entities.Order1;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-28T20:51:23")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, String> password;
    public static volatile SingularAttribute<Customers, String> firstname;
    public static volatile SingularAttribute<Customers, String> address;
    public static volatile CollectionAttribute<Customers, Order1> order1Collection;
    public static volatile SingularAttribute<Customers, String> phone;
    public static volatile SingularAttribute<Customers, Boolean> type;
    public static volatile SingularAttribute<Customers, String> username;

}