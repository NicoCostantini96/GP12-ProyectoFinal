package Vista;

import Modelo.Asiento;
import Modelo.Pasaje;
import Modelo.Pasajero;
import Modelo.RutaViaje;
import static Vista.TestMain.pasajeroData;
import static Vista.VistaMain.asientoData;
import static Vista.VistaMain.desktopMain;
import static Vista.VistaMain.pasajeData;
import static Vista.VistaMain.viajeData;
import static Vista.VistaMain.vistaAsiento;
import static Vista.VistaMain.vistaMain;
import static Vista.VistaMain.vistaPasajeM;
import static Vista.VistaMain.vistaPasajeroM;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VistaPasaje extends javax.swing.JInternalFrame {

    javax.swing.table.DefaultTableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer();
    private DefaultTableModel table;
    
    public ArrayList<Pasaje> tableList = new ArrayList<>();
    private ArrayList<int[]> elementsList = new ArrayList<>();
    public int tableIndex = -1;
    
    public VistaPasaje() {
        initComponents();
        armarTabla();
        updateAll();
        
        tblPasaje.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPasaje.setShowHorizontalLines(true);
        tblPasaje.setShowVerticalLines(true);
        tblPasaje.putClientProperty("JTable.showInactiveSelection", true);
        tblPasaje.getSelectionModel().addListSelectionListener(
            new javax.swing.event.ListSelectionListener() {
                @Override
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    if (!evt.getValueIsAdjusting()) {
                        int selection = tblPasaje.getSelectedRow();
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

            tblPasaje.setRowSelectionInterval(tableIndex, tableIndex);

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
            tblPasaje.clearSelection();

            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnAlta.setEnabled(false);
            btnBaja.setEnabled(false);
        }
    }
        
    public void armarTabla() {
        String[] titulos = {"Pasajero", "Ruta", "Asiento", "Fecha venta", "Hora venta", "Precio", "Estado"};
        
        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tblPasaje.setModel(table);
        
        renderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        tblPasaje.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblPasaje.getColumnModel().getColumn(0).setCellRenderer(renderer);
        tblPasaje.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblPasaje.getColumnModel().getColumn(1).setCellRenderer(renderer);
        tblPasaje.getColumnModel().getColumn(2).setPreferredWidth(5);
        tblPasaje.getColumnModel().getColumn(2).setCellRenderer(renderer);
        tblPasaje.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblPasaje.getColumnModel().getColumn(3).setCellRenderer(renderer);
        tblPasaje.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblPasaje.getColumnModel().getColumn(4).setCellRenderer(renderer);
        tblPasaje.getColumnModel().getColumn(5).setPreferredWidth(15);
        tblPasaje.getColumnModel().getColumn(5).setCellRenderer(renderer);
        tblPasaje.getColumnModel().getColumn(6).setPreferredWidth(3);
        tblPasaje.getColumnModel().getColumn(6).setCellRenderer(renderer);
        
    }
    
    
    public void updateAll() {
        table.setRowCount(0);
        tableList = pasajeData.getList();
        
        boolean createAsiento = false;
        
        elementsList.clear();
        for (Pasaje p : tableList) {
            String estado = "Inactivo";
            if (p.getEstado()) {estado = "Activo";}
            Asiento lugar = null;
            if (p.getLugar() == null) {
                Asiento a = new Asiento(0,p.getRuta(),0,true);
                asientoData.insert(a);
                lugar = asientoData.getList().getLast();
                createAsiento = true;
            }else{
                lugar = p.getLugar();
            }
            elementsList.add(new int[]{p.getId_pasaje(),p.getPasajero().getId_pasajero(),p.getRuta().getId_ruta(),lugar.getId_lugar()});
            table.addRow(new Object[]{p.getPasajero().getNombre()+" "+p.getPasajero().getApellido(), p.getRuta().getOrigen()+" - "+p.getRuta().getDestino(), lugar.getNumero_asiento(), p.getFecha_venta(), p.getHora_venta(), p.getPrecio(), estado});
        }
        
        if (createAsiento) {vistaAsiento.updateAll();}

        if (vistaPasajeM != null) {vistaPasajeM.delHideWindow();}
        updateIndex();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpTablaPasajeros = new javax.swing.JScrollPane();
        tblPasaje = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        tblPasaje.setModel(new javax.swing.table.DefaultTableModel(
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
        scpTablaPasajeros.setViewportView(tblPasaje);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Lista de Pasajes:");

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
                            .addComponent(scpTablaPasajeros, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
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
        vistaPasajeM.setLocation(
            this.getX() + ((this.getWidth() - vistaPasajeM.getWidth()) / 2),
            this.getY() + ((this.getHeight() - vistaPasajeM.getHeight()) / 2)
        );
        vistaPasajeM.pasaje = pasajeData.getById(elementsList.get(tableIndex)[0]);
        vistaPasajeM.pasajero = pasajeroData.getById(elementsList.get(tableIndex)[1]);
        vistaPasajeM.ruta = viajeData.getById(elementsList.get(tableIndex)[2]);
        vistaPasajeM.lugar = asientoData.getById(elementsList.get(tableIndex)[3]);
        vistaPasajeM.start(2);
        vistaPasajeM.show();
        desktopMain.moveToFront(vistaPasajeM);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        vistaPasajeM.setLocation(
            this.getX() + ((this.getWidth() - vistaPasajeM.getWidth()) / 2),
            this.getY() + ((this.getHeight() - vistaPasajeM.getHeight()) / 2)
        );
        vistaPasajeM.start(1);
        vistaPasajeM.show();
        desktopMain.moveToFront(vistaPasajeM);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "Esta acción eliminará permanentemente al pasajero de la base de datos\n¿Desea continuar?", "Advertencia: borrado permanente", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        
        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            int id = tableList.get(tableIndex).getId_pasaje();
            if ((tableIndex+1) == tableList.size()) {tableIndex--;}
            pasajeData.remove(id);
            updateAll();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        Pasaje p = tableList.get(tableIndex);
        p.setEstado(true);
        pasajeData.update(p);
        updateAll();
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        Pasaje p = tableList.get(tableIndex);
        p.setEstado(false);
        pasajeData.update(p);
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
    private javax.swing.JTable tblPasaje;
    // End of variables declaration//GEN-END:variables
}
