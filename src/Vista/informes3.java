package Vista;

import Modelo.RutaViaje;
import static Vista.TestMain.rutaData;
import static Vista.VistaMain.vistaColectivoM;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

public class informes3 extends javax.swing.JInternalFrame {

    private DefaultTableModel table;
    public ArrayList<RutaViaje> tableList = new ArrayList<>();

    public informes3() {
        initComponents();
        armarTabla();
        cargarCombos();

        jDateChooser1.getDateEditor().addPropertyChangeListener("date", e -> actualizarTabla());
        jComboBox1.addActionListener(e -> actualizarTabla());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

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

        jLabel1.setText("Seleccione Fecha");

        jLabel2.setText("Seleccione Hora");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void armarTabla() {
  
        String[] titulos = {"Origen", "Destino", "Fecha Viaje", "Hora Salida", "Matrícula Colectivo", "Chofer"};

        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(table);
    }

    private void cargarCombos() {
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Todas");

        for (RutaViaje r : rutaData.getList()) {
            String horaStr = r.getHora_salida().toString();
       
            boolean existe = false;
            for (int i = 0; i < jComboBox1.getItemCount(); i++) {
                if (jComboBox1.getItemAt(i).equals(horaStr)) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                jComboBox1.addItem(horaStr);
            }
        }
    }

    public void actualizarTabla() {
        table.setRowCount(0);

        java.util.Date fechaSeleccionadaUtil = jDateChooser1.getDate();
        String horaSeleccionada = (String) jComboBox1.getSelectedItem();

        tableList = rutaData.getList();

        Collections.sort(tableList, new Comparator<RutaViaje>() {
            @Override
            public int compare(RutaViaje r1, RutaViaje r2) { // <-- Agregá "public" acá
                int compFecha = r1.getFecha_viaje().compareTo(r2.getFecha_viaje());
                if (compFecha != 0) {
                    return compFecha;
                }
                return r1.getHora_salida().compareTo(r2.getHora_salida());
            }
        });

        LocalDate fechaFiltro = null;
        if (fechaSeleccionadaUtil != null) {
            fechaFiltro = fechaSeleccionadaUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

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

                table.addRow(new Object[]{
                    r.getOrigen(),
                    r.getDestino(),
                    r.getFecha_viaje(),
                    r.getHora_salida(),
                    matricula,
                    chofer
                });
            }
        }

        if (vistaColectivoM != null) {
            vistaColectivoM.delHideWindow();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
