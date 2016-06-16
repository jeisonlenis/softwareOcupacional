/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.AntecedentesOcupacionales;
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
public class AntecedentesOcupacionalesFacade extends AbstractFacade<AntecedentesOcupacionales> {
    @PersistenceContext(unitName = "softwareocupacionalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AntecedentesOcupacionalesFacade() {
        super(AntecedentesOcupacionales.class);
    }
    public List<AntecedentesOcupacionales> findByEmo(Emo selected) {
        Query q = getEntityManager().createNamedQuery("AntecedentesOcupacionales.findByIdEmo");
        q.setParameter("idEmo", selected);
        return q.getResultList();
    }
}