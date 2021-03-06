package ec.edu.ups.controlador;

import ec.edu.ups.dao.*;
import ec.edu.ups.idao.IClienteDAO;
import ec.edu.ups.modelo.Vehiculo;
import ec.edu.ups.modelo.Cliente;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ControladorCliente {

    //modelo
    //modelo
    private Cliente cliente;

    //daos
    private IClienteDAO clienteDAO;

    public ControladorCliente(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;

    }

    public void registrar(String cedula, String nombre, String direccion, String telefono) {

        cliente = new Cliente(cedula, nombre, direccion, telefono);

        clienteDAO.create(cliente);

    }

    public void actualizar(String cedula, String nombre, String direccion, String telefono) {
        cliente = new Cliente(cedula, nombre, direccion, telefono);
        clienteDAO.update(cliente);
    }

    public void eliminar(String cedula, String nombre, String direccion, String telefono) {
        cliente = new Cliente(cedula, nombre, direccion, telefono);
        clienteDAO.delete(cliente);
    }

    public Cliente verCliente(String cedula) {
        cliente = clienteDAO.read(cedula);
        return cliente;
    }
      public List<Cliente> listarClientes(){
	return clienteDAO.findAll();
    }

    public boolean validarCliente(String cedula) {
        cliente = clienteDAO.login(cedula);
        if (cliente != null) {
            return true;
        } else {
            return false;
        }
    }
        public void verClientes(DefaultTableModel tabla){
        List<Cliente> clientes;
        clientes = clienteDAO.findAll();
        tabla.setRowCount(0);
	    for(int i = 0; i < clientes.size(); i++){
		tabla.addRow(new Object[]{
		    clientes.get(i).getCedula(),
		    clientes.get(i).getNombre(),
		    clientes.get(i).getDireccion(),
		    clientes.get(i).getTelefono()
		});
	    }
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        cliente.agregarVehiculo(vehiculo);
        clienteDAO.update(cliente);
    }

    public void actualizarVehiculo(Vehiculo vehiculo) {
        cliente.actualizarVehiculo(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        cliente.eliminarVehiculo(vehiculo);
    }
}
