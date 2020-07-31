package ec.edu.ups.dao;

import ec.edu.ups.idao.IClienteDAO;
import ec.edu.ups.modelo.Cliente;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ClienteDAO implements IClienteDAO {

     private List<Cliente> listaClientes;

    public ClienteDAO() {
        listaClientes = new ArrayList<>();
    }

    @Override
    public void create(Cliente cliente) {
        listaClientes.add(cliente);
    }

    @Override
    public Cliente read(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void update(Cliente cliente) {
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente c = listaClientes.get(i);
            if (c.getCedula().equals(cliente.getCedula())) {
                listaClientes.set(i, cliente);
                break;
            }

        }
    }

    @Override
    public void delete(Cliente cliente) {
        Iterator<Cliente> it = listaClientes.iterator();
        while (it.hasNext()) {
            Cliente c = it.next();
            if (c.getCedula().equals(cliente.getCedula())) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Cliente> findAll() {
        return listaClientes;
    }

    @Override
    public Cliente login(String cedula) {
        for (Cliente cliente : findAll()) {
            if(cliente.getCedula().equals(cedula)){
                return cliente;
            }
        }
        return null;
    }
}

