package Vista;

import Modelo.Colectivo;
import Modelo.RutaViaje;
import Persistencia.RutaViajeData;
import static Vista.TestMain.rutaData;
import static Vista.TestMain.colectivoData;
import static Vista.VistaMain.vistaColectivoM;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class informes1 extends javax.swing.JInternalFrame {

    private DefaultTableModel table;
    public ArrayList<RutaViaje> tableList = new ArrayList<>();

    public informes1() {
        initComponents();
        armarTabla();
        cargarCombos();

        jComboBox1.addActionListener(e -> actualizarTablaPorFiltro());
        jComboBox2.addActionListener(e -> actualizarTablaPorFiltro());

        // Carga inicial de datos
        updateAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Seleccione hora de salida");

        jLabel2.setText("Seleccione hora de llegada");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(228, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void armarTabla() {
        String[] titulos = {"Origen", "Destino", "Capacidad", "Hora De Salida", "Hora De Llegada"};

        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(table);
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
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();

        jComboBox1.addItem("Todas");
        jComboBox2.addItem("Todas");

        for (RutaViaje r : rutaData.getList()) {
            jComboBox1.addItem(r.getHora_salida().toString());
            jComboBox2.addItem(r.getHora_llegada().toString());
        }
    }

    private void actualizarTablaPorFiltro() {
        table.setRowCount(0);
        String horaSalidaSeleccionada = (String) jComboBox1.getSelectedItem();
        String horaLlegadaSeleccionada = (String) jComboBox2.getSelectedItem();

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
