package ec.edu.ups.idao;

import ec.edu.ups.modelo.*;
import java.util.List;

public interface ITicketDAO {
 public void create(Ticket ticket);

    public Ticket read(String cedula);

    public void update(Ticket ticket);

    public void delete(Ticket ticket);

    public List<Ticket> findAll();   

}
