/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;
import Modelo.RutaViaje;
import static Vista.TestMain.rutaData;
import static Vista.VistaMain.vistaColectivoM;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class informes5 extends javax.swing.JInternalFrame {

    private DefaultTableModel table;
    public ArrayList<RutaViaje> tableList = new ArrayList<>();

   
    public informes5() {
        initComponents();
        armarTabla();
        cargarDestinos();
        
        jComboBox1.addActionListener(e -> actualizarTabla());
        jDateChooser1.getDateEditor().addPropertyChangeListener("date", e -> actualizarTabla());
    }

    public void armarTabla() {
        
        String[] titulos = {"Origen", "Destino", "Fecha Viaje", "Hora Salida", "Matrícula Colectivo", "Marca / Modelo", "Chofer"};
        
        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(table);
    }
    
    private void cargarDestinos() {
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Todos");
        
      
        ArrayList<RutaViaje> rutas = rutaData.getList();
        for (RutaViaje r : rutas) {
            String destino = r.getDestino();
            boolean existe = false;
            for (int i = 0; i < jComboBox1.getItemCount(); i++) {
                if (jComboBox1.getItemAt(i).equals(destino)) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                jComboBox1.addItem(destino);
            }
        }
    }

    public void actualizarTabla() {
        table.setRowCount(0);
        
        String destinoSeleccionado = (String) jComboBox1.getSelectedItem();
        java.util.Date fechaSeleccionadaUtil = jDateChooser1.getDate();
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);

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

        jLabel1.setText("Seleccionar Destino");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Seleccionar fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
