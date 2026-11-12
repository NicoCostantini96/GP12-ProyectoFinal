package Vista;

import Modelo.Pasajero;
import static Vista.TestMain.pasajeroData;
import static Vista.VistaMain.vistaMain;
import static Vista.VistaMain.vistaPasajero;
import java.util.ArrayList;

public class VistaPasajeroModificar extends javax.swing.JInternalFrame {

    public Pasajero pasajero = null;
    public int estate = 0;
    
    public VistaPasajeroModificar() {
        initComponents();
    }
    
    public void start(int type) {
        if (type == 1) {
            lblTitulo.setText("AGREGAR PASAJERO");
            txtDni.setText("");
            txtNombre.setText("");
            txtApellido.setText("");
            txtCorreo.setText("");
            txtTelefono.setText("");
        }else{
            lblTitulo.setText("MODIFICAR PASAJERO");
            txtDni.setText(pasajero.getDni());
            txtNombre.setText(pasajero.getNombre());
            txtApellido.setText(pasajero.getApellido());
            txtCorreo.setText(pasajero.getCorreo());
            txtTelefono.setText(pasajero.getTelefono());
        }
        lblMsjDni.setText("");
        lblMsjNombre.setText("");
        lblMsjApellido.setText("");
        lblMsjCorreo.setText("");
        lblMsjTelefono.setText("");
        estate = type;
    }
    
    public void delHideWindow() {
        Pasajero p = null;
        if (pasajero != null) {p = pasajeroData.getById(pasajero.getId_pasajero());}
        if (p == null) {
            this.hide();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlDni = new javax.swing.JPanel();
        pnlDniInput = new javax.swing.JPanel();
        txtDni = new javax.swing.JTextField();
        lblDni = new javax.swing.JLabel();
        lblMsjDni = new javax.swing.JLabel();
        pnlNombre = new javax.swing.JPanel();
        pnlNombreInput = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblMsjNombre = new javax.swing.JLabel();
        pnlApellido = new javax.swing.JPanel();
        pnlApellidoInput = new javax.swing.JPanel();
        txtApellido = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        lblMsjApellido = new javax.swing.JLabel();
        pnlCorreo = new javax.swing.JPanel();
        pnlCorreoInput = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        lblMsjCorreo = new javax.swing.JLabel();
        pnlTelefono = new javax.swing.JPanel();
        pnlTelefonoInput = new javax.swing.JPanel();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblMsjTelefono = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        pnlTitulo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("TÍTULO");
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

        pnlDniInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
        });

        lblDni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni.setText("DNI:");

