/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Vehiculo;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import ec.edu.ups.idao.IVehiculoDAO;

/**
 *
 * @author user
 */
public class VehiculoDAO implements IVehiculoDAO {

    private List<Vehiculo> listaVehiculos;

    public VehiculoDAO() {
        listaVehiculos = new ArrayList<>();
    }

    @Override
    public void create(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }

    @Override
    public Vehiculo read(String placa) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    @Override
    public void update(Vehiculo vehiculo) {
        for (int i = 0; i < listaVehiculos.size(); i++) {
            Vehiculo v = listaVehiculos.get(i);
            if (v.getPlaca().equals(vehiculo.getPlaca())) {
                listaVehiculos.set(i, vehiculo);
                break;
            }

        }
    }

    @Override
    public void delete(Vehiculo vehiculo) {
        Iterator<Vehiculo> it = listaVehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo c = it.next();
            if (c.getPlaca().equals(vehiculo.getPlaca())) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Vehiculo> findAll() {
        return listaVehiculos;
    }

}
