/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Emo;
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
public class EmoFacade extends AbstractFacade<Emo> {
    @PersistenceContext(unitName = "softwareocupacionalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmoFacade() {
        super(Emo.class);
    }
    
    public List<Emo> findByPaciente(Pacientes selected) {
        Query q = getEntityManager().createNamedQuery("Emo.findByIdPaciente");
        q.setParameter("idPaciente", selected);
        return q.getResultList();
    }
}
