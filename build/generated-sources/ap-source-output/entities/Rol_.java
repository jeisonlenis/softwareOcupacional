package entities;

import entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-16T10:03:02")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> nombreRol;
    public static volatile ListAttribute<Rol, Usuarios> usuariosList;
    public static volatile SingularAttribute<Rol, Integer> idRol;

}