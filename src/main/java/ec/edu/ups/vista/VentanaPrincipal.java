package ec.edu.ups.vista;

import javax.swing.JOptionPane;
import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorTicket;
import ec.edu.ups.controlador.ControladorVehiculo;
import ec.edu.ups.dao.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JMenuItem;

public class VentanaPrincipal extends javax.swing.JFrame {

    Calendar calendario;
    //ventanas
    private VentanaRegistrarCliente ventanaRegistrarCliente;
    private VentanaRegistrarVehiculo ventanaRegistrarVehiculo;

    private VentanaImprimirTicket ventanaimprimirTicket;
    private VentanaVehiculos ventanaVehiculos;
    private VentanaIngresarVehiculo ventanaIngresarVehiculo;
//controladores
    private ControladorCliente controladorCliente;
    private ControladorVehiculo controladorVehiculo;
    private ControladorTicket controladorTicket;
//dao
    private ClienteDAO clienteDAO;
    private VehiculoDAO vehiculoDAO;
    private TicketDAO ticketDAO;
    //internacionalizacion
    private Locale localizacion;
    private ResourceBundle mensajes;

    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);

        //instancia DAOS
        clienteDAO = new ClienteDAO();
        vehiculoDAO = new VehiculoDAO();
        ticketDAO = new TicketDAO();
        //instancia controloadores
        controladorCliente = new ControladorCliente(clienteDAO);
        controladorTicket = new ControladorTicket(ticketDAO, controladorVehiculo);
        controladorVehiculo = new ControladorVehiculo(vehiculoDAO, controladorCliente, controladorTicket);

        //instancia las vistas
        ventanaRegistrarVehiculo = new VentanaRegistrarVehiculo(controladorCliente, controladorVehiculo);

        ventanaRegistrarCliente = new VentanaRegistrarCliente(controladorCliente);
        ventanaRegistrarVehiculo = new VentanaRegistrarVehiculo(controladorCliente, controladorVehiculo);
        ventanaimprimirTicket = new VentanaImprimirTicket(controladorTicket, this);
        ventanaVehiculos = new VentanaVehiculos();
        ventanaIngresarVehiculo = new VentanaIngresarVehiculo(controladorVehiculo, this);

        //añadir a destokpane
        ventanaRegistrarCliente.setVentanaPrincipal(this);

        ventanaRegistrarVehiculo.setVentanaPrincipal(this);
        calendario = new GregorianCalendar();

        localizacion = Locale.getDefault();
        mensajes = ResourceBundle.getBundle("ec.edu.ups.idiomas.mensajes", localizacion);
        cambiarIdioma();
    }

    public void cambiarIdioma() {
        ingresoMenu.setText(mensajes.getString("ingresoMenu"));
        menuItemSalida.setText(mensajes.getString("menuItemSalida"));
        ayudaMenu.setText(mensajes.getString("ayudaMenu"));
        registrarMenuItem.setText(mensajes.getString("registrarMenuItem"));
        menuItemIngresoVehiculo.setText(mensajes.getString("menuItemIngresoVehiculo"));
        menuItemSalirI.setText(mensajes.getString("menuItemSalirI"));
        menuItemValidarTicket.setText(mensajes.getString("menuItemValidarTicket"));
        menuItemRegresarSalida.setText(mensajes.getString("menuItemRegresarSalida"));
        menuItemEpañol.setText(mensajes.getString("menuItemEpañol"));
        menuItemIngles.setText(mensajes.getString("menuItemIngles"));
        registrarVehiculoItem.setText(mensajes.getString("botonRegistrarVehiculo"));

        ventanaRegistrarCliente.cambiarIdioma(localizacion, mensajes);
        ventanaRegistrarVehiculo.cambiarIdioma(localizacion, mensajes);
        ventanaIngresarVehiculo.cambiarIdioma(localizacion, mensajes);
        ventanaimprimirTicket.cambiarIdioma(localizacion, mensajes);

//        
    }

    public JMenuItem getRegistrarMenuItem() {
        return registrarMenuItem;
    }

    public JMenuItem getRegistrarVehiculoItem() {
        return registrarVehiculoItem;
    }

    public VentanaRegistrarVehiculo getVentanaRegistrarVehiculo() {
        return ventanaRegistrarVehiculo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        ingresoMenu = new javax.swing.JMenu();
        registrarMenuItem = new javax.swing.JMenuItem();
        registrarVehiculoItem = new javax.swing.JMenuItem();
        menuItemIngresoVehiculo = new javax.swing.JMenuItem();
        menuItemSalirI = new javax.swing.JMenuItem();
        menuItemSalida = new javax.swing.JMenu();
        menuItemValidarTicket = new javax.swing.JMenuItem();
        menuItemRegresarSalida = new javax.swing.JMenuItem();
        ayudaMenu = new javax.swing.JMenu();
        menuItemEpañol = new javax.swing.JMenuItem();
        menuItemIngles = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        desktopPane.setBackground(new java.awt.Color(0, 0, 255));
        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        ingresoMenu.setMnemonic('f');
        ingresoMenu.setText("Ingreso");

        registrarMenuItem.setMnemonic('o');
        registrarMenuItem.setText("Registarse");
        registrarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarMenuItemActionPerformed(evt);
            }
        });
        ingresoMenu.add(registrarMenuItem);

        registrarVehiculoItem.setText("Registar Vehiculo");
        registrarVehiculoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarVehiculoItemActionPerformed(evt);
            }
        });
        ingresoMenu.add(registrarVehiculoItem);

        menuItemIngresoVehiculo.setText("Ingresar Vehiculo");
        menuItemIngresoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIngresoVehiculoActionPerformed(evt);
            }
        });
        ingresoMenu.add(menuItemIngresoVehiculo);

        menuItemSalirI.setMnemonic('x');
        menuItemSalirI.setText("Salir");
        menuItemSalirI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirIActionPerformed(evt);
            }
        });
        ingresoMenu.add(menuItemSalirI);

        menuBar.add(ingresoMenu);

        menuItemSalida.setMnemonic('e');
        menuItemSalida.setText("Salida");

        menuItemValidarTicket.setMnemonic('t');
        menuItemValidarTicket.setText("Ingrese su ticket");
        menuItemValidarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemValidarTicketActionPerformed(evt);
            }
        });
        menuItemSalida.add(menuItemValidarTicket);

        menuItemRegresarSalida.setMnemonic('y');
        menuItemRegresarSalida.setText("Salir");
        menuItemRegresarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRegresarSalidaActionPerformed(evt);
            }
        });
        menuItemSalida.add(menuItemRegresarSalida);

        menuBar.add(menuItemSalida);

        ayudaMenu.setMnemonic('h');
        ayudaMenu.setText("Ayuda");
        ayudaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaMenuActionPerformed(evt);
            }
        });

        menuItemEpañol.setMnemonic('c');
        menuItemEpañol.setText("Español");
        menuItemEpañol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEpañolActionPerformed(evt);
            }
        });
        ayudaMenu.add(menuItemEpañol);

        menuItemIngles.setText("Ingles");
        menuItemIngles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInglesActionPerformed(evt);
            }
        });
        ayudaMenu.add(menuItemIngles);

        menuBar.add(ayudaMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSalirIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirIActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirIActionPerformed

    private void ayudaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaMenuActionPerformed

    }//GEN-LAST:event_ayudaMenuActionPerformed

    private void menuItemRegresarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRegresarSalidaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemRegresarSalidaActionPerformed

    private void registrarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarMenuItemActionPerformed
        desktopPane.add(ventanaRegistrarCliente);
        ventanaRegistrarCliente.setVisible(true);

    }//GEN-LAST:event_registrarMenuItemActionPerformed

    private void registrarVehiculoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarVehiculoItemActionPerformed
        desktopPane.add(ventanaRegistrarVehiculo);
        ventanaRegistrarVehiculo.setVisible(true);

    }//GEN-LAST:event_registrarVehiculoItemActionPerformed

    private void menuItemValidarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemValidarTicketActionPerformed
        desktopPane.add(ventanaimprimirTicket);
        ventanaimprimirTicket.setVisible(true);
    }//GEN-LAST:event_menuItemValidarTicketActionPerformed

    private void menuItemIngresoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIngresoVehiculoActionPerformed
        desktopPane.add(ventanaIngresarVehiculo);
        ventanaIngresarVehiculo.setVisible(true);


    }//GEN-LAST:event_menuItemIngresoVehiculoActionPerformed

    private void menuItemInglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInglesActionPerformed
        localizacion = new Locale("en", "UK");
        mensajes = ResourceBundle.getBundle("ec.edu.ups.idiomas.mensajes", localizacion);
        cambiarIdioma();
    }//GEN-LAST:event_menuItemInglesActionPerformed

    private void menuItemEpañolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEpañolActionPerformed

        localizacion = new Locale("es", "EC");
        mensajes = ResourceBundle.getBundle("ec.edu.ups.idiomas.mensajes", localizacion);
        cambiarIdioma();
    }//GEN-LAST:event_menuItemEpañolActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ayudaMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu ingresoMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemEpañol;
    private javax.swing.JMenuItem menuItemIngles;
    private javax.swing.JMenuItem menuItemIngresoVehiculo;
    private javax.swing.JMenuItem menuItemRegresarSalida;
    private javax.swing.JMenu menuItemSalida;
    private javax.swing.JMenuItem menuItemSalirI;
    private javax.swing.JMenuItem menuItemValidarTicket;
    private javax.swing.JMenuItem registrarMenuItem;
    private javax.swing.JMenuItem registrarVehiculoItem;
    // End of variables declaration//GEN-END:variables

}
