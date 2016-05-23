/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.entities.facade;

import ec.edu.espe.entities.BusquedaPaquete;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homer
 */
@Local
public interface BusquedaPaqueteFacadeLocal {

    void create(BusquedaPaquete busquedaPaquete);

    void edit(BusquedaPaquete busquedaPaquete);

    void remove(BusquedaPaquete busquedaPaquete);

    BusquedaPaquete find(Object id);

    List<BusquedaPaquete> findAll();

    List<BusquedaPaquete> findRange(int[] range);

    int count();
    
}
