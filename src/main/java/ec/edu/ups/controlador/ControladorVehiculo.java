/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;


import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.*;
import ec.edu.ups.controlador.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import ec.edu.ups.idao.IVehiculoDAO;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class ControladorVehiculo {

    private Vehiculo vehiculo;
    private IVehiculoDAO vehiculoDAO;
    private ControladorCliente controladorCliente;
    private ControladorTicket controladorTicket;

    private int numeroVehiculos = 0;
    private Ticket ticket;

    //Objetos DAO
    public ControladorVehiculo(IVehiculoDAO vehiculoDAO, ControladorCliente controladorCliente, ControladorTicket controladorTicket) {
        this.controladorTicket=controladorTicket;
        this.vehiculoDAO = vehiculoDAO;
        this.controladorCliente = controladorCliente;
        
        
    }

    public void registrar(String placa, String marca, String modelo,String cedula) {

       vehiculo = new Vehiculo(placa, marca, modelo, null);
	vehiculo.setPropietario(controladorCliente.verCliente(cedula));
        vehiculoDAO.create(vehiculo);
    }
     public void actualizar(String placa, String marca, String modelo,String cedula){
	vehiculo = new Vehiculo(placa, marca, modelo,null);
	vehiculo.setPropietario(controladorCliente.verCliente(cedula));
        vehiculoDAO.update(vehiculo);
    }
    
    public void eliminar(String placa, String marca, String modelo){
        vehiculo = new Vehiculo(placa, marca, modelo,null);
        vehiculoDAO.delete(vehiculo);
    }

    public Vehiculo verVehiculo(String placa) {
        vehiculo = vehiculoDAO.read(placa);
        return vehiculo;
    }

    public List<Vehiculo> listar() {
        return vehiculoDAO.findAll();
    }

    public void verVehiculos(DefaultTableModel tabla) {
        List<Vehiculo> vehiculos;
        vehiculos = vehiculoDAO.findAll();
        tabla.setRowCount(0);
        for (int i = 0; i < vehiculos.size(); i++) {
            tabla.addRow(new Object[]{
                vehiculos.get(i).getPlaca(),
                vehiculos.get(i).getMarca(),
                vehiculos.get(i).getModelo(),
                vehiculos.get(i).getTickete().getNumeroT()
            });
        }
    }

      public Vehiculo BuscarVehiculoPorPlaca (String placa){
       
        List <Vehiculo> listaVehiculo= vehiculoDAO.findAll();
         
        for (Vehiculo vehiculo1 : listaVehiculo) {
            if ( vehiculo1.getPlaca().equalsIgnoreCase(placa)){
                numeroVehiculos++;
                ticket= new Ticket(numeroVehiculos);
         
                LocalDateTime tiempo = LocalDateTime.now();
                ticket.setFechaIngreso(tiempo);
           
               
                
                controladorTicket.crearTicket(ticket);
               
                
                vehiculo1.setTickete(ticket);
                System.out.println(ticket);
                vehiculoDAO.update(vehiculo1);
                return vehiculo1;
            }
        }
        return null;
    }
}
