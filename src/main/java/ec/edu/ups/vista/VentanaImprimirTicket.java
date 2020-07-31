/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTicket;
import ec.edu.ups.controlador.ControladorVehiculo;
import ec.edu.ups.modelo.Ticket;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaImprimirTicket extends javax.swing.JInternalFrame {

    private ControladorVehiculo controladorVehiculo;
    private ControladorTicket controladorTicket;
    DefaultTableModel modelo;
    private String valorPagar;
    private String textoFracciones;
    private String ticketnoEncontrado;

    public VentanaImprimirTicket(ControladorTicket controladorTicket, VentanaPrincipal Ventanaprincipal) {
        initComponents();
        this.controladorTicket = controladorTicket;
        this.controladorTicket.verTicketsVehiculo((DefaultTableModel) jTable1.getModel());

    }

    public void cambiarIdioma(Locale localizacion, ResourceBundle mensajes) {
        jLabel1.setText(mensajes.getString("menuItemIngresePlacaDeSuVehiculo"));
        jToggleButton1.setText(mensajes.getString("botonAceptar"));

        jTable1.getColumnModel().getColumn(0).setHeaderValue(mensajes.getString("tablaTicket"));
        jTable1.getColumnModel().getColumn(1).setHeaderValue(mensajes.getString("tablaIngreso"));

        valorPagar = mensajes.getString("valorPagar");
        textoFracciones = mensajes.getString("textoFracciones");
        ticketnoEncontrado = mensajes.getString("ticketnoEncontrado");
        this.setTitle(mensajes.getString("tituloImprimirTicket"));

    }

    public void actualizar() {
        this.controladorTicket.verTicketsVehiculo((DefaultTableModel) jTable1.getModel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setText("Ingrese codigo de ticket");

        jToggleButton1.setText("Aceptar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Ticket", "ingreso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        Ticket ticket = controladorTicket.buscarTicketPorCodigo(Integer.parseInt(jTextField1.getText()));
        System.out.println(ticket);
        actualizar();
        if (ticket != null) {
            double total = controladorTicket.precio(ticket);
            JOptionPane.showMessageDialog(this, valorPagar + total);
            double fracciones = total / 0.25;
            JOptionPane.showMessageDialog(this, textoFracciones + total);
            jTextField1.setText("");

        } else {
            JOptionPane.showMessageDialog(this, ticketnoEncontrado);
            jTextField1.setText("");
        }


    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
