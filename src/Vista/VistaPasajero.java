package Vista;

import Modelo.Pasajero;
import static Vista.TestMain.pasajeroData;
import static Vista.VistaMain.desktopMain;
import static Vista.VistaMain.vistaMain;
import static Vista.VistaMain.vistaPasaje;
import static Vista.VistaMain.vistaPasajeroM;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VistaPasajero extends javax.swing.JInternalFrame {

    javax.swing.table.DefaultTableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer();
    private DefaultTableModel table;
    
    public ArrayList<Pasajero> tableList = new ArrayList<>();
    public int tableIndex = -1;
    
    public VistaPasajero() {
        initComponents();
        armarTabla();
        updateAll();
        
        tblPasajero.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPasajero.setShowHorizontalLines(true);
        tblPasajero.setShowVerticalLines(true);
        tblPasajero.putClientProperty("JTable.showInactiveSelection", true);
        tblPasajero.getSelectionModel().addListSelectionListener(
            new javax.swing.event.ListSelectionListener() {
                @Override
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    if (!evt.getValueIsAdjusting()) {
                        int selection = tblPasajero.getSelectedRow();
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

            tblPasajero.setRowSelectionInterval(tableIndex, tableIndex);

            btnModificar.setEnabled(true);
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
            tblPasajero.clearSelection();

            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnAlta.setEnabled(false);
            btnBaja.setEnabled(false);
        }
    }
        
    public void armarTabla() {
        String[] titulos = {"DNI", "Nombre", "Apellido", "Correo", "Teléfono", "Estado"};
        
        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tblPasajero.setModel(table);
        
        renderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        tblPasajero.getColumnModel().getColumn(0).setPreferredWidth(25);
        tblPasajero.getColumnModel().getColumn(0).setCellRenderer(renderer);
        tblPasajero.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblPasajero.getColumnModel().getColumn(1).setCellRenderer(renderer);
        tblPasajero.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblPasajero.getColumnModel().getColumn(2).setCellRenderer(renderer);
        tblPasajero.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblPasajero.getColumnModel().getColumn(3).setCellRenderer(renderer);
        tblPasajero.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblPasajero.getColumnModel().getColumn(4).setCellRenderer(renderer);
        tblPasajero.getColumnModel().getColumn(5).setPreferredWidth(5);
        tblPasajero.getColumnModel().getColumn(5).setCellRenderer(renderer);
        
    }
    
    
    public void updateAll() {
        table.setRowCount(0);
        tableList = pasajeroData.getList();
        
        for (Pasajero p : tableList) {
            String estado = "Inactivo";
            if (p.getEstado()) {estado = "Activo";}
            table.addRow(new Object[]{p.getDni(), p.getNombre(), p.getApellido(), p.getCorreo(), p.getTelefono(), estado});
        }

        updateIndex();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpTablaPasajeros = new javax.swing.JScrollPane();
        tblPasajero = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        tblPasajero.setModel(new javax.swing.table.DefaultTableModel(
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
        scpTablaPasajeros.setViewportView(tblPasajero);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Lista de Pasajeros:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(this::btnModificarActionPerformed);

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
                            .addComponent(scpTablaPasajeros, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
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
                .addComponent(scpTablaPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnBaja)
                    .addComponent(btnAlta))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        vistaPasajeroM.setLocation(
            this.getX() + ((this.getWidth() - vistaPasajeroM.getWidth()) / 2),
            this.getY() + ((this.getHeight() - vistaPasajeroM.getHeight()) / 2)
        );
        vistaPasajeroM.pasajero = tableList.get(tableIndex);
        vistaPasajeroM.start(2);
        vistaPasajeroM.show();
        desktopMain.moveToFront(vistaPasajeroM);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        vistaPasajeroM.setLocation(
            this.getX() + ((this.getWidth() - vistaPasajeroM.getWidth()) / 2),
            this.getY() + ((this.getHeight() - vistaPasajeroM.getHeight()) / 2)
        );
        vistaPasajeroM.start(1);
        vistaPasajeroM.show();
        desktopMain.moveToFront(vistaPasajeroM);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "Esta acción eliminará permanentemente al pasajero de la base de datos\n¿Desea continuar?", "Advertencia: borrado permanente", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        
        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            int id = tableList.get(tableIndex).getId_pasajero();
            if ((tableIndex+1) == tableList.size()) {tableIndex--;}
            pasajeroData.remove(id);
            vistaPasajeroM.delHideWindow();
            updateAll(); vistaPasaje.updateAll();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        Pasajero p = tableList.get(tableIndex);
        p.setEstado(true);
        pasajeroData.update(p);
        updateAll();
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        Pasajero p = tableList.get(tableIndex);
        p.setEstado(false);
        pasajeroData.update(p);
        updateAll();
    }//GEN-LAST:event_btnBajaActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scpTablaPasajeros;
    private javax.swing.JTable tblPasajero;
    // End of variables declaration//GEN-END:variables
}
