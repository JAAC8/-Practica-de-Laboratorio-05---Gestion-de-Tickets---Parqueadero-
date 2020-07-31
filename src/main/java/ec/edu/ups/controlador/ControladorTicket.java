package ec.edu.ups.controlador;



import ec.edu.ups.idao.ITicketDAO;
import ec.edu.ups.modelo.Ticket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControladorTicket {
     private ControladorVehiculo controladorVehiculo;
    private ITicketDAO ticketDAO;
    private Ticket ticket; 
    public ControladorTicket(ITicketDAO ticketDAO, ControladorVehiculo controladorVehiculo){
        this.ticketDAO = ticketDAO;
	this.controladorVehiculo = controladorVehiculo;   
    }
    public void crearTicket(Ticket ticket){
      
        ticketDAO.create(ticket); 
    }
public Ticket buscarTicketPorCodigo(int codigo){
    List<Ticket> ticket=ticketDAO.findAll();
    System.out.println(ticket.size());
    for (Ticket ticket1 : ticket) {
        if(ticket1.getNumeroT()==codigo){
            return ticket1;
        }
    }
    return null;
}
public double precio(Ticket ticket){
    
    LocalDateTime tiempo = LocalDateTime.now();
    
    Duration diff= Duration.between(ticket.getFechaIngreso(), tiempo);
    long diffmin=diff.toMinutes();
    diffmin /= 10;
    double total=0.25 * diffmin;
    return total;
}
public void verTicketsVehiculo(DefaultTableModel tabla){
    List<Ticket> tickets;
        tickets = ticketDAO.findAll();
        tabla.setRowCount(0);
	for(int i = 0; i < tickets.size(); i++){
	    tabla.addRow(new Object[]{
		tickets.get(i).getNumeroT(),
                tickets.get(i).getFechaIngreso(),
	    });
	}
     
   
}



}
