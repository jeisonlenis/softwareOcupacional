package entities;

import entities.Emo;
import entities.Empresas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-16T10:03:02")
@StaticMetamodel(Pacientes.class)
public class Pacientes_ { 

    public static volatile SingularAttribute<Pacientes, Integer> idPaciente;
    public static volatile SingularAttribute<Pacientes, String> direccion;
    public static volatile SingularAttribute<Pacientes, String> afp;
    public static volatile SingularAttribute<Pacientes, String> ciudad;
    public static volatile SingularAttribute<Pacientes, String> tipoDoc;
    public static volatile SingularAttribute<Pacientes, String> apellidos;
    public static volatile SingularAttribute<Pacientes, Integer> telCel;
    public static volatile SingularAttribute<Pacientes, String> estCiv;
    public static volatile SingularAttribute<Pacientes, String> nivAca;
    public static volatile SingularAttribute<Pacientes, Empresas> idClem;
    public static volatile SingularAttribute<Pacientes, String> eps;
    public static volatile SingularAttribute<Pacientes, Integer> numDoc;
    public static volatile SingularAttribute<Pacientes, Character> genero;
    public static volatile SingularAttribute<Pacientes, String> nombres;
    public static volatile ListAttribute<Pacientes, Emo> emoList;
    public static volatile SingularAttribute<Pacientes, Integer> edad;
    public static volatile SingularAttribute<Pacientes, String> numHijos;
    public static volatile SingularAttribute<Pacientes, Date> fecNac;
    public static volatile SingularAttribute<Pacientes, String> arl;

}