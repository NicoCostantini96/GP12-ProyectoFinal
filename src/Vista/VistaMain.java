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
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;

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
        desktopMain = jDesktopPane1; 
        desktopMain.add(vistaPasajero); desktopMain.add(vistaPasajeroM);
        desktopMain.add(vistaColectivo); desktopMain.add(vistaColectivoM);
        desktopMain.add(vistaViaje); desktopMain.add(vistaViajeM);
        desktopMain.add(vistaPasajes);
    }
    
    public void pasajero(String type, int id) {
        if (type.equals("INSERT")) {
            vistaPasajero.tableIndex = vistaPasajero.tableList.size();
            vistaPasajeroM.hide();
        }
        if (type.equals("REMOVE")) {
            for (Pasaje p: pasajeData.getList()) {
                if (p.getPasajero().getId_pasajero() == id) {
                    pasajeData.remove(p.getId_pasaje()); break;
                }
            }
            if (vistaPasajeroM.pasajero != null && vistaPasajeroM.pasajero.getId_pasajero() == id && vistaPasajeroM.estate == 2) {vistaPasajeroM.hide();}
            pasajeroData.remove(id);
        }
        if (type.equals("MODIFY")) {
            int index = -1;
            for (Pasajero p: pasajeroData.getList()) {
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
            for (Pasaje p : new ArrayList<>(pasajeData.getList())) {
                boolean pertenece = false;
                for (Asiento a : asientoData.getList()) {
                    if (a.getId_lugar() == p.getLugar().getId_lugar()
                        && a.getColectivo().getId_colectivo() == id) {
                        pertenece = true;
                        break;
                    }
                }
                for (RutaViaje r : viajeData.getList()) {
                    if (p.getRuta().getId_ruta() == r.getId_ruta()
                        && r.getColectivo().getId_colectivo() == id) {
                        pertenece = true;
                        break;
                    }
                }
                if (pertenece) {
                    pasajeData.remove(p.getId_pasaje());
                }
            }
            for (Asiento a : new ArrayList<>(asientoData.getList())) {
                if (a.getColectivo().getId_colectivo() == id) {
                    asientoData.remove(a.getId_lugar());
                }
            }
            for (RutaViaje r : new ArrayList<>(viajeData.getList())) {
                if (r.getColectivo().getId_colectivo() == id) {
                    ruta("REMOVE",r.getId_ruta());
                }
            }
            if (vistaColectivoM.colectivo != null && vistaColectivoM.colectivo.getId_colectivo() == id && vistaColectivoM.estate == 2) {vistaColectivoM.hide();}
            colectivoData.remove(id);
        }
        if (type.equals("MODIFY")) {
            int index = -1;
            for (Colectivo c: colectivoData.getList()) {
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
            for (Pasaje p: pasajeData.getList()) {
                if (p.getRuta().getId_ruta() == id) {
                    pasajeData.remove(p.getId_pasaje()); break;
                }
            }
            if (vistaViajeM.ruta != null && vistaViajeM.ruta.getId_ruta() == id && vistaViajeM.estate == 2) {vistaViajeM.hide();}
            viajeData.remove(id);
        }
        if (type.equals("MODIFY")) {
            int index = -1;
            for (RutaViaje v: viajeData.getList()) {
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

        jMenu3 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuPasajero = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuColectivo = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuRuta = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuPasajes = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(56, 36));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jDesktopPane1.setMaximumSize(new java.awt.Dimension(600, 600));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        menuPasajero.setText("Pasajero");

        jMenuItem2.setText("Pasajero");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        menuPasajero.add(jMenuItem2);

        jMenuBar1.add(menuPasajero);

        menuColectivo.setText("Colectivo");

        jMenuItem4.setText("Colectivo");
        jMenuItem4.addActionListener(this::jMenuItem4ActionPerformed);
        menuColectivo.add(jMenuItem4);

        jMenuBar1.add(menuColectivo);

        menuRuta.setText("Ruta");

        jMenuItem5.setText("Ruta");
        jMenuItem5.addActionListener(this::jMenuItem5ActionPerformed);
        menuRuta.add(jMenuItem5);

        jMenuBar1.add(menuRuta);

        menuPasajes.setText("Pasajes");

        jMenuItem3.setText("Pasajes");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        menuPasajes.add(jMenuItem3);

        jMenuBar1.add(menuPasajes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        vistaPasajero.setLocation(menuPasajero.getX(), 0); vistaPasajero.show();
        desktopMain.moveToFront(vistaPasajero);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        vistaPasajes.setLocation(menuPasajes.getX(),0); vistaPasajes.show();
        desktopMain.moveToFront(vistaPasajes);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        vistaColectivo.setLocation(menuPasajero.getX(), 0); vistaColectivo.show();
        desktopMain.moveToFront(vistaColectivo);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        vistaViaje.setLocation(menuRuta.getX(), 0); vistaViaje.show();
        desktopMain.moveToFront(vistaViaje);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VistaMain().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu menuColectivo;
    private javax.swing.JMenu menuPasajero;
    private javax.swing.JMenu menuPasajes;
    private javax.swing.JMenu menuRuta;
    // End of variables declaration//GEN-END:variables
}
