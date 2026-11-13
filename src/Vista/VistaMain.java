package Vista;

import Modelo.Asiento;
import Modelo.Colectivo;
import Modelo.Pasaje;
import Modelo.Pasajero;
import Modelo.RutaViaje;
import Persistencia.AsientoData;
import Persistencia.ColectivoData;
import Persistencia.PasajeData;
import Persistencia.PasajeroData;
import Persistencia.RutaViajeData;
import static Vista.VistaPasaje2.vistaVenta;
import javax.swing.JDesktopPane;
import javax.swing.*;
import java.awt.*;

public class VistaMain extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaMain.class.getName());

    public static PasajeroData pasajeroData = new PasajeroData();
    public static ColectivoData colectivoData = new ColectivoData();
    public static AsientoData asientoData = new AsientoData();
    public static RutaViajeData viajeData = new RutaViajeData();
    public static PasajeData pasajeData = new PasajeData();

    public static VistaMain vistaMain;
    public static VistaPasajero vistaPasajero = new VistaPasajero();
    public static VistaPasajeroModificar vistaPasajeroM = new VistaPasajeroModificar();
    public static VistaColectivo vistaColectivo = new VistaColectivo();
    public static VistaColectivoModificar vistaColectivoM = new VistaColectivoModificar();
    public static VistaAsiento vistaAsiento = new VistaAsiento();
    public static VistaAsientoModificar vistaAsientoM = new VistaAsientoModificar();
    public static VistaViaje vistaViaje = new VistaViaje();
    public static VistaViajeModificar vistaViajeM = new VistaViajeModificar();
    public static VistaPasaje vistaPasaje = new VistaPasaje();
    public static VistaPasajeModificar vistaPasajeM = new VistaPasajeModificar();
    public static informes1 informes1 = new informes1();
    public static informes2 informes2 = new informes2();
    public static informes3 informes3 = new informes3();
    public static informes4 informes4 = new informes4();
    public static informes5 informes5 = new informes5();
    public static informes6 informes6 = new informes6();

    public static JDesktopPane desktopMain;

    public VistaMain() {
        initComponents();
        vistaMain = this;
        desktopMain = dtpEscritorio;
        desktopMain.add(vistaPasajero);
        desktopMain.add(vistaPasajeroM);
        desktopMain.add(vistaColectivo);
        desktopMain.add(vistaColectivoM);
        desktopMain.add(vistaAsiento);
        desktopMain.add(vistaAsientoM);
        desktopMain.add(vistaViaje);
        desktopMain.add(vistaViajeM);
        desktopMain.add(vistaPasaje);
        desktopMain.add(vistaPasajeM);
        desktopMain.add(vistaVenta);
        desktopMain.add(informes1);
        desktopMain.add(informes2);
        desktopMain.add(informes3);
        desktopMain.add(informes4);
        desktopMain.add(informes5);
        desktopMain.add(informes6);

        img();
        configurarListenersDeRedimensionamiento();
    }

    public void img() {
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/IMG/flechaflash.jpg"));

        // Obtenemos el ancho y alto actual del contenedor (dtpEscritorio) 
        // en lugar de usar valores fijos (594x470). Si recién inicia, usamos un tamaño por defecto.
        int ancho = dtpEscritorio.getWidth() > 0 ? dtpEscritorio.getWidth() : 594;
        int alto = dtpEscritorio.getHeight() > 0 ? dtpEscritorio.getHeight() : 470;

        // Escala la imagen con alta calidad (Image.SCALE_SMOOTH)
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(imagenEscalada));

        // Aseguramos que el JLabel ocupe todo el JDesktopPane
        jLabel1.setBounds(0, 0, ancho, alto);
    }

    // NUEVO MÉTODO: Escucha cuando cambia el tamaño de la ventana/escritorio
    private void configurarListenersDeRedimensionamiento() {
        dtpEscritorio.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                img(); // Vuelve a escalar la imagen con las nuevas dimensiones
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        dtpEscritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        mnbNavegador = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mitSalir = new javax.swing.JMenuItem();
        mnuPasajero = new javax.swing.JMenu();
        mitPasajero = new javax.swing.JMenuItem();
        mnuColectivo = new javax.swing.JMenu();
        mitColectivo = new javax.swing.JMenuItem();
        mnuAsiento = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuRuta = new javax.swing.JMenu();
        mitRuta = new javax.swing.JMenuItem();
        mnuPasajes = new javax.swing.JMenu();
        mitPasajes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuLista1 = new javax.swing.JMenuItem();
        mnuLista2 = new javax.swing.JMenuItem();
        mnuLista3 = new javax.swing.JMenuItem();
        mnuLista4 = new javax.swing.JMenuItem();
        mnuLista5 = new javax.swing.JMenuItem();
        mnuLista6 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(56, 36));

        dtpEscritorio.setMaximumSize(new java.awt.Dimension(600, 600));
        dtpEscritorio.setMinimumSize(new java.awt.Dimension(600, 600));

        jLabel1.setAutoscrolls(true);

        dtpEscritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dtpEscritorioLayout = new javax.swing.GroupLayout(dtpEscritorio);
        dtpEscritorio.setLayout(dtpEscritorioLayout);
        dtpEscritorioLayout.setHorizontalGroup(
            dtpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dtpEscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );
        dtpEscritorioLayout.setVerticalGroup(
            dtpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtpEscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mnuArchivo.setText("Archivo");

        mitSalir.setText("Salir");
        mitSalir.addActionListener(this::mitSalirActionPerformed);
        mnuArchivo.add(mitSalir);

        mnbNavegador.add(mnuArchivo);

        mnuPasajero.setText("Pasajero");

        mitPasajero.setText("Pasajero");
        mitPasajero.addActionListener(this::mitPasajeroActionPerformed);
        mnuPasajero.add(mitPasajero);

        mnbNavegador.add(mnuPasajero);

        mnuColectivo.setText("Colectivo");

        mitColectivo.setText("Colectivo");
        mitColectivo.addActionListener(this::mitColectivoActionPerformed);
        mnuColectivo.add(mitColectivo);

        mnbNavegador.add(mnuColectivo);

        mnuAsiento.setText("Asiento");

        jMenuItem1.setText("Asiento");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        mnuAsiento.add(jMenuItem1);

        mnbNavegador.add(mnuAsiento);

        mnuRuta.setText("Ruta");

        mitRuta.setText("Ruta");
        mitRuta.addActionListener(this::mitRutaActionPerformed);
        mnuRuta.add(mitRuta);

        mnbNavegador.add(mnuRuta);

        mnuPasajes.setText("Pasajes");

        mitPasajes.setText("Pasajes");
        mitPasajes.addActionListener(this::mitPasajesActionPerformed);
        mnuPasajes.add(mitPasajes);

        mnbNavegador.add(mnuPasajes);

        jMenu2.setText("Informes");

        mnuLista1.setText("Listar Por Hora");
        mnuLista1.addActionListener(this::mnuLista1ActionPerformed);
        jMenu2.add(mnuLista1);

        mnuLista2.setText("Listar Pasajes x Pasajero");
        mnuLista2.addActionListener(this::mnuLista2ActionPerformed);
        jMenu2.add(mnuLista2);

        mnuLista3.setText("Lista de Choferes y Colectivos");
        mnuLista3.addActionListener(this::mnuLista3ActionPerformed);
        jMenu2.add(mnuLista3);

        mnuLista4.setText("Consulta Asientos disponibles");
        mnuLista4.addActionListener(this::mnuLista4ActionPerformed);
        jMenu2.add(mnuLista4);

        mnuLista5.setText("Lista Colectivos x Fecha");
        mnuLista5.addActionListener(this::mnuLista5ActionPerformed);
        jMenu2.add(mnuLista5);

        mnuLista6.setText("Lista Asientos x ruta");
        mnuLista6.addActionListener(this::mnuLista6ActionPerformed);
        jMenu2.add(mnuLista6);

        mnbNavegador.add(jMenu2);

        setJMenuBar(mnbNavegador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dtpEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dtpEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSalirActionPerformed
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir?", "Confirmación de salida", javax.swing.JOptionPane.YES_NO_OPTION);

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_mitSalirActionPerformed

    private void mitPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPasajeroActionPerformed
        vistaPasajero.setLocation(mnuPasajero.getX(), 0);
        vistaPasajero.show();
        desktopMain.moveToFront(vistaPasajero);
    }//GEN-LAST:event_mitPasajeroActionPerformed

    private void mitPasajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPasajesActionPerformed
        vistaPasaje.setLocation(mnuPasajes.getX(), 0);
        vistaPasaje.show();
        desktopMain.moveToFront(vistaPasaje);
    }//GEN-LAST:event_mitPasajesActionPerformed

    private void mitColectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitColectivoActionPerformed
        vistaColectivo.setLocation(mnuColectivo.getX(), 0);
        vistaColectivo.show();
        desktopMain.moveToFront(vistaColectivo);
    }//GEN-LAST:event_mitColectivoActionPerformed

    private void mitRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRutaActionPerformed
        vistaViaje.setLocation(mnuRuta.getX(), 0);
        vistaViaje.show();
        desktopMain.moveToFront(vistaViaje);
    }//GEN-LAST:event_mitRutaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        vistaAsiento.setLocation(mnuAsiento.getX(), 0);
        vistaAsiento.show();
        desktopMain.moveToFront(vistaAsiento);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnuLista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLista1ActionPerformed
        informes1.setLocation(mnuLista1.getX(), 0);
        informes1.show();
        desktopMain.moveToFront(informes1);
    }//GEN-LAST:event_mnuLista1ActionPerformed

    private void mnuLista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLista2ActionPerformed
        informes2.setLocation(mnuLista2.getX(), 0);
        informes2.show();
        desktopMain.moveToFront(informes2);

    }//GEN-LAST:event_mnuLista2ActionPerformed

    private void mnuLista3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLista3ActionPerformed
        informes3.setLocation(mnuLista3.getX(), 0);
        informes3.show();
        desktopMain.moveToFront(informes3);
    }//GEN-LAST:event_mnuLista3ActionPerformed

    private void mnuLista4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLista4ActionPerformed
        informes4.setLocation(mnuLista4.getX(), 0);
        informes4.show();
        desktopMain.moveToFront(informes4);
    }//GEN-LAST:event_mnuLista4ActionPerformed

    private void mnuLista5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLista5ActionPerformed
        informes5.setLocation(mnuLista5.getX(), 0);
        informes5.show();
        desktopMain.moveToFront(informes5);
    }//GEN-LAST:event_mnuLista5ActionPerformed

    private void mnuLista6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLista6ActionPerformed
        informes6.setLocation(mnuLista6.getX(), 0);
        informes6.show();
        desktopMain.moveToFront(informes6);
    }//GEN-LAST:event_mnuLista6ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VistaMain().setVisible(true));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dtpEscritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mitColectivo;
    private javax.swing.JMenuItem mitPasajero;
    private javax.swing.JMenuItem mitPasajes;
    private javax.swing.JMenuItem mitRuta;
    private javax.swing.JMenuItem mitSalir;
    private javax.swing.JMenuBar mnbNavegador;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAsiento;
    private javax.swing.JMenu mnuColectivo;
    private javax.swing.JMenuItem mnuLista1;
    private javax.swing.JMenuItem mnuLista2;
    private javax.swing.JMenuItem mnuLista3;
    private javax.swing.JMenuItem mnuLista4;
    private javax.swing.JMenuItem mnuLista5;
    private javax.swing.JMenuItem mnuLista6;
    private javax.swing.JMenu mnuPasajero;
    private javax.swing.JMenu mnuPasajes;
    private javax.swing.JMenu mnuRuta;
    // End of variables declaration//GEN-END:variables
}
