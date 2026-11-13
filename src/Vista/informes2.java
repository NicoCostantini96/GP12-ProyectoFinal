
package Vista;

import Modelo.Pasaje;
import Modelo.Pasajero;
import Modelo.RutaViaje;
import Persistencia.PasajeData;
import static Vista.TestMain.rutaData;
import static Vista.TestMain.pasajeData;
import static Vista.VistaMain.pasajeroData;
import static Vista.VistaMain.vistaColectivoM;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



public class informes2 extends javax.swing.JInternalFrame {
     private DefaultTableModel table;
      public ArrayList<Pasaje> tableList = new ArrayList<>();

   public informes2() {
        initComponents();
        armarTabla();
        cargarCombos(); 
        jComboBox1.addActionListener(e -> actualizarTabla());
        jComboBox2.addActionListener(e -> actualizarTabla());
    }

    private class PasajeroItem {
        private Pasajero pasajero;
        public PasajeroItem(Pasajero pasajero) { this.pasajero = pasajero; }
        public Pasajero getPasajero() { return pasajero; }
        @Override
        public String toString() {
            return pasajero.getNombre() + " " + pasajero.getApellido() + " (DNI: " + pasajero.getDni() + ")";
        }
    }

    private class MesItem {
        private int numero;
        private String nombre;
        public MesItem(int numero, String nombre) { this.numero = numero; this.nombre = nombre; }
        public int getNumero() { return numero; }
        @Override
        public String toString() { return nombre; }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setText("Ingrese pasajero");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jLabel2.setText("Seleccionar Mes");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public void armarTabla() {
    
        String[] titulos = {"ID Pasaje", "Origen", "Destino", "Fecha de Venta", "Hora de Venta", "Precio"};
        
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
        jComboBox2.removeAllItems();
        ArrayList<Pasajero> pasajeros = pasajeroData.getList();
        for (Pasajero p : pasajeros) {
            jComboBox1.addItem(new PasajeroItem(p));
        }

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (int i = 0; i < meses.length; i++) {
            jComboBox2.addItem(new MesItem(i + 1, meses[i]));
        }
        
        // Carga inicial de la tabla si hay elementos
        if (jComboBox1.getItemCount() > 0 && jComboBox2.getItemCount() > 0) {
            actualizarTabla();
        }
    }
    
    public void actualizarTabla() {
        table.setRowCount(0);
        
        PasajeroItem itemPasajero = (PasajeroItem) jComboBox1.getSelectedItem();
        MesItem itemMes = (MesItem) jComboBox2.getSelectedItem();
        
        if (itemPasajero == null || itemMes == null) {
            return;
        }
        
        int idPasajeroSeleccionado = itemPasajero.getPasajero().getId_pasajero();
        int mesSeleccionado = itemMes.getNumero();
        
        tableList = pasajeData.getList();

        for (Pasaje p : tableList) {
            // Validar que el pasaje pertenezca al pasajero y coincida con el mes de la fecha de venta
            if (p.getPasajero() != null && p.getPasajero().getId_pasajero() == idPasajeroSeleccionado) {
                if (p.getFecha_venta() != null && p.getFecha_venta().getMonthValue() == mesSeleccionado) {
                    
                    String origen = (p.getRuta() != null) ? p.getRuta().getOrigen() : "-";
                    String destino = (p.getRuta() != null) ? p.getRuta().getDestino() : "-";
                    
                    table.addRow(new Object[]{
                        p.getId_pasaje(),
                        origen,
                        destino,
                        p.getFecha_venta(),
                        p.getHora_venta(),
                        p.getPrecio()
                    });
                }
            }
        }

        if (vistaColectivoM != null) {
            vistaColectivoM.delHideWindow();
        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> jComboBox1;
    private javax.swing.JComboBox<Object> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
