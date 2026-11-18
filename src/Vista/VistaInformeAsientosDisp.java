package Vista;

import Modelo.Asiento;
import Modelo.Pasaje;
import Modelo.RutaViaje;
import static Vista.TestMain.asientoData;
import static Vista.TestMain.pasajeData;
import static Vista.TestMain.rutaData;
import static Vista.VistaMain.vistaColectivoM;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VistaInformeAsientosDisp extends javax.swing.JInternalFrame {
    
    private DefaultTableModel table;
    private List<RutaViaje> tableList = new ArrayList<>();
    
    public VistaInformeAsientosDisp() {
        initComponents();
        armarTabla();
        cargarCombos(); 
        
        dchFecha.getDateEditor().addPropertyChangeListener("date", e -> actualizarTabla());
        cmbHora.addActionListener(e -> actualizarTabla());
    }

    public void armarTabla() {
    
        String[] titulos = {"Origen", "Destino", "Fecha Viaje", "Hora Salida", "Matrícula", "Chofer", "Capacidad", "Vendidos", "Disponibles"};
        
        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblInformeAsientos.setModel(table);
    }
    
    private void cargarCombos() {
        cmbHora.removeAllItems();
        cmbHora.addItem("Todas");
        
        for (RutaViaje r : rutaData.getList()) {
            String horaStr = r.getHora_salida().toString();
            boolean existe = false;
            for (int i = 0; i < cmbHora.getItemCount(); i++) {
                if (cmbHora.getItemAt(i).equals(horaStr)) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                cmbHora.addItem(horaStr);
            }
        }
    }

    public void actualizarTabla() {
        table.setRowCount(0);
        
        java.util.Date fechaSeleccionadaUtil = dchFecha.getDate();
        String horaSeleccionada = (String) cmbHora.getSelectedItem();
        
        tableList = rutaData.getList();

        tableList.sort((r1, r2) -> {
            int compFecha = r1.getFecha_viaje().compareTo(r2.getFecha_viaje());
            if (compFecha != 0) {
                return compFecha;
            }
            return r1.getHora_salida().compareTo(r2.getHora_salida());
        });

        LocalDate fechaFiltro = null;
        if (fechaSeleccionadaUtil != null) {
            fechaFiltro = fechaSeleccionadaUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        ArrayList<Asiento> listaAsientos = asientoData.getList();
        ArrayList<Pasaje> listaPasajes = pasajeData.getList();

        for (RutaViaje r : tableList) {
            boolean cumpleFecha = true;
            boolean cumpleHora = true;

            if (fechaFiltro != null) {
                if (r.getFecha_viaje().isBefore(fechaFiltro)) {
                    cumpleFecha = false;
                }
            }

            if (horaSeleccionada != null && !horaSeleccionada.equals("Todas")) {
                if (!r.getHora_salida().toString().equals(horaSeleccionada)) {
                    cumpleHora = false;
                }
            }

            if (cumpleFecha && cumpleHora) {
                String matricula = (r.getColectivo() != null) ? r.getColectivo().getMatricula() : "Sin asignar";
                String chofer = (r.getColectivo() != null) ? r.getColectivo().getChofer() : "Sin chofer";
                int capacidad = (r.getColectivo() != null) ? r.getColectivo().getCapacidad() : 0;

                int vendidos = 0;
                for (Pasaje p : listaPasajes) {
                    if (p.getRuta() != null && p.getRuta().getId_ruta() == r.getId_ruta() && p.getEstado()) {
                        vendidos++;
                    }
                }

                int totalAsientos = 0;
                for (Asiento a : listaAsientos) {
                    if (a.getRuta() != null && a.getRuta().getId_ruta() == r.getId_ruta()) {
                        totalAsientos++;
                    }
                }
                
                if (totalAsientos == 0) {
                    totalAsientos = capacidad;
                }

                int disponibles = totalAsientos - vendidos;
                if (disponibles < 0) disponibles = 0;

                table.addRow(new Object[]{
                    r.getOrigen(),
                    r.getDestino(),
                    r.getFecha_viaje(),
                    r.getHora_salida(),
                    matricula,
                    chofer,
                    totalAsientos,
                    vendidos,
                    disponibles
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
        lblChofer = new javax.swing.JLabel();
        dchFecha = new com.toedter.calendar.JDateChooser();
        lblHorario = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox<>();
        scpListadoAsientos = new javax.swing.JScrollPane();
        tblInformeAsientos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Flecha Flash S.A.: Informes");
        setToolTipText("");

        pnlContenedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar asientos por fecha y hora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        pnlContenedor.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        lblChofer.setText("Seleccione una fecha:");

        lblHorario.setText("Seleccione un horario:");

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
                        .addComponent(lblChofer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHorario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpListadoAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblChofer)
                        .addComponent(lblHorario)
                        .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JComboBox<String> cmbHora;
    private com.toedter.calendar.JDateChooser dchFecha;
    private javax.swing.JLabel lblChofer;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JScrollPane scpListadoAsientos;
    private javax.swing.JTable tblInformeAsientos;
    // End of variables declaration//GEN-END:variables
}
