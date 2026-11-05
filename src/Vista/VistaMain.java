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
    public static VistaViaje vistaViaje = new VistaViaje();
    public static VistaViajeModificar vistaViajeM = new VistaViajeModificar();
    public static VistaPasajes vistaPasajes = new VistaPasajes();

    public static JDesktopPane desktopMain;

    public VistaMain() {
        initComponents();
        vistaMain = this;
        desktopMain = dtpEscritorio;
        desktopMain.add(vistaPasajero);
        desktopMain.add(vistaPasajeroM);
        desktopMain.add(vistaColectivo);
        desktopMain.add(vistaColectivoM);
        desktopMain.add(vistaViaje);
        desktopMain.add(vistaViajeM);
        desktopMain.add(vistaPasajes);
        img();
    }

    public void img() {
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/IMG/flechaflash.jpg"));
        int ancho = 594;
        int alto = 470;
        // Escala la imagen con alta calidad (Image.SCALE_SMOOTH)
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(imagenEscalada));
    }

    public void pasajero(String type, int id) {
        if (type.equals("INSERT")) {
            vistaPasajero.tableIndex = vistaPasajero.tableList.size();
            vistaPasajeroM.hide();
        }
        if (type.equals("REMOVE")) {
            for (Pasaje p : pasajeData.SQL("select * from pasajes where id_pasajero = " + id)) {
                pasajeData.remove(p.getId_pasaje());
            }
            if (vistaPasajeroM.pasajero != null && vistaPasajeroM.pasajero.getId_pasajero() == id && vistaPasajeroM.estate == 2) {
                vistaPasajeroM.hide();
            }
            pasajeroData.remove(id);
        }
        if (type.equals("MODIFY")) {
            int index = -1;
            for (Pasajero p : pasajeroData.getList()) {
                index++;
                if (p.getId_pasajero() == id) {
                    break;
                }
            }
            vistaPasajero.tableIndex = index;
            vistaPasajeroM.hide();
        }
        vistaPasajero.updateAll();
    }

    public void colectivo(String type, int id) {
        if (type.equals("INSERT")) {
            vistaColectivo.tableIndex = vistaColectivo.tableList.size();
            vistaColectivoM.hide();
        }
        if (type.equals("REMOVE")) {
            for (Pasaje p : pasajeData.SQL(
                    "select * from pasajes\n"
                    + "join rutas on rutas.id_ruta = pasajes.id_ruta\n"
                    + "join lugares on lugares.id_lugar = pasajes.id_lugar\n"
                    + "join colectivos c1 on c1.id_colectivo = rutas.id_colectivo\n"
                    + "join colectivos c2 on c2.id_colectivo = lugares.id_colectivo\n"
                    + "where c1.id_colectivo = " + id + " or c2.id_colectivo = " + id
            )) {
                pasajeData.remove(p.getId_pasaje());
            }

            for (Asiento a : asientoData.SQL(
                    "select * from lugares\n"
                    + "join colectivos on colectivos.id_colectivo = lugares.id_colectivo\n"
                    + "where colectivos.id_colectivo = " + id
            )) {
                asientoData.remove(a.getId_lugar());
            }

            for (RutaViaje r : viajeData.SQL(
                    "select * from rutas\n"
                    + "join colectivos on colectivos.id_colectivo = rutas.id_colectivo\n"
                    + "where colectivos.id_colectivo = " + id
            )) {
                ruta("REMOVE", r.getId_ruta());
            }

            if (vistaColectivoM.colectivo != null && vistaColectivoM.colectivo.getId_colectivo() == id && vistaColectivoM.estate == 2) {
                vistaColectivoM.hide();
            }
            colectivoData.remove(id);
        }
        if (type.equals("MODIFY")) {
            int index = -1;
            for (Colectivo c : colectivoData.getList()) {
                index++;
                if (c.getId_colectivo() == id) {
                    break;
                }
            }
            vistaColectivo.tableIndex = index;
            vistaColectivoM.hide();
        }
        vistaColectivo.updateAll();
    }

    public void ruta(String type, int id) {
        if (type.equals("INSERT")) {
            vistaViaje.tableIndex = vistaViaje.tableList.size();
            vistaViajeM.hide();
        }
        if (type.equals("REMOVE")) {
            for (Pasaje p : pasajeData.SQL("select * from pasajes where id_ruta = " + id)) {
                pasajeData.remove(p.getId_pasaje());
            }
            if (vistaViajeM.ruta != null && vistaViajeM.ruta.getId_ruta() == id && vistaViajeM.estate == 2) {
                vistaViajeM.hide();
            }
            viajeData.remove(id);
        }
        if (type.equals("MODIFY")) {
            int index = -1;
            for (RutaViaje v : viajeData.getList()) {
                index++;
                if (v.getId_ruta() == id) {
                    break;
                }
            }
            vistaViaje.tableIndex = index;
            vistaViajeM.hide();
        }
        vistaViaje.updateAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dtpEscritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        mnbNavegador = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mitSalir = new javax.swing.JMenuItem();
        mnuPasajero = new javax.swing.JMenu();
        mitPasajero = new javax.swing.JMenuItem();
        mnuColectivo = new javax.swing.JMenu();
        mitColectivo = new javax.swing.JMenuItem();
        mnuRuta = new javax.swing.JMenu();
        mitRuta = new javax.swing.JMenuItem();
        mnuPasajes = new javax.swing.JMenu();
        mitPasajes = new javax.swing.JMenuItem();

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
        vistaPasajes.setLocation(mnuPasajes.getX(), 0);
        vistaPasajes.show();
        desktopMain.moveToFront(vistaPasajes);
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VistaMain().setVisible(true));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dtpEscritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem mitColectivo;
    private javax.swing.JMenuItem mitPasajero;
    private javax.swing.JMenuItem mitPasajes;
    private javax.swing.JMenuItem mitRuta;
    private javax.swing.JMenuItem mitSalir;
    private javax.swing.JMenuBar mnbNavegador;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuColectivo;
    private javax.swing.JMenu mnuPasajero;
    private javax.swing.JMenu mnuPasajes;
    private javax.swing.JMenu mnuRuta;
    // End of variables declaration//GEN-END:variables
}
