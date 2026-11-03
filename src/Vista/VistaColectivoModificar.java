package Vista;

import Modelo.Colectivo;
import Modelo.Pasajero;
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
        lblMatricula.setText("");
        lblMarca.setText("");
        lblModelo.setText("");
        lblCapacidad.setText("");
        lblChofer.setText("");
        estate = type;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pnlDni2 = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        lblDni2 = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pnlDni4 = new javax.swing.JPanel();
        txtMarca = new javax.swing.JTextField();
        lblDni4 = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pnlDni5 = new javax.swing.JPanel();
        txtModelo = new javax.swing.JTextField();
        lblDni5 = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        pnlDni7 = new javax.swing.JPanel();
        txtCapacidad = new javax.swing.JTextField();
        lblDni7 = new javax.swing.JLabel();
        lblCapacidad = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        pnlDni8 = new javax.swing.JPanel();
        txtChofer = new javax.swing.JTextField();
        lblDni8 = new javax.swing.JLabel();
        lblChofer = new javax.swing.JLabel();
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

        pnlDni2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyReleased(evt);
            }
        });

        lblDni2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni2.setText("MATRICULA:");

        javax.swing.GroupLayout pnlDni2Layout = new javax.swing.GroupLayout(pnlDni2);
        pnlDni2.setLayout(pnlDni2Layout);
        pnlDni2Layout.setHorizontalGroup(
            pnlDni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDni2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDni2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlDni2Layout.setVerticalGroup(
            pnlDni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblDni2))
        );

        lblMatricula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMatricula.setForeground(new java.awt.Color(230, 0, 0));
        lblMatricula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDni2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDni2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlDni4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtMarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMarcaKeyReleased(evt);
            }
        });

        lblDni4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni4.setText("MARCA:");

        javax.swing.GroupLayout pnlDni4Layout = new javax.swing.GroupLayout(pnlDni4);
        pnlDni4.setLayout(pnlDni4Layout);
        pnlDni4Layout.setHorizontalGroup(
            pnlDni4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDni4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDni4, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlDni4Layout.setVerticalGroup(
            pnlDni4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDni4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblDni4))
        );

        lblMarca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(230, 0, 0));
        lblMarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDni4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDni4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlDni5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModeloKeyReleased(evt);
            }
        });

        lblDni5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni5.setText("MODELO:");

        javax.swing.GroupLayout pnlDni5Layout = new javax.swing.GroupLayout(pnlDni5);
        pnlDni5.setLayout(pnlDni5Layout);
        pnlDni5Layout.setHorizontalGroup(
            pnlDni5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDni5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDni5, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlDni5Layout.setVerticalGroup(
            pnlDni5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDni5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblDni5))
        );

        lblModelo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblModelo.setForeground(new java.awt.Color(230, 0, 0));
        lblModelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDni5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDni5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlDni7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCapacidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCapacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCapacidadKeyReleased(evt);
            }
        });

        lblDni7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni7.setText("CAPACIDAD:");

        javax.swing.GroupLayout pnlDni7Layout = new javax.swing.GroupLayout(pnlDni7);
        pnlDni7.setLayout(pnlDni7Layout);
        pnlDni7Layout.setHorizontalGroup(
            pnlDni7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDni7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDni7, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlDni7Layout.setVerticalGroup(
            pnlDni7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDni7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblDni7))
        );

        lblCapacidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCapacidad.setForeground(new java.awt.Color(230, 0, 0));
        lblCapacidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDni7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDni7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlDni8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtChofer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtChofer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtChoferKeyReleased(evt);
            }
        });

        lblDni8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni8.setText("CHOFER:");

        javax.swing.GroupLayout pnlDni8Layout = new javax.swing.GroupLayout(pnlDni8);
        pnlDni8.setLayout(pnlDni8Layout);
        pnlDni8Layout.setHorizontalGroup(
            pnlDni8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDni8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDni8, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlDni8Layout.setVerticalGroup(
            pnlDni8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDni8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblDni8))
        );

        lblChofer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblChofer.setForeground(new java.awt.Color(230, 0, 0));
        lblChofer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDni8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDni8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            lblMatricula.setText("Ingrese una matrícula!!");
        }
        if (txtMarca.getText().length() < 1) {
            lblMarca.setText("Ingrese una marca!!");
        }
        if (txtModelo.getText().length() < 1) {
            lblModelo.setText("Ingrese un modelo!!");
        }
        if (txtCapacidad.getText().length() < 1) {
            lblCapacidad.setText("Ingrese la capacidad!!");
        }
        if (txtChofer.getText().length() < 1) {
            lblChofer.setText("Ingrese un chofer!!");
        }
        
        if (
            lblMatricula.getText().length() < 1 &&
            lblMarca.getText().length() < 1 &&
            lblModelo.getText().length() < 1 &&
            lblCapacidad.getText().length() < 1 &&
            lblChofer.getText().length() < 1
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
                vistaMain.pasajero("INSERT",0);
            } else {
                colectivoData.update(c);
                vistaMain.colectivo("MODIFY",colectivo.getId_colectivo());
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyReleased
        String txt = txtMatricula.getText();
        lblMatricula.setText("");
        if (txt.length() > 0) {
            if (!txt.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9 ]+")) {
                lblModelo.setText("No se permiten símbolos!!");
            }else if (txt.length() != 7) {
                lblMatricula.setText("Tienen que ser 7 caracteres!!!!");
            }
        }
    }//GEN-LAST:event_txtMatriculaKeyReleased

    private void txtMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyReleased
        String txt = txtMarca.getText();
        lblMarca.setText("");
        if (txt.length() > 0) {
            if (txt.length() > 33) {
                lblMarca.setText("Solo se permiten 33 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtMarcaKeyReleased

    private void txtModeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyReleased
        String txt = txtModelo.getText();
        lblModelo.setText("");
        if (txt.length() > 0) {
            if (txt.length() > 33) {
                lblModelo.setText("Solo se permiten 33 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtModeloKeyReleased

    private void txtCapacidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCapacidadKeyReleased
        String txt = txtCapacidad.getText();
        lblCapacidad.setText("");
        if (txt.length() > 0) {
            if (!txt.matches("\\d+")) {
                lblCapacidad.setText("Solo se permiten números!!");
            } else if (Integer.parseInt(txt) > 100) {
                lblCapacidad.setText("Solo se permiten máximo 100 asientos!!");
            }
        }
    }//GEN-LAST:event_txtCapacidadKeyReleased

    private void txtChoferKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChoferKeyReleased
        String txt = txtChofer.getText();
        lblChofer.setText("");
        if (txt.length() > 0) {
            if (!txt.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+")) {
                lblChofer.setText("Solo se permiten letras!!");
            }else if (txt.length() > 33) {
                lblChofer.setText("Solo se permiten 33 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtChoferKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblCapacidad;
    private javax.swing.JLabel lblChofer;
    private javax.swing.JLabel lblDni2;
    private javax.swing.JLabel lblDni4;
    private javax.swing.JLabel lblDni5;
    private javax.swing.JLabel lblDni7;
    private javax.swing.JLabel lblDni8;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlDni2;
    private javax.swing.JPanel pnlDni4;
    private javax.swing.JPanel pnlDni5;
    private javax.swing.JPanel pnlDni7;
    private javax.swing.JPanel pnlDni8;
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
