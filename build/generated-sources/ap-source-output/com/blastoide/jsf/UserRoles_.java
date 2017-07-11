package com.blastoide.jsf;

import com.blastoide.jsf.UserRoles;
import com.blastoide.jsf.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-11T16:11:42")
@StaticMetamodel(UserRoles.class)
public class UserRoles_ { 

    public static volatile CollectionAttribute<UserRoles, UserRoles> userRolesCollection;
    public static volatile SingularAttribute<UserRoles, UserRoles> roleId;
    public static volatile SingularAttribute<UserRoles, Integer> userId;
    public static volatile SingularAttribute<UserRoles, Users> users;

}