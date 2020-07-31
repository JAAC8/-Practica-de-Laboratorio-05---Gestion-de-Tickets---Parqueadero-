/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;
import ec.edu.ups.idao.ITicketDAO;
import ec.edu.ups.modelo.Ticket;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TicketDAO implements ITicketDAO{
private List<Ticket> listaTickets;
    //

public TicketDAO(){
    listaTickets=new ArrayList<>();
 
}
    @Override
    public void create(Ticket ticket) {

        listaTickets.add(ticket);
    }
    @Override
    public Ticket read(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Ticket ticket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Ticket ticket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ticket> findAll() {
       return listaTickets;
    }

    
}
