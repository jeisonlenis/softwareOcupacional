package entities;

import entities.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-16T10:03:02")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> numeroDoc;
    public static volatile SingularAttribute<Usuarios, Integer> idUsuario;
    public static volatile SingularAttribute<Usuarios, Boolean> estado;
    public static volatile SingularAttribute<Usuarios, String> ape;
    public static volatile SingularAttribute<Usuarios, String> tel;
    public static volatile SingularAttribute<Usuarios, String> cel;
    public static volatile ListAttribute<Usuarios, Rol> rolList;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile SingularAttribute<Usuarios, String> nom;
    public static volatile SingularAttribute<Usuarios, String> correo;

}