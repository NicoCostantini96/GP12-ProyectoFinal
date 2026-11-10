package Vista;

import Modelo.RutaViaje;
import static Vista.VistaMain.desktopMain;
import static Vista.VistaMain.viajeData;
import static Vista.VistaMain.vistaMain;
import static Vista.VistaMain.vistaViajeM;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VistaViaje extends javax.swing.JInternalFrame {

    javax.swing.table.DefaultTableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer();
    private DefaultTableModel table;
    
    public ArrayList<RutaViaje> tableList = new ArrayList<>();
    public int tableIndex = -1;
    
    public VistaViaje() {
        initComponents();
        armarTabla();
        updateAll();
        
        tblRuta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRuta.setShowHorizontalLines(true);
        tblRuta.setShowVerticalLines(true);
        tblRuta.putClientProperty("JTable.showInactiveSelection", true);
        tblRuta.getSelectionModel().addListSelectionListener(
            new javax.swing.event.ListSelectionListener() {
                @Override
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    if (!evt.getValueIsAdjusting()) {
                        int selection = tblRuta.getSelectedRow();
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
            if (tableIndex != -1) {
                tblRuta.setRowSelectionInterval(tableIndex, tableIndex);

                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
                
                boolean estado = String.valueOf(tblRuta.getValueAt(tblRuta.getSelectedRow(), 6)).equalsIgnoreCase("Activo");

                if (estado) {
                    btnAlta.setEnabled(false);
                    btnBaja.setEnabled(true);
                    
                } else {
                    btnAlta.setEnabled(true);
                    btnBaja.setEnabled(false);
                }

            } else {
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnAlta.setEnabled(false);
                btnBaja.setEnabled(false);
            }

    }
    
    public void armarTabla() {
        String[] titulos = {"Origen", "Destino", "Fecha Viaje", "Hora salida", "Hora llegada", "Colectivo", "Precio", "Estado"};
        
        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tblRuta.setModel(table);
        
        renderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        tblRuta.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblRuta.getColumnModel().getColumn(0).setCellRenderer(renderer);
        tblRuta.getColumnModel().getColumn(1).setPreferredWidth(40);
        tblRuta.getColumnModel().getColumn(1).setCellRenderer(renderer);
        tblRuta.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblRuta.getColumnModel().getColumn(2).setCellRenderer(renderer);
        tblRuta.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblRuta.getColumnModel().getColumn(3).setCellRenderer(renderer);
        tblRuta.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblRuta.getColumnModel().getColumn(4).setCellRenderer(renderer);
        tblRuta.getColumnModel().getColumn(5).setPreferredWidth(40);
        tblRuta.getColumnModel().getColumn(5).setCellRenderer(renderer);
        tblRuta.getColumnModel().getColumn(6).setPreferredWidth(20);
        tblRuta.getColumnModel().getColumn(6).setCellRenderer(renderer);
        tblRuta.getColumnModel().getColumn(7).setPreferredWidth(5);
        tblRuta.getColumnModel().getColumn(7).setCellRenderer(renderer);
        
    }
    
    public void updateAll() {
        table.setRowCount(0);
        tableList = viajeData.getList();
        
        for (RutaViaje r : tableList) {
            String estado = "Inactivo";
            if (r.getEstado()) {estado = "Activo";}
            table.addRow(new Object[]{r.getOrigen(),r.getDestino(),r.getFecha_viaje(),r.getHora_salida(),r.getHora_llegada(),r.getColectivo().getMatricula(),r.getPrecio(), estado});
        }

        updateIndex();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpRutas = new javax.swing.JScrollPane();
        tblRuta = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        tblRuta.setModel(new javax.swing.table.DefaultTableModel(
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
        scpRutas.setViewportView(tblRuta);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Lista de Rutas:");

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
                            .addComponent(scpRutas, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
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
                .addComponent(scpRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        vistaViajeM.setLocation(
            this.getX() + ((this.getWidth() - vistaViajeM.getWidth()) / 2),
            this.getY() + ((this.getHeight() - vistaViajeM.getHeight()) / 2)
        );
        vistaViajeM.ruta = tableList.get(tableIndex);
        vistaViajeM.start(2);
        vistaViajeM.show();
        desktopMain.moveToFront(vistaViajeM);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        vistaViajeM.setLocation(
            this.getX() + ((this.getWidth() - vistaViajeM.getWidth()) / 2),
            this.getY() + ((this.getHeight() - vistaViajeM.getHeight()) / 2)
        );
        vistaViajeM.start(1);
        vistaViajeM.show();
        desktopMain.moveToFront(vistaViajeM);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "Esta acción eliminará permanentemente la ruta de la base de datos\n¿Desea continuar?", "Advertencia: borrado permanente", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        
        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            int id = tableList.get(tableIndex).getId_ruta();
            if ((tableIndex+1) == tableList.size()) {tableIndex--;}
            vistaMain.ruta("REMOVE",id);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        RutaViaje r = tableList.get(tableIndex);
        r.setEstado(true);
        viajeData.update(r);
        updateAll();
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        RutaViaje r = tableList.get(tableIndex);
        r.setEstado(false);
        viajeData.update(r);
        updateAll();
    }//GEN-LAST:event_btnBajaActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scpRutas;
    private javax.swing.JTable tblRuta;
    // End of variables declaration//GEN-END:variables
}
