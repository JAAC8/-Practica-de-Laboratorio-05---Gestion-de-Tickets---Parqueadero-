package ec.edu.ups.idao;

import java.util.List;
import ec.edu.ups.modelo.Cliente;

public interface IClienteDAO {

    public void create(Cliente cliente);

    public Cliente read(String cedula);

    public void update(Cliente cliente);

    public void delete(Cliente cliente);

    public List<Cliente> findAll();

    public Cliente login(String cedula);
}
