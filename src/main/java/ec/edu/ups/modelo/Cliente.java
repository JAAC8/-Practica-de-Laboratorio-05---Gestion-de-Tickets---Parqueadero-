/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Cliente {
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Vehiculo> vehiculos;
    public Cliente() {
         vehiculos = new ArrayList<>();
    }

    public Cliente(String cedula, String nombre, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        vehiculos = new ArrayList<>();
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setVehiculos(Vehiculo veiculo){
        this.vehiculos.add(veiculo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }
     public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
     }
        public void actualizarVehiculo(Vehiculo  vehiculo) {
        for (int i = 0; i <vehiculos.size(); i++) {
            Vehiculo v =vehiculos.get(i);
            if(v.getPlaca().equals(vehiculo.getPlaca())){
                vehiculos.set(i, vehiculo);
                break;
            }
        }
    }
            public void eliminarVehiculo(Vehiculo vehiculo) {
        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo t = it.next();
            if (t.getPlaca().equals(vehiculo.getPlaca()) ) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
}
