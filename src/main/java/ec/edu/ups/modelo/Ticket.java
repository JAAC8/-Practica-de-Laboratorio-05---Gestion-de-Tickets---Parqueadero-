/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author user
 */
public class Ticket {
    private int numeroT;
    private LocalDateTime FechaIngreso;
    private LocalDateTime FechaSalida;
    private Vehiculo vehiculo;

    public Ticket(int numeroT) {
        this.numeroT = numeroT;
        
    }
    
    
    
    public LocalDateTime getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(LocalDateTime FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    
    
 

    
    
    public int getNumeroT() {
        return numeroT;
    }

    public void setNumeroT(int numeroT) {
        this.numeroT = numeroT;
    }

    @Override
    public String toString() {
        return "Ticket{" + "numeroT=" + numeroT + '}';
    }

 

    
}

