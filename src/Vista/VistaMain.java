package Vista;

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
    public static VistaAsiento vistaAsiento = new VistaAsiento();
    public static VistaAsientoModificar vistaAsientoM = new VistaAsientoModificar();
    public static VistaViaje vistaViaje = new VistaViaje();
    public static VistaViajeModificar vistaViajeM = new VistaViajeModificar();
    public static VistaPasaje vistaPasaje = new VistaPasaje();
    public static VistaPasajeModificar vistaPasajeM = new VistaPasajeModificar();
    public static VistaInformePorHora informePorHora = new VistaInformePorHora();
    public static VistaInformePasajes informePasajes = new VistaInformePasajes();
    public static VistaInformeChoferes informeChoferes = new VistaInformeChoferes();
    public static VistaInformeAsientosDisp informeAsientosDisp = new VistaInformeAsientosDisp();
    public static VistaInformePorDestino informeDestinos = new VistaInformePorDestino();
    public static VistaInformeAsientosPorRuta informeAsientosRuta = new VistaInformeAsientosPorRuta();

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
        desktopMain.add(informePorHora);
        desktopMain.add(informePasajes);
        desktopMain.add(informeChoferes);
        desktopMain.add(informeAsientosDisp);
        desktopMain.add(informeDestinos);
        desktopMain.add(informeAsientosRuta);

        img();
        configurarListenersDeRedimensionamiento();
        try {
            java.awt.Image logo = java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMG/logo.png"));
            this.setIconImage(logo);
        } catch (Exception e) {}
    }

    public void img() {
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/IMG/flechaflash.jpg"));

        // Obtenemos el ancho y alto actual del contenedor (dtpEscritorio) 
        // en lugar de usar valores fijos (594x470). Si recién inicia, usamos un tamaño por defecto.
        int ancho = dtpEscritorio.getWidth() > 0 ? dtpEscritorio.getWidth() : 594;
        int alto = dtpEscritorio.getHeight() > 0 ? dtpEscritorio.getHeight() : 470;

        // Escala la imagen con alta calidad (Image.SCALE_SMOOTH)
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        lblBackground.setIcon(new ImageIcon(imagenEscalada));

        // Aseguramos que el JLabel ocupe todo el JDesktopPane
        lblBackground.setBounds(0, 0, ancho, alto);
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
        lblBackground = new javax.swing.JLabel();
        mnbNavegador = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mitSalir = new javax.swing.JMenuItem();
        mnuPasajero = new javax.swing.JMenu();
        mitPasajero = new javax.swing.JMenuItem();
        mnuColectivo = new javax.swing.JMenu();
        mitColectivo = new javax.swing.JMenuItem();
        mnuAsiento = new javax.swing.JMenu();
        mitAsientos = new javax.swing.JMenuItem();
        mnuRuta = new javax.swing.JMenu();
        mitRuta = new javax.swing.JMenuItem();
        mnuPasajes = new javax.swing.JMenu();
        mitPasajes = new javax.swing.JMenuItem();
        mnuInformes = new javax.swing.JMenu();
        mitListarPorHora = new javax.swing.JMenuItem();
        mitListarPasajes = new javax.swing.JMenuItem();
        mitChoferColectivo = new javax.swing.JMenuItem();
        mitConsultaAsientos = new javax.swing.JMenuItem();
        mitListaColectivos = new javax.swing.JMenuItem();
        mitAsientosPorRuta = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Flecha Flash S.A.");
        setMinimumSize(new java.awt.Dimension(56, 36));

        dtpEscritorio.setMaximumSize(new java.awt.Dimension(600, 600));
        dtpEscritorio.setMinimumSize(new java.awt.Dimension(600, 600));

        lblBackground.setAutoscrolls(true);

        dtpEscritorio.setLayer(lblBackground, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dtpEscritorioLayout = new javax.swing.GroupLayout(dtpEscritorio);
        dtpEscritorio.setLayout(dtpEscritorioLayout);
        dtpEscritorioLayout.setHorizontalGroup(
            dtpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dtpEscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                .addContainerGap())
        );
        dtpEscritorioLayout.setVerticalGroup(
            dtpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtpEscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        mitAsientos.setText("Asiento");
        mitAsientos.addActionListener(this::mitAsientosActionPerformed);
        mnuAsiento.add(mitAsientos);

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

        mnuInformes.setText("Informes");

        mitListarPorHora.setText("Lista de rutas por hora");
        mitListarPorHora.addActionListener(this::mitListarPorHoraActionPerformed);
        mnuInformes.add(mitListarPorHora);

        mitListarPasajes.setText("Lista de pasajes por pasajero");
        mitListarPasajes.addActionListener(this::mitListarPasajesActionPerformed);
        mnuInformes.add(mitListarPasajes);

        mitChoferColectivo.setText("Lista de choferes y colectivos");
        mitChoferColectivo.addActionListener(this::mitChoferColectivoActionPerformed);
        mnuInformes.add(mitChoferColectivo);

        mitConsultaAsientos.setText("Lista de asientos disponibles");
        mitConsultaAsientos.addActionListener(this::mitConsultaAsientosActionPerformed);
        mnuInformes.add(mitConsultaAsientos);

        mitListaColectivos.setText("Lista de colectivos por fecha");
        mitListaColectivos.addActionListener(this::mitListaColectivosActionPerformed);
        mnuInformes.add(mitListaColectivos);

        mitAsientosPorRuta.setText("Lista de asientos por ruta");
        mitAsientosPorRuta.addActionListener(this::mitAsientosPorRutaActionPerformed);
        mnuInformes.add(mitAsientosPorRuta);

        mnbNavegador.add(mnuInformes);

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
                .addComponent(dtpEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 486, Short.MAX_VALUE)
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

    private void mitAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAsientosActionPerformed
        vistaAsiento.setLocation(mnuAsiento.getX(), 0);
        vistaAsiento.show();
        desktopMain.moveToFront(vistaAsiento);
    }//GEN-LAST:event_mitAsientosActionPerformed

    private void mitListarPorHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitListarPorHoraActionPerformed
        informePorHora.setLocation(mitListarPorHora.getX(), 0);
        informePorHora.show();
        desktopMain.moveToFront(informePorHora);
    }//GEN-LAST:event_mitListarPorHoraActionPerformed

    private void mitListarPasajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitListarPasajesActionPerformed
        informePasajes.setLocation(mitListarPasajes.getX(), 0);
        informePasajes.show();
        desktopMain.moveToFront(informePasajes);

    }//GEN-LAST:event_mitListarPasajesActionPerformed

    private void mitChoferColectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitChoferColectivoActionPerformed
        informeChoferes.setLocation(mitChoferColectivo.getX(), 0);
        informeChoferes.show();
        desktopMain.moveToFront(informeChoferes);
    }//GEN-LAST:event_mitChoferColectivoActionPerformed

    private void mitConsultaAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitConsultaAsientosActionPerformed
        informeAsientosDisp.setLocation(mitConsultaAsientos.getX(), 0);
        informeAsientosDisp.show();
        desktopMain.moveToFront(informeAsientosDisp);
    }//GEN-LAST:event_mitConsultaAsientosActionPerformed

    private void mitListaColectivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitListaColectivosActionPerformed
        informeDestinos.setLocation(mitListaColectivos.getX(), 0);
        informeDestinos.show();
        desktopMain.moveToFront(informeDestinos);
    }//GEN-LAST:event_mitListaColectivosActionPerformed

    private void mitAsientosPorRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAsientosPorRutaActionPerformed
        informeAsientosRuta.setLocation(mitAsientosPorRuta.getX(), 0);
        informeAsientosRuta.show();
        desktopMain.moveToFront(informeAsientosRuta);
    }//GEN-LAST:event_mitAsientosPorRutaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VistaMain().setVisible(true));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dtpEscritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JMenuItem mitAsientos;
    private javax.swing.JMenuItem mitAsientosPorRuta;
    private javax.swing.JMenuItem mitChoferColectivo;
    private javax.swing.JMenuItem mitColectivo;
    private javax.swing.JMenuItem mitConsultaAsientos;
    private javax.swing.JMenuItem mitListaColectivos;
    private javax.swing.JMenuItem mitListarPasajes;
    private javax.swing.JMenuItem mitListarPorHora;
    private javax.swing.JMenuItem mitPasajero;
    private javax.swing.JMenuItem mitPasajes;
    private javax.swing.JMenuItem mitRuta;
    private javax.swing.JMenuItem mitSalir;
    private javax.swing.JMenuBar mnbNavegador;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAsiento;
    private javax.swing.JMenu mnuColectivo;
    private javax.swing.JMenu mnuInformes;
    private javax.swing.JMenu mnuPasajero;
    private javax.swing.JMenu mnuPasajes;
    private javax.swing.JMenu mnuRuta;
    // End of variables declaration//GEN-END:variables
}
