/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Emo;
import entities.Empresas;
import entities.Pacientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author D4MN4710N
 */
@Stateless
public class PacientesFacade extends AbstractFacade<Pacientes> {
    @PersistenceContext(unitName = "softwareocupacionalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacientesFacade() {
        super(Pacientes.class);
    }
public List<Pacientes> findByEmpresa(Empresas selected) {
        Query q = getEntityManager().createNamedQuery("Pacientes.findByIdClem");
        q.setParameter("idClem", selected);
        return q.getResultList();
    }    
}
