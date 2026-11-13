package Vista;

import Modelo.Asiento;
import Modelo.Colectivo;
import Modelo.RutaViaje;
import static Vista.TestMain.asientoData;
import static Vista.TestMain.colectivoData;
import static Vista.VistaMain.viajeData;
import static Vista.VistaMain.vistaAsiento;
import static Vista.VistaMain.vistaMain;
import static Vista.VistaMain.vistaPasaje;
import java.util.ArrayList;

public class VistaAsientoModificar extends javax.swing.JInternalFrame {

    public Asiento asiento = null;
    public RutaViaje ruta = null;
    private ArrayList<RutaViaje> rutaList = new ArrayList<>();
    private boolean initChanges = false;
    public int estate = 0;
    
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
        btnCancelar = new javax.swing.JButton();
        pnlMatricula = new javax.swing.JPanel();
        pnlMatriculaInput = new javax.swing.JPanel();
        lblMatricula = new javax.swing.JLabel();
        cmbRuta = new javax.swing.JComboBox<>();
        pnlMarca = new javax.swing.JPanel();
        pnlMarcaInput = new javax.swing.JPanel();
        lblMarca = new javax.swing.JLabel();
        cmbAsiento = new javax.swing.JComboBox<>();
        btnConfirmar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

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

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        pnlMatriculaInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblMatricula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMatricula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMatricula.setText("VIAJE:");

        cmbRuta.addActionListener(this::cmbRutaActionPerformed);

        javax.swing.GroupLayout pnlMatriculaInputLayout = new javax.swing.GroupLayout(pnlMatriculaInput);
        pnlMatriculaInput.setLayout(pnlMatriculaInputLayout);
        pnlMatriculaInputLayout.setHorizontalGroup(
            pnlMatriculaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbRuta, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMatriculaInputLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMatriculaInputLayout.setVerticalGroup(
            pnlMatriculaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMatriculaInputLayout.createSequentialGroup()
                .addComponent(lblMatricula)
                .addGap(5, 5, 5)
                .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlMatriculaLayout = new javax.swing.GroupLayout(pnlMatricula);
        pnlMatricula.setLayout(pnlMatriculaLayout);
        pnlMatriculaLayout.setHorizontalGroup(
            pnlMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMatriculaInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMatriculaLayout.setVerticalGroup(
            pnlMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMatriculaInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMarcaInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMarca.setText("ASIENTO:");

        javax.swing.GroupLayout pnlMarcaInputLayout = new javax.swing.GroupLayout(pnlMarcaInput);
        pnlMarcaInput.setLayout(pnlMarcaInputLayout);
        pnlMarcaInputLayout.setHorizontalGroup(
            pnlMarcaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMarcaInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlMarcaInputLayout.setVerticalGroup(
            pnlMarcaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMarcaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblMarca)
                .addComponent(cmbAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlMarcaLayout = new javax.swing.GroupLayout(pnlMarca);
        pnlMarca.setLayout(pnlMarcaLayout);
        pnlMarcaLayout.setHorizontalGroup(
            pnlMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMarcaInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMarcaLayout.setVerticalGroup(
            pnlMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMarcaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlMarcaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

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
                            .addComponent(pnlMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(pnlMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        RutaViaje rutas = ruta;
        int nAsiento = Integer.parseInt(cmbAsiento.getSelectedItem().toString());
        
        Asiento a = new Asiento(id,ruta,nAsiento,true);

        if (estate == 1) {
            asientoData.insert(a);
            vistaAsiento.tableIndex = vistaAsiento.tableList.size();
        } else {
            asientoData.update(a);
            int index = -1;
            for (Asiento al : asientoData.getList()) {
                index++;
                if (al.getId_lugar() == id) {break;}
            }
            vistaAsiento.tableIndex = index;
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
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlMarca;
    private javax.swing.JPanel pnlMarcaInput;
    private javax.swing.JPanel pnlMatricula;
    private javax.swing.JPanel pnlMatriculaInput;
    private javax.swing.JPanel pnlTitulo;
    // End of variables declaration//GEN-END:variables

    private void pasajeroConfig(String insert) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
