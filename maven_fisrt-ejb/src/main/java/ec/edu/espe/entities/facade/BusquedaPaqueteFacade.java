/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.entities.facade;

import ec.edu.espe.entities.BusquedaPaquete;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author homer
 */
@Stateless
public class BusquedaPaqueteFacade extends AbstractFacade<BusquedaPaquete> implements BusquedaPaqueteFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe_maven_fisrt-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BusquedaPaqueteFacade() {
        super(BusquedaPaquete.class);
    }
    
}