        javax.swing.GroupLayout pnlDniInputLayout = new javax.swing.GroupLayout(pnlDniInput);
        pnlDniInput.setLayout(pnlDniInputLayout);
        pnlDniInputLayout.setHorizontalGroup(
            pnlDniInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDniInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDni, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlDniInputLayout.setVerticalGroup(
            pnlDniInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDniInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblDni))
        );

        lblMsjDni.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjDni.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjDni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlDniLayout = new javax.swing.GroupLayout(pnlDni);
        pnlDni.setLayout(pnlDniLayout);
        pnlDniLayout.setHorizontalGroup(
            pnlDniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDniInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDniLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjDni, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlDniLayout.setVerticalGroup(
            pnlDniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDniLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDniInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjDni, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlNombreInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("NOMBRE:");

        javax.swing.GroupLayout pnlNombreInputLayout = new javax.swing.GroupLayout(pnlNombreInput);
        pnlNombreInput.setLayout(pnlNombreInputLayout);
        pnlNombreInputLayout.setHorizontalGroup(
            pnlNombreInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNombreInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlNombreInputLayout.setVerticalGroup(
            pnlNombreInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNombreInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNombre))
        );

        lblMsjNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjNombre.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlNombreLayout = new javax.swing.GroupLayout(pnlNombre);
        pnlNombre.setLayout(pnlNombreLayout);
        pnlNombreLayout.setHorizontalGroup(
            pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNombreInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNombreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlNombreLayout.setVerticalGroup(
            pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNombreLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlNombreInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlApellidoInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
        });

        lblApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellido.setText("APELLIDO:");

        javax.swing.GroupLayout pnlApellidoInputLayout = new javax.swing.GroupLayout(pnlApellidoInput);
        pnlApellidoInput.setLayout(pnlApellidoInputLayout);
        pnlApellidoInputLayout.setHorizontalGroup(
            pnlApellidoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlApellidoInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlApellidoInputLayout.setVerticalGroup(
            pnlApellidoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlApellidoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblApellido))
        );

        lblMsjApellido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjApellido.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlApellidoLayout = new javax.swing.GroupLayout(pnlApellido);
        pnlApellido.setLayout(pnlApellidoLayout);
        pnlApellidoLayout.setHorizontalGroup(
            pnlApellidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlApellidoInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlApellidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlApellidoLayout.setVerticalGroup(
            pnlApellidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlApellidoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlApellidoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlCorreoInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });

        lblCorreo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorreo.setText("CORREO:");

        javax.swing.GroupLayout pnlCorreoInputLayout = new javax.swing.GroupLayout(pnlCorreoInput);
        pnlCorreoInput.setLayout(pnlCorreoInputLayout);
        pnlCorreoInputLayout.setHorizontalGroup(
            pnlCorreoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCorreoInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlCorreoInputLayout.setVerticalGroup(
            pnlCorreoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCorreoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblCorreo))
        );

        lblMsjCorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjCorreo.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjCorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlCorreoLayout = new javax.swing.GroupLayout(pnlCorreo);
        pnlCorreo.setLayout(pnlCorreoLayout);
        pnlCorreoLayout.setHorizontalGroup(
            pnlCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCorreoInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCorreoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlCorreoLayout.setVerticalGroup(
            pnlCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCorreoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlCorreoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlTelefonoInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTelefono.setText("TELÉFONO:");

        javax.swing.GroupLayout pnlTelefonoInputLayout = new javax.swing.GroupLayout(pnlTelefonoInput);
        pnlTelefonoInput.setLayout(pnlTelefonoInputLayout);
        pnlTelefonoInputLayout.setHorizontalGroup(
            pnlTelefonoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelefonoInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlTelefonoInputLayout.setVerticalGroup(
            pnlTelefonoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelefonoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTelefono))
        );

        lblMsjTelefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjTelefono.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlTelefonoLayout = new javax.swing.GroupLayout(pnlTelefono);
        pnlTelefono.setLayout(pnlTelefonoLayout);
        pnlTelefonoLayout.setHorizontalGroup(
            pnlTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTelefonoInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelefonoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlTelefonoLayout.setVerticalGroup(
            pnlTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelefonoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlTelefonoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
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
                            .addComponent(pnlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
        if (txtDni.getText().length() < 1) {
            lblMsjDni.setText("Ingrese un dni!!");
        }
        if (txtNombre.getText().length() < 1) {
            lblMsjNombre.setText("Ingrese un nombre!!");
        }
        if (txtApellido.getText().length() < 1) {
            lblMsjApellido.setText("Ingrese un apellido!!");
        }
        if (txtCorreo.getText().length() < 1) {
            lblMsjCorreo.setText("Ingrese un correo!!");
        }
        if (txtTelefono.getText().length() < 1) {
            lblMsjTelefono.setText("Ingrese un teléfono!!");
        }
        
        if (
            lblMsjDni.getText().length() < 1 &&
            lblMsjNombre.getText().length() < 1 &&
            lblMsjApellido.getText().length() < 1 &&
            lblMsjCorreo.getText().length() < 1 &&
            lblMsjTelefono.getText().length() < 1
        ) {
            int id = (pasajero != null) ? pasajero.getId_pasajero() : 0;
            String dni = txtDni.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String correo = txtCorreo.getText();
            String telefono = txtTelefono.getText();
            
            Pasajero p = new Pasajero(id,dni,nombre,apellido,correo,telefono,true);
            
            if (estate == 1) {
                pasajeroData.insert(p);
                vistaPasajero.tableIndex = vistaPasajero.tableList.size();
            } else {
                pasajeroData.update(p);
                int index = -1;
                for (Pasajero pl : pasajeroData.getList()) {
                    index++;
                    if (pl.getId_pasajero() == id) {break;}
                }
                vistaPasajero.tableIndex = index;
            }
            vistaPasajero.updateAll();
            this.hide();
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        String txt = txtDni.getText();
        lblMsjDni.setText("");
        if (txt.length() > 0) {
            if (!txt.matches("\\d+")) {
                lblMsjDni.setText("Solo se permiten números!!");
            }else if (txt.length() != 8) {
                lblMsjDni.setText("Tienen que ser 8 caracteres!!");
            }else {
                ArrayList<Pasajero> pList = pasajeroData.SQL("SELECT * FROM pasajeros WHERE dni = "+txt+";");
                System.out.println(pList);
                if (!pList.isEmpty() && (pList.getFirst().getId_pasajero() != pasajero.getId_pasajero() || estate==1)) {
                    lblMsjDni.setText("Ese dni ya está en uso!!!!");
                }
            }
        }
    }//GEN-LAST:event_txtDniKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        String txt = txtNombre.getText();
        lblMsjNombre.setText("");
        if (txt.length() > 0) {
            if (!txt.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+")) {
                lblMsjNombre.setText("Solo se permiten letras!!");
            }else if (txt.length() > 33) {
                lblMsjNombre.setText("Solo se permiten 33 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        String txt = txtApellido.getText();
        lblMsjApellido.setText("");
        if (txt.length() > 0) {
            if (!txt.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+")) {
                lblMsjApellido.setText("Solo se permiten letras!!");
            }else if (txt.length() > 33) {
                lblMsjApellido.setText("Solo se permiten 33 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        String txt = txtCorreo.getText();
        lblMsjCorreo.setText("");
        if (txt.length() > 0) {
            if (!txt.matches("^[\\w.+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                lblMsjCorreo.setText("Ingrese un correo válido!!");
            }else if (txt.length() > 33) {
                lblMsjCorreo.setText("Solo se permiten 33 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        String txt = txtTelefono.getText();
        lblMsjTelefono.setText("");
        if (txt.length() > 0) {
            if (!txt.matches("\\d+")) {
                lblMsjTelefono.setText("Solo se permiten números!!");
            }else if (txt.length() != 10) {
                lblMsjTelefono.setText("Tienen que ser 10 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblMsjApellido;
    private javax.swing.JLabel lblMsjCorreo;
    private javax.swing.JLabel lblMsjDni;
    private javax.swing.JLabel lblMsjNombre;
    private javax.swing.JLabel lblMsjTelefono;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlApellido;
    private javax.swing.JPanel pnlApellidoInput;
    private javax.swing.JPanel pnlCorreo;
    private javax.swing.JPanel pnlCorreoInput;
    private javax.swing.JPanel pnlDni;
    private javax.swing.JPanel pnlDniInput;
    private javax.swing.JPanel pnlNombre;
    private javax.swing.JPanel pnlNombreInput;
    private javax.swing.JPanel pnlTelefono;
    private javax.swing.JPanel pnlTelefonoInput;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void pasajeroConfig(String insert) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
