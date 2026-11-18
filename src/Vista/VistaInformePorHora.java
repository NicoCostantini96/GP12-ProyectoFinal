package Vista;

import Modelo.RutaViaje;
import static Vista.TestMain.rutaData;
import static Vista.VistaMain.vistaColectivoM;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VistaInformePorHora extends javax.swing.JInternalFrame {
    
    private DefaultTableModel table;
    private List<RutaViaje> tableList = new ArrayList<>();
    
    public VistaInformePorHora() {
        initComponents();
        armarTabla();
        cargarCombos();

        cmbSalida.addActionListener(e -> actualizarTablaPorFiltro());
        cmbLlegada.addActionListener(e -> actualizarTablaPorFiltro());

        updateAll();
    }

    public void armarTabla() {
        String[] titulos = {"Origen", "Destino", "Capacidad", "Hora de salida", "Hora de llegada"};

        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblInformePorHora.setModel(table);
    }

    public void updateAll() {
        table.setRowCount(0);
        tableList = rutaData.getList();

        for (RutaViaje c : tableList) {
            int capacidad = (c.getColectivo() != null) ? c.getColectivo().getCapacidad() : 0;
            table.addRow(new Object[]{
                c.getOrigen(),
                c.getDestino(),
                capacidad,
                c.getHora_salida(),
                c.getHora_llegada()
            });
        }

        if (vistaColectivoM != null) {
            vistaColectivoM.delHideWindow();
        }
    }

    private void cargarCombos() {
        cmbSalida.removeAllItems();
        cmbLlegada.removeAllItems();

        cmbSalida.addItem("Todas");
        cmbLlegada.addItem("Todas");

        for (RutaViaje r : rutaData.getList()) {
            cmbSalida.addItem(r.getHora_salida().toString());
            cmbLlegada.addItem(r.getHora_llegada().toString());
        }
    }

    private void actualizarTablaPorFiltro() {
        table.setRowCount(0);
        String horaSalidaSeleccionada = (String) cmbSalida.getSelectedItem();
        String horaLlegadaSeleccionada = (String) cmbLlegada.getSelectedItem();

        tableList = rutaData.getList();

        for (RutaViaje c : tableList) {
            boolean cumpleSalida = horaSalidaSeleccionada == null || horaSalidaSeleccionada.equals("Todas") || c.getHora_salida().toString().equals(horaSalidaSeleccionada);
            boolean cumpleLlegada = horaLlegadaSeleccionada == null || horaLlegadaSeleccionada.equals("Todas") || c.getHora_llegada().toString().equals(horaLlegadaSeleccionada);

            if (cumpleSalida && cumpleLlegada) {
                int capacidad = (c.getColectivo() != null) ? c.getColectivo().getCapacidad() : 0;
                table.addRow(new Object[]{
                    c.getOrigen(),
                    c.getDestino(),
                    capacidad,
                    c.getHora_salida(),
                    c.getHora_llegada()
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        lblHoraSalida = new javax.swing.JLabel();
        cmbSalida = new javax.swing.JComboBox<>();
        lblHoraLlegada = new javax.swing.JLabel();
        cmbLlegada = new javax.swing.JComboBox<>();
        scpListadoHoras = new javax.swing.JScrollPane();
        tblInformePorHora = new javax.swing.JTable();

        setClosable(true);
        setTitle("Flecha Flash S.A.: Informes");

        pnlContenedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar viajes por hora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        lblHoraSalida.setText("Hora de salida:");

        cmbSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblHoraLlegada.setText("Hora de llegada:");

        cmbLlegada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblInformePorHora.setModel(new javax.swing.table.DefaultTableModel(
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
        scpListadoHoras.setViewportView(tblInformePorHora);

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addComponent(lblHoraSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(lblHoraLlegada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpListadoHoras))
                .addContainerGap())
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraSalida)
                    .addComponent(cmbSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoraLlegada)
                    .addComponent(cmbLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scpListadoHoras, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
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
    private javax.swing.JComboBox<String> cmbLlegada;
    private javax.swing.JComboBox<String> cmbSalida;
    private javax.swing.JLabel lblHoraLlegada;
    private javax.swing.JLabel lblHoraSalida;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JScrollPane scpListadoHoras;
    private javax.swing.JTable tblInformePorHora;
    // End of variables declaration//GEN-END:variables
}
