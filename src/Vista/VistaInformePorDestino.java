package Vista;

import Modelo.RutaViaje;
import static Vista.TestMain.rutaData;
import static Vista.VistaMain.vistaColectivoM;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VistaInformePorDestino extends javax.swing.JInternalFrame {
    
    private DefaultTableModel table;
    private List<RutaViaje> tableList = new ArrayList<>();
    
    public VistaInformePorDestino() {
        initComponents();
        armarTabla();
        cargarDestinos();
        
        cmbDestino.addActionListener(e -> actualizarTabla());
        dchFecha.getDateEditor().addPropertyChangeListener("date", e -> actualizarTabla());
    }

    public void armarTabla() {
        
        String[] titulos = {"Origen", "Destino", "Fecha Viaje", "Hora Salida", "Matrícula Colectivo", "Marca / Modelo", "Chofer"};
        
        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblInformeViajes.setModel(table);
    }
    
    private void cargarDestinos() {
        cmbDestino.removeAllItems();
        cmbDestino.addItem("Todos");
        
        ArrayList<RutaViaje> rutas = rutaData.getList();
        for (RutaViaje r : rutas) {
            String destino = r.getDestino();
            boolean existe = false;
            for (int i = 0; i < cmbDestino.getItemCount(); i++) {
                if (cmbDestino.getItemAt(i).equals(destino)) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                cmbDestino.addItem(destino);
            }
        }
    }

    public void actualizarTabla() {
        table.setRowCount(0);
        
        String destinoSeleccionado = (String) cmbDestino.getSelectedItem();
        java.util.Date fechaSeleccionadaUtil = dchFecha.getDate();
        
        tableList = rutaData.getList();

  
        LocalDate fechaFiltro = null;
        if (fechaSeleccionadaUtil != null) {
            fechaFiltro = fechaSeleccionadaUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        for (RutaViaje r : tableList) {
            boolean cumpleDestino = true;
            boolean cumpleFecha = true;

       
            if (destinoSeleccionado != null && !destinoSeleccionado.equals("Todos")) {
                if (!r.getDestino().equalsIgnoreCase(destinoSeleccionado)) {
                    cumpleDestino = false;
                }
            }

      
            if (fechaFiltro != null) {
                if (!r.getFecha_viaje().equals(fechaFiltro)) {
                    cumpleFecha = false;
                }
            }

            if (cumpleDestino && cumpleFecha) {
                String matricula = (r.getColectivo() != null) ? r.getColectivo().getMatricula() : "Sin asignar";
                String marcaModelo = (r.getColectivo() != null) ? (r.getColectivo().getMarca() + " " + r.getColectivo().getModelo()) : "-";
                String chofer = (r.getColectivo() != null) ? r.getColectivo().getChofer() : "Sin chofer";

                table.addRow(new Object[]{
                    r.getOrigen(),
                    r.getDestino(),
                    r.getFecha_viaje(),
                    r.getHora_salida(),
                    matricula,
                    marcaModelo,
                    chofer
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
        lblFecha = new javax.swing.JLabel();
        dchFecha = new com.toedter.calendar.JDateChooser();
        lblDestino = new javax.swing.JLabel();
        cmbDestino = new javax.swing.JComboBox<>();
        scpListadoViajes = new javax.swing.JScrollPane();
        tblInformeViajes = new javax.swing.JTable();

        setClosable(true);

        pnlContenedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar viajes por destino", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 0, 24))); // NOI18N
        pnlContenedor.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        lblFecha.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        lblFecha.setText("Seleccione una fecha:");

        lblDestino.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        lblDestino.setText("Seleccione un destino:");

        cmbDestino.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        tblInformeViajes.setModel(new javax.swing.table.DefaultTableModel(
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
        scpListadoViajes.setViewportView(tblInformeViajes);

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDestino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpListadoViajes, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFecha)
                        .addComponent(lblDestino)
                        .addComponent(cmbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scpListadoViajes, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
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
    private javax.swing.JComboBox<String> cmbDestino;
    private com.toedter.calendar.JDateChooser dchFecha;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JScrollPane scpListadoViajes;
    private javax.swing.JTable tblInformeViajes;
    // End of variables declaration//GEN-END:variables
}
