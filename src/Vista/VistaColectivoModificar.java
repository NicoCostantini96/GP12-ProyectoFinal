package Vista;

import Modelo.Colectivo;
import static Vista.TestMain.colectivoData;
import static Vista.VistaMain.vistaMain;

public class VistaColectivoModificar extends javax.swing.JInternalFrame {

    public Colectivo colectivo = null;
    public int estate = 0;
    
    public VistaColectivoModificar() {
        initComponents();
    }
    
    public void start(int type) {
        if (type == 1) {
            lblTitulo.setText("AGREGAR COLECTIVO");
            txtMatricula.setText("");
            txtMarca.setText("");
            txtModelo.setText("");
            txtCapacidad.setText("");
            txtChofer.setText("");
        }else{
            lblTitulo.setText("MODIFICAR COLECTIVO");
            txtMatricula.setText(colectivo.getMatricula());
            txtMarca.setText(colectivo.getMarca());
            txtModelo.setText(colectivo.getModelo());
            txtCapacidad.setText(String.valueOf(colectivo.getCapacidad()));
            txtChofer.setText(colectivo.getChofer());
        }
        lblMsjMatricula.setText("");
        lblMsjMarca.setText("");
        lblMsjModelo.setText("");
        lblMsjCapacidad.setText("");
        lblMsjChofer.setText("");
        estate = type;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        pnlMatricula = new javax.swing.JPanel();
        pnlMatriculaInput = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        lblMatricula = new javax.swing.JLabel();
        lblMsjMatricula = new javax.swing.JLabel();
        pnlMarca = new javax.swing.JPanel();
        pnlMarcaInput = new javax.swing.JPanel();
        txtMarca = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        lblMsjMarca = new javax.swing.JLabel();
        pnlModelo = new javax.swing.JPanel();
        pnlModeloInput = new javax.swing.JPanel();
        txtModelo = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        lblMsjModelo = new javax.swing.JLabel();
        pnlCapacidad = new javax.swing.JPanel();
        pnlCapacidadInput = new javax.swing.JPanel();
        txtCapacidad = new javax.swing.JTextField();
        lblCapacidad = new javax.swing.JLabel();
        lblMsjCapacidad = new javax.swing.JLabel();
        pnlChofer = new javax.swing.JPanel();
        pnlChoferInput = new javax.swing.JPanel();
        txtChofer = new javax.swing.JTextField();
        lblChofer = new javax.swing.JLabel();
        lblMsjChofer = new javax.swing.JLabel();
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

        txtMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyReleased(evt);
            }
        });

        lblMatricula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMatricula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMatricula.setText("MATRICULA:");

        javax.swing.GroupLayout pnlMatriculaInputLayout = new javax.swing.GroupLayout(pnlMatriculaInput);
        pnlMatriculaInput.setLayout(pnlMatriculaInputLayout);
        pnlMatriculaInputLayout.setHorizontalGroup(
            pnlMatriculaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMatriculaInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlMatriculaInputLayout.setVerticalGroup(
            pnlMatriculaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMatriculaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMatricula))
        );

        lblMsjMatricula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjMatricula.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjMatricula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlMatriculaLayout = new javax.swing.GroupLayout(pnlMatricula);
        pnlMatricula.setLayout(pnlMatriculaLayout);
        pnlMatriculaLayout.setHorizontalGroup(
            pnlMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMatriculaInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMatriculaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlMatriculaLayout.setVerticalGroup(
            pnlMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMatriculaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlMatriculaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlMarcaInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtMarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMarcaKeyReleased(evt);
            }
        });

        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMarca.setText("MARCA:");

        javax.swing.GroupLayout pnlMarcaInputLayout = new javax.swing.GroupLayout(pnlMarcaInput);
        pnlMarcaInput.setLayout(pnlMarcaInputLayout);
        pnlMarcaInputLayout.setHorizontalGroup(
            pnlMarcaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMarcaInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlMarcaInputLayout.setVerticalGroup(
            pnlMarcaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMarcaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMarca))
        );

        lblMsjMarca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjMarca.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjMarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlMarcaLayout = new javax.swing.GroupLayout(pnlMarca);
        pnlMarca.setLayout(pnlMarcaLayout);
        pnlMarcaLayout.setHorizontalGroup(
            pnlMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMarcaInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMarcaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlMarcaLayout.setVerticalGroup(
            pnlMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMarcaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlMarcaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlModeloInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModeloKeyReleased(evt);
            }
        });

        lblModelo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblModelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModelo.setText("MODELO:");

        javax.swing.GroupLayout pnlModeloInputLayout = new javax.swing.GroupLayout(pnlModeloInput);
        pnlModeloInput.setLayout(pnlModeloInputLayout);
        pnlModeloInputLayout.setHorizontalGroup(
            pnlModeloInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlModeloInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlModeloInputLayout.setVerticalGroup(
            pnlModeloInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModeloInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblModelo))
        );

        lblMsjModelo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjModelo.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjModelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlModeloLayout = new javax.swing.GroupLayout(pnlModelo);
        pnlModelo.setLayout(pnlModeloLayout);
        pnlModeloLayout.setHorizontalGroup(
            pnlModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlModeloInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlModeloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlModeloLayout.setVerticalGroup(
            pnlModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModeloLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlModeloInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlCapacidadInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCapacidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCapacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCapacidadKeyReleased(evt);
            }
        });

        lblCapacidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCapacidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCapacidad.setText("CAPACIDAD:");

        javax.swing.GroupLayout pnlCapacidadInputLayout = new javax.swing.GroupLayout(pnlCapacidadInput);
        pnlCapacidadInput.setLayout(pnlCapacidadInputLayout);
        pnlCapacidadInputLayout.setHorizontalGroup(
            pnlCapacidadInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapacidadInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlCapacidadInputLayout.setVerticalGroup(
            pnlCapacidadInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapacidadInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblCapacidad))
        );

        lblMsjCapacidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjCapacidad.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjCapacidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlCapacidadLayout = new javax.swing.GroupLayout(pnlCapacidad);
        pnlCapacidad.setLayout(pnlCapacidadLayout);
        pnlCapacidadLayout.setHorizontalGroup(
            pnlCapacidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCapacidadInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapacidadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlCapacidadLayout.setVerticalGroup(
            pnlCapacidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapacidadLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlCapacidadInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlChoferInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtChofer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtChofer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtChoferKeyReleased(evt);
            }
        });

        lblChofer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblChofer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChofer.setText("CHOFER:");

        javax.swing.GroupLayout pnlChoferInputLayout = new javax.swing.GroupLayout(pnlChoferInput);
        pnlChoferInput.setLayout(pnlChoferInputLayout);
        pnlChoferInputLayout.setHorizontalGroup(
            pnlChoferInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChoferInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblChofer, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlChoferInputLayout.setVerticalGroup(
            pnlChoferInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChoferInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblChofer))
        );

        lblMsjChofer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjChofer.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjChofer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlChoferLayout = new javax.swing.GroupLayout(pnlChofer);
        pnlChofer.setLayout(pnlChoferLayout);
        pnlChoferLayout.setHorizontalGroup(
            pnlChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlChoferInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChoferLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlChoferLayout.setVerticalGroup(
            pnlChoferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChoferLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlChoferInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
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
                            .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
        if (txtMatricula.getText().length() < 1) {
            lblMsjMatricula.setText("Ingrese una matrícula!!");
        }
        if (txtMarca.getText().length() < 1) {
            lblMsjMarca.setText("Ingrese una marca!!");
        }
        if (txtModelo.getText().length() < 1) {
            lblMsjModelo.setText("Ingrese un modelo!!");
        }
        if (txtCapacidad.getText().length() < 1) {
            lblMsjCapacidad.setText("Ingrese la capacidad!!");
        }
        if (txtChofer.getText().length() < 1) {
            lblMsjChofer.setText("Ingrese un chofer!!");
        }
        
        if (
            lblMsjMatricula.getText().length() < 1 &&
            lblMsjMarca.getText().length() < 1 &&
            lblMsjModelo.getText().length() < 1 &&
            lblMsjCapacidad.getText().length() < 1 &&
            lblMsjChofer.getText().length() < 1
        ) {
            int id = (colectivo != null) ? colectivo.getId_colectivo() : 0;
            String matricula = txtMatricula.getText();
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            int capacidad = Integer.parseInt(txtCapacidad.getText());
            String chofer = txtChofer.getText();
            
            Colectivo c = new Colectivo(id,matricula,marca,modelo,capacidad,chofer,true);
            
            if (estate == 1) {
                colectivoData.insert(c);
                vistaMain.colectivo("INSERT",0);
            } else {
                colectivoData.update(c);
                vistaMain.colectivo("MODIFY",colectivo.getId_colectivo());
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyReleased
        String txt = txtMatricula.getText();
        lblMsjMatricula.setText("");
        if (txt.length() > 0) {
            if (!txt.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9 ]+")) {
                lblMsjModelo.setText("No se permiten símbolos!!");
            }else if (txt.length() != 7) {
                lblMsjMatricula.setText("Tienen que ser 7 caracteres!!!!");
            }
        }
    }//GEN-LAST:event_txtMatriculaKeyReleased

    private void txtMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyReleased
        String txt = txtMarca.getText();
        lblMsjMarca.setText("");
        if (txt.length() > 0) {
            if (txt.length() > 33) {
                lblMsjMarca.setText("Solo se permiten 33 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtMarcaKeyReleased

    private void txtModeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyReleased
        String txt = txtModelo.getText();
        lblMsjModelo.setText("");
        if (txt.length() > 0) {
            if (txt.length() > 33) {
                lblMsjModelo.setText("Solo se permiten 33 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtModeloKeyReleased

    private void txtCapacidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCapacidadKeyReleased
        String txt = txtCapacidad.getText();
        lblMsjCapacidad.setText("");
        if (txt.length() > 0) {
            if (!txt.matches("\\d+")) {
                lblMsjCapacidad.setText("Solo se permiten números!!");
            } else if (Integer.parseInt(txt) > 100) {
                lblMsjCapacidad.setText("Solo se permiten máximo 100 asientos!!");
            }
        }
    }//GEN-LAST:event_txtCapacidadKeyReleased

    private void txtChoferKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChoferKeyReleased
        String txt = txtChofer.getText();
        lblMsjChofer.setText("");
        if (txt.length() > 0) {
            if (!txt.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+")) {
                lblMsjChofer.setText("Solo se permiten letras!!");
            }else if (txt.length() > 33) {
                lblMsjChofer.setText("Solo se permiten 33 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtChoferKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel lblCapacidad;
    private javax.swing.JLabel lblChofer;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblMsjCapacidad;
    private javax.swing.JLabel lblMsjChofer;
    private javax.swing.JLabel lblMsjMarca;
    private javax.swing.JLabel lblMsjMatricula;
    private javax.swing.JLabel lblMsjModelo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlCapacidad;
    private javax.swing.JPanel pnlCapacidadInput;
    private javax.swing.JPanel pnlChofer;
    private javax.swing.JPanel pnlChoferInput;
    private javax.swing.JPanel pnlMarca;
    private javax.swing.JPanel pnlMarcaInput;
    private javax.swing.JPanel pnlMatricula;
    private javax.swing.JPanel pnlMatriculaInput;
    private javax.swing.JPanel pnlModelo;
    private javax.swing.JPanel pnlModeloInput;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtChofer;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables

    private void pasajeroConfig(String insert) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
