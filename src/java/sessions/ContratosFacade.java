/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Contratos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author D4MN4710N
 */
@Stateless
public class ContratosFacade extends AbstractFacade<Contratos> {
    @PersistenceContext(unitName = "softwareocupacionalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratosFacade() {
        super(Contratos.class);
    }
    
}
