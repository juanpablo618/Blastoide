package com.blastoide.jsf;

import com.blastoide.jsf.UserRoles;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-12T12:57:05")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, UserRoles> userRoles;
    public static volatile SingularAttribute<Users, Integer> phoneNumber;
    public static volatile SingularAttribute<Users, Boolean> emailConfirmed;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, Integer> email;
    public static volatile SingularAttribute<Users, String> passwordHash;
    public static volatile SingularAttribute<Users, Integer> securityStamp;
    public static volatile SingularAttribute<Users, Boolean> phoneNumberConfirmed;
    public static volatile SingularAttribute<Users, String> username;

}