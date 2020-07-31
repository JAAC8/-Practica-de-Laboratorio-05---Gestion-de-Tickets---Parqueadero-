package ec.edu.ups.vista;
import ec.edu.ups.controlador.*;
import ec.edu.ups.dao.TicketDAO;
import ec.edu.ups.dao.VehiculoDAO;
import ec.edu.ups.modelo.Vehiculo;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class VentanaIngresarVehiculo extends javax.swing.JInternalFrame {
    
    private ControladorVehiculo controladorVehiculo;
    
    
    private VehiculoDAO vehiculoDAO;
    
    private TicketDAO ticketDAO;
    private String vehiculonoencontrado;
    private String vehiculoIngresado;
     private ControladorTicket controladorTicket;
     
    public VentanaIngresarVehiculo(ControladorVehiculo controladorVehiculo, VentanaPrincipal ventanaPrincipal) {
        initComponents();
       
      this.controladorVehiculo=controladorVehiculo;
    }

 public void cambiarIdioma(Locale localizacion, ResourceBundle mensajes){
     jLabel1.setText(mensajes.getString("menuItemIngresePlacaDeSuVehiculo"));
     jButton1.setText(mensajes.getString("botonIngresar"));
     
     vehiculonoencontrado=mensajes.getString("panelvehiculonoencontrado");
     vehiculoIngresado=mensajes.getString("panelvehiculoIngresado");
     
      this.setTitle(mensajes.getString("tituloIngresarVehiculo"));
     
     
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Ingrese la placa de su vehiculo");

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String placa=jTextField1.getText();
       
     
        
        
        Vehiculo v= controladorVehiculo.BuscarVehiculoPorPlaca(placa);
        if(v==null){
            JOptionPane.showMessageDialog(this, vehiculonoencontrado);
            jTextField1.setText("");
        }else{
            jTextField1.setText("");
            
            JOptionPane.showMessageDialog(this, vehiculoIngresado+v.getTickete().getNumeroT());
        }
        
        jTextField1.setText("");
       
        dispose();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
