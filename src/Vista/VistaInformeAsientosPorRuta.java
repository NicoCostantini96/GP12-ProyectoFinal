package Vista;

import Modelo.Asiento;
import Modelo.Pasaje;
import Modelo.RutaViaje;
import static Vista.TestMain.asientoData;
import static Vista.TestMain.pasajeData;
import static Vista.TestMain.rutaData;
import static Vista.VistaMain.vistaColectivoM;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VistaInformeAsientosPorRuta extends javax.swing.JInternalFrame {
    
    private DefaultTableModel table;
    private List<Asiento> tableList = new ArrayList<>();
    
    public VistaInformeAsientosPorRuta() {
        initComponents();
        armarTabla();
        cargarRutas(); 

        cmbRuta.addActionListener(e -> actualizarTabla());
    }

    private class RutaItem {
        private RutaViaje ruta;
        public RutaItem(RutaViaje ruta) { this.ruta = ruta; }
        public RutaViaje getRuta() { return ruta; }
        @Override
        public String toString() {
            return "ID: " + ruta.getId_ruta() + " | " + ruta.getOrigen() + " -> " + ruta.getDestino() + 
                   " (" + ruta.getFecha_viaje() + " - " + ruta.getHora_salida() + ")";
        }
    }

    public void armarTabla() {
 
        String[] titulos = {"N° Asiento", "Estado", "Pasajero", "DNI"};
        
        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblInformeAsientos.setModel(table);
    }
    
    private void cargarRutas() {
        cmbRuta.removeAllItems();
        ArrayList<RutaViaje> rutas = rutaData.getList();
        for (RutaViaje r : rutas) {
            cmbRuta.addItem(new RutaItem(r));
        }
        
        if (cmbRuta.getItemCount() > 0) {
            actualizarTabla();
        }
    }

    public void actualizarTabla() {
        table.setRowCount(0);
        
        RutaItem itemRuta = (RutaItem) cmbRuta.getSelectedItem();
        if (itemRuta == null) {
            return;
        }
        
        RutaViaje rutaSeleccionada = itemRuta.getRuta();
        int idRutaSeleccionada = rutaSeleccionada.getId_ruta();

        ArrayList<Asiento> listaAsientos = asientoData.getList();
        ArrayList<Pasaje> listaPasajes = pasajeData.getList();

        for (Asiento a : listaAsientos) {
            if (a.getRuta() != null && a.getRuta().getId_ruta() == idRutaSeleccionada) {
                String estadoStr = "Disponible";
                String nombrePasajero = "-";
                String dniPasajero = "-";

                // Verificar si el asiento tiene un pasaje activo vendido
                for (Pasaje p : listaPasajes) {
                    if (p.getLugar() != null && p.getLugar().getId_lugar() == a.getId_lugar() && p.getEstado()) {
                        estadoStr = "Vendido";
                        if (p.getPasajero() != null) {
                            nombrePasajero = p.getPasajero().getNombre() + " " + p.getPasajero().getApellido();
                            dniPasajero = p.getPasajero().getDni();
                        }
                        break;
                    }
                }

                table.addRow(new Object[]{
                    a.getNumero_asiento(),
                    estadoStr,
                    nombrePasajero,
                    dniPasajero
                });
            }
        }

        if (vistaColectivoM != null) {
            vistaColectivoM.delHideWindow();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        lblRuta = new javax.swing.JLabel();
        cmbRuta = new javax.swing.JComboBox<>();
        scpListadoAsientos = new javax.swing.JScrollPane();
        tblInformeAsientos = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Flecha Flash S.A.: Informes");
        setToolTipText("");

        pnlContenedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar asientos por ruta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        lblRuta.setText("Seleccione una ruta:");

        tblInformeAsientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scpListadoAsientos.setViewportView(tblInformeAsientos);

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addComponent(lblRuta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRuta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(scpListadoAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRuta)
                    .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scpListadoAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<RutaItem> cmbRuta;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JScrollPane scpListadoAsientos;
    private javax.swing.JTable tblInformeAsientos;
    // End of variables declaration//GEN-END:variables
}
