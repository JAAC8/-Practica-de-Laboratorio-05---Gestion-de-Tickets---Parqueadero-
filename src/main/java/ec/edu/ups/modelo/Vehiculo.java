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
public class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private Ticket tickete;
    private Cliente propietario;
    public Vehiculo() {
        
    }

    public Vehiculo(String placa, String marca, String modelo,Cliente propietario) {
	this.placa = placa;
	this.marca = marca;
	this.modelo = modelo;
	this.propietario = propietario;
    }
    
    public Cliente getPropietario() {
	return propietario;
    }

    public void setPropietario(Cliente propietario) {
	this.propietario = propietario;
    }

    public Ticket getTickete() {
        return tickete;
    }

    public void setTickete(Ticket tickete) {
        this.tickete = tickete;
    }
  
    
    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.placa);
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
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }

//    public void agregarTicket(Ticket ticket) {
//        ticketes.add(ticket);
//    }
//Actualiza el telefono ingresado en la lista telefonos
//
//    public void actualizarTicket(Ticket ticket) {
//        for (int i = 0; i < ticketes.size(); i++) {
//            Ticket t = ticketes.get(i);
//            if (t.getNumeroT() == ticket.getNumeroT()) {
//                ticketes.set(i, ticket);
//                break;
//            }
//        }
//    }
//
//    Elimina el telefono ingresado de la lista telefonos
//    public void eliminarTicket(Ticket ticket) {
//        Iterator<Ticket> it = ticketes.iterator();
//        while (it.hasNext()) {
//            Ticket t = it.next();
//            if (t.getNumeroT() == ticket.getNumeroT()) {
//                it.remove();
//                break;
//            }
//        }
//    }
//
//    Busca el Telefono correspondiente al codigo ingresado
//    public Ticket buscarTicket(int ticket) {
//        return ticketes.get(ticket);
//    }
//
//    debuelve la lista telefonos
//    public List<Ticket> listarTickets() {
//        return ticketes;
//    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + '}';
    }

}
