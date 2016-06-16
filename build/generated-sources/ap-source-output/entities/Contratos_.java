package entities;

import entities.Empresas;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-16T10:03:02")
@StaticMetamodel(Contratos.class)
public class Contratos_ { 

    public static volatile SingularAttribute<Contratos, Integer> idCont;
    public static volatile SingularAttribute<Contratos, String> pagoCont;
    public static volatile SingularAttribute<Contratos, String> emailCont;
    public static volatile SingularAttribute<Contratos, String> conceptoCont;
    public static volatile SingularAttribute<Contratos, Integer> dirCont;
    public static volatile SingularAttribute<Contratos, String> fechaIniCon;
    public static volatile SingularAttribute<Contratos, String> nomCont;
    public static volatile SingularAttribute<Contratos, Integer> numCont;
    public static volatile SingularAttribute<Contratos, String> fechaFinCont;
    public static volatile SingularAttribute<Contratos, Integer> telCelCont;
    public static volatile SingularAttribute<Contratos, Empresas> idClem;

}