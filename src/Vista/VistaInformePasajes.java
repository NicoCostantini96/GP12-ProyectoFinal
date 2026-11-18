package Vista;

import Modelo.Pasaje;
import Modelo.Pasajero;
import static Vista.TestMain.pasajeData;
import static Vista.VistaMain.pasajeroData;
import static Vista.VistaMain.vistaColectivoM;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VistaInformePasajes extends javax.swing.JInternalFrame {

    private DefaultTableModel table;
    private List<Pasaje> tableList = new ArrayList<>();

    public VistaInformePasajes() {
        initComponents();
        armarTabla();
        cargarCombos();
        cmbPasajero.addActionListener(e -> actualizarTabla());
        cmbMes.addActionListener(e -> actualizarTabla());
    }

    private class PasajeroItem {

        private Pasajero pasajero;

        public PasajeroItem(Pasajero pasajero) {
            this.pasajero = pasajero;
        }

        public Pasajero getPasajero() {
            return pasajero;
        }

        @Override
        public String toString() {
            return pasajero.getNombre() + " " + pasajero.getApellido() + " (DNI: " + pasajero.getDni() + ")";
        }
    }

    private class MesItem {

        private int numero;
        private String nombre;

        public MesItem(int numero, String nombre) {
            this.numero = numero;
            this.nombre = nombre;
        }

        public int getNumero() {
            return numero;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    public void armarTabla() {

        String[] titulos = {"ID Pasaje", "Origen", "Destino", "Fecha de Venta", "Hora de Venta", "Precio"};

        table = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblInformePasajes.setModel(table);
    }

    private void cargarCombos() {
        cmbPasajero.removeAllItems();
        cmbMes.removeAllItems();
        
        ArrayList<Pasajero> pasajeros = pasajeroData.getList();
        
        for (Pasajero p : pasajeros) {
            cmbPasajero.addItem(new PasajeroItem(p));
        }

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (int i = 0; i < meses.length; i++) {
            cmbMes.addItem(new MesItem(i + 1, meses[i]));
        }

        // Carga inicial de la tabla si hay elementos
        if (cmbPasajero.getItemCount() > 0 && cmbMes.getItemCount() > 0) {
            actualizarTabla();
        }
    }

    public void actualizarTabla() {
        table.setRowCount(0);

        PasajeroItem itemPasajero = (PasajeroItem) cmbPasajero.getSelectedItem();
        MesItem itemMes = (MesItem) cmbMes.getSelectedItem();

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        lblPasajero = new javax.swing.JLabel();
        cmbPasajero = new javax.swing.JComboBox<>();
        lblMes = new javax.swing.JLabel();
        cmbMes = new javax.swing.JComboBox<>();
        scpListadoPasajes = new javax.swing.JScrollPane();
        tblInformePasajes = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Flecha Flash S.A.: Informes");

        pnlContenedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar pasajes por pasajero", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        lblPasajero.setText("Seleccione un pasajero:");

        lblMes.setText("Seleccione un mes:");

        tblInformePasajes.setModel(new javax.swing.table.DefaultTableModel(
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
        scpListadoPasajes.setViewportView(tblInformePasajes);

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addComponent(lblPasajero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addComponent(lblMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpListadoPasajes))
                .addContainerGap())
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasajero)
                    .addComponent(cmbPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMes)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scpListadoPasajes, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
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
    private javax.swing.JComboBox<MesItem> cmbMes;
    private javax.swing.JComboBox<PasajeroItem> cmbPasajero;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblPasajero;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JScrollPane scpListadoPasajes;
    private javax.swing.JTable tblInformePasajes;
    // End of variables declaration//GEN-END:variables
}
