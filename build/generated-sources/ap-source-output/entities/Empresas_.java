package entities;

import entities.Contratos;
import entities.Pacientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-16T10:03:02")
@StaticMetamodel(Empresas.class)
public class Empresas_ { 

    public static volatile ListAttribute<Empresas, Pacientes> pacientesList;
    public static volatile SingularAttribute<Empresas, String> nitClem;
    public static volatile SingularAttribute<Empresas, String> nomClem;
    public static volatile SingularAttribute<Empresas, Date> fecCreClem;
    public static volatile SingularAttribute<Empresas, Integer> idClem;
    public static volatile ListAttribute<Empresas, Contratos> contratosList;

}