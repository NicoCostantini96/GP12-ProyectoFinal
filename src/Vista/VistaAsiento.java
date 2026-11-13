package Vista;

import Modelo.Asiento;
import Modelo.Colectivo;
import Modelo.Pasajero;
import Modelo.RutaViaje;
import static Vista.TestMain.asientoData;
import static Vista.TestMain.colectivoData;
import static Vista.TestMain.pasajeroData;
import static Vista.VistaMain.desktopMain;
import static Vista.VistaMain.vistaAsientoM;
import static Vista.VistaMain.vistaColectivoM;
import static Vista.VistaMain.vistaMain;
import static Vista.VistaMain.vistaPasaje;
import static Vista.VistaMain.vistaPasajeroM;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VistaAsiento extends javax.swing.JInternalFrame {

    javax.swing.table.DefaultTableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer();
    private DefaultTableModel table;
    
    public ArrayList<Asiento> tableList = new ArrayList<>();
    public ArrayList<RutaViaje> rutaList = new ArrayList<>();
    public int tableIndex = -1;
    
    public VistaAsiento() {
        initComponents();
        armarTabla();
        updateAll();
        
        tblAsiento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAsiento.setShowHorizontalLines(true);
        tblAsiento.setShowVerticalLines(true);
        tblAsiento.putClientProperty("JTable.showInactiveSelection", true);
        tblAsiento.getSelectionModel().addListSelectionListener(
            new javax.swing.event.ListSelectionListener() {
                @Override
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    if (!evt.getValueIsAdjusting()) {
                        int selection = tblAsiento.getSelectedRow();
                        if (selection != -1) {
                            tableIndex = selection;
                            updateIndex();
                        }
                    }
                }
            }
        );
    }
    
    public void updateIndex() {
        if (tableIndex >= 0 && tableIndex < tableList.size()) {

            tblAsiento.setRowSelectionInterval(tableIndex, tableIndex);

            //btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);

            if (tableList.get(tableIndex).getEstado()) {
                btnAlta.setEnabled(false);
                btnBaja.setEnabled(true);
            } else {
                btnAlta.setEnabled(true);
                btnBaja.setEnabled(false);
            }

        } else {
            tableIndex = -1;
            tblAsiento.clearSelection();

            //btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnAlta.setEnabled(false);
            btnBaja.setEnabled(false);
        }
    }
    
    public void armarTabla() {
        String[] titulos = {"Viaje", "Asiento", "Estado"};
        
        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tblAsiento.setModel(table);
        
        renderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        tblAsiento.getColumnModel().getColumn(0).setPreferredWidth(400);
        tblAsiento.getColumnModel().getColumn(0).setCellRenderer(renderer);
        tblAsiento.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblAsiento.getColumnModel().getColumn(1).setCellRenderer(renderer);
        tblAsiento.getColumnModel().getColumn(2).setPreferredWidth(5);
        tblAsiento.getColumnModel().getColumn(2).setCellRenderer(renderer);
        
    }
    
    public void updateAll() {
        table.setRowCount(0);

        tableList = new ArrayList<>();
        rutaList.clear();

        for (Asiento a : asientoData.getList()) {
            if (a.getRuta().getColectivo() != null) {
                tableList.add(a);
                rutaList.add(a.getRuta());
                String estado = a.getEstado() ? "Activo" : "Inactivo";
                table.addRow(new Object[]{
                    a.getRuta().getColectivo().getMatricula()
                        + " - (" + a.getRuta().getOrigen()
                        + " - " + a.getRuta().getDestino()
                        + ") - (" + a.getRuta().getFecha_viaje()
                        + ") - (" + a.getRuta().getHora_salida()
                        + " - " + a.getRuta().getHora_llegada() + ")",
                    a.getNumero_asiento(),
                    estado
                });
            }
        }

        if (vistaAsientoM != null) {
            vistaAsientoM.delHideWindow();
        }

        updateIndex();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpTablaColectivos = new javax.swing.JScrollPane();
        tblAsiento = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        tblAsiento.setModel(new javax.swing.table.DefaultTableModel(
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
        scpTablaColectivos.setViewportView(tblAsiento);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Lista de Asientos:");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnBaja.setText("Baja");
        btnBaja.addActionListener(this::btnBajaActionPerformed);

        btnAlta.setText("Alta");
        btnAlta.addActionListener(this::btnAltaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scpTablaColectivos, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scpTablaColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnBaja)
                    .addComponent(btnAlta))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* AGREGAR
        vistaAsientoM.setLocation(
            this.getX() + ((this.getWidth() - vistaAsientoM.getWidth()) / 2),
            this.getY() + ((this.getHeight() - vistaAsientoM.getHeight()) / 2)
        );
        vistaAsientoM.start(1);
        vistaAsientoM.show();
        desktopMain.moveToFront(vistaAsientoM);
    */
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "Esta acción eliminará permanentemente al colectivo de la base de datos\n¿Desea continuar?", "Advertencia: borrado permanente", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            int id = tableList.get(tableIndex).getId_lugar();
            if ((tableIndex+1) == tableList.size()) {tableIndex--;}
            asientoData.remove(id);
            updateAll(); vistaPasaje.updateAll();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /* ELIMINAR
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "Esta acción eliminará permanentemente al colectivo de la base de datos\n¿Desea continuar?", "Advertencia: borrado permanente", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            int id = tableList.get(tableIndex).getId_lugar();
            if ((tableIndex+1) == tableList.size()) {tableIndex--;}
            asientoData.remove(id);
            updateAll(); vistaPasaje.updateAll();
        }
    */
    
    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        Asiento a = tableList.get(tableIndex);
        a.setEstado(true);
        asientoData.update(a);
        updateAll();
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        Asiento a = tableList.get(tableIndex);
        a.setEstado(false);
        asientoData.update(a);
        updateAll();
    }//GEN-LAST:event_btnBajaActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scpTablaColectivos;
    private javax.swing.JTable tblAsiento;
    // End of variables declaration//GEN-END:variables
}
