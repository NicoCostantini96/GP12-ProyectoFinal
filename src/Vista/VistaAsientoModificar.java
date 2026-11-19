package Vista;

import Modelo.Asiento;
import Modelo.RutaViaje;
import static Vista.TestMain.asientoData;
import static Vista.VistaMain.viajeData;
import static Vista.VistaMain.vistaAsiento;
import static Vista.VistaMain.vistaPasaje;
import java.util.ArrayList;

public class VistaAsientoModificar extends javax.swing.JInternalFrame {

    private Asiento asiento = null;
    private RutaViaje ruta = null;
    private boolean initChanges = false;
    private int estate = 0;
    
    public VistaAsientoModificar() {
        initComponents();
    }
    
    public void start(int type) {
        estate = type;
        initChanges = false;
        
        var cmbRutaIndex = 0; cmbRuta.removeAllItems();
        for (RutaViaje r : viajeData.getList()) {
            cmbRuta.addItem(r.getColectivo().getMatricula() + " - (" + r.getOrigen() + " - " + r.getDestino() + ") - (" +r.getFecha_viaje()+ ") - (" + r.getHora_salida()+" - "+r.getHora_llegada()+")");
            if (estate == 2 && ruta.getId_ruta() == r.getId_ruta()) {
                cmbRutaIndex = cmbRuta.getItemCount() - 1;
            }
        }
        if (cmbRuta.getItemCount() > 0) {cmbRuta.setSelectedIndex(cmbRutaIndex);}
        if (estate == 1) {ruta = viajeData.getList().getFirst();}
        
        cmbAsientoUpdate();
        
        if (type == 1) {
            lblTitulo.setText("AGREGAR ASIENTO");
        }else{
            lblTitulo.setText("MODIFICAR ASIENTO");
        }
        
        initChanges = true;
    }
    
    public void delHideWindow() {
        Asiento a = null;
        if (asiento != null) {a = asientoData.getById(asiento.getId_lugar());}
        if (a == null) {
            this.hide();
        }
    }
    
    private void cmbAsientoUpdate() {
        int asientoIndex = 0;
        cmbAsiento.removeAllItems();
        for (int i = 0; i < ruta.getColectivo().getCapacidad(); i++) {
            boolean me = (estate == 2 && asiento.getNumero_asiento() == i+1);
            ArrayList<Asiento> ocupado = new ArrayList<>();
            if (ruta != null) {ocupado = asientoData.SQL("SELECT * FROM `lugares` JOIN rutas ON rutas.id_ruta = lugares.id_ruta WHERE rutas.id_ruta = "+ruta.getId_ruta()+" and lugares.numero_asiento = "+(i+1)+";");}
            if (ocupado.isEmpty() || me) {
                cmbAsiento.addItem(String.valueOf(i+1));
                if (me) {asientoIndex = cmbAsiento.getItemCount() - 1;}
            }
        }
        if (cmbAsiento.getItemCount() > 0) {cmbAsiento.setSelectedIndex(asientoIndex);}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlRuta = new javax.swing.JPanel();
        pnlRutaInput = new javax.swing.JPanel();
        lblRuta = new javax.swing.JLabel();
        cmbRuta = new javax.swing.JComboBox<>();
        pnlAsiento = new javax.swing.JPanel();
        pnlAsientoInput = new javax.swing.JPanel();
        lblAsiento = new javax.swing.JLabel();
        cmbAsiento = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Flecha Flash S.A.: Asientos");

        pnlTitulo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("TITULO");
        lblTitulo.setToolTipText("");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pnlRutaInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblRuta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRuta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRuta.setText("VIAJE:");

        cmbRuta.addActionListener(this::cmbRutaActionPerformed);

        javax.swing.GroupLayout pnlRutaInputLayout = new javax.swing.GroupLayout(pnlRutaInput);
        pnlRutaInput.setLayout(pnlRutaInputLayout);
        pnlRutaInputLayout.setHorizontalGroup(
            pnlRutaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbRuta, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRutaInputLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlRutaInputLayout.setVerticalGroup(
            pnlRutaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRutaInputLayout.createSequentialGroup()
                .addComponent(lblRuta)
                .addGap(5, 5, 5)
                .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlRutaLayout = new javax.swing.GroupLayout(pnlRuta);
        pnlRuta.setLayout(pnlRutaLayout);
        pnlRutaLayout.setHorizontalGroup(
            pnlRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRutaInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlRutaLayout.setVerticalGroup(
            pnlRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRutaInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlAsientoInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAsiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAsiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAsiento.setText("ASIENTO:");

        javax.swing.GroupLayout pnlAsientoInputLayout = new javax.swing.GroupLayout(pnlAsientoInput);
        pnlAsientoInput.setLayout(pnlAsientoInputLayout);
        pnlAsientoInputLayout.setHorizontalGroup(
            pnlAsientoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAsientoInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblAsiento, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlAsientoInputLayout.setVerticalGroup(
            pnlAsientoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsientoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblAsiento)
                .addComponent(cmbAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlAsientoLayout = new javax.swing.GroupLayout(pnlAsiento);
        pnlAsiento.setLayout(pnlAsientoLayout);
        pnlAsientoLayout.setHorizontalGroup(
            pnlAsientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAsientoInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlAsientoLayout.setVerticalGroup(
            pnlAsientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsientoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlAsientoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(this::btnConfirmarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(pnlAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnConfirmar))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.hide();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int id = (asiento != null) ? asiento.getId_lugar() : 0;
        int nAsiento = Integer.parseInt(cmbAsiento.getSelectedItem().toString());
        
        Asiento a = new Asiento(id,ruta,nAsiento,true);

        if (estate == 1) {
            asientoData.insert(a);
            vistaAsiento.setTableIndex(vistaAsiento.getTableList().size());
        } else {
            asientoData.update(a);
            int index = -1;
            for (Asiento al : asientoData.getList()) {
                index++;
                if (al.getId_lugar() == id) {break;}
            }
            vistaAsiento.setTableIndex(index);
        }
        vistaAsiento.updateAll(); vistaPasaje.updateAll();
        this.hide();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void cmbRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRutaActionPerformed
        if (initChanges && cmbRuta.getSelectedIndex() >= 0) {
            ruta = viajeData.getList().get(cmbRuta.getSelectedIndex());
            cmbAsientoUpdate();
        }
    }//GEN-LAST:event_cmbRutaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbAsiento;
    private javax.swing.JComboBox<String> cmbRuta;
    private javax.swing.JLabel lblAsiento;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAsiento;
    private javax.swing.JPanel pnlAsientoInput;
    private javax.swing.JPanel pnlRuta;
    private javax.swing.JPanel pnlRutaInput;
    private javax.swing.JPanel pnlTitulo;
    // End of variables declaration//GEN-END:variables

    private void pasajeroConfig(String insert) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
