package Vista;

import Modelo.Asiento;
import Modelo.Pasaje;
import Modelo.Pasajero;
import Modelo.RutaViaje;
import static Vista.TestMain.asientoData;
import static Vista.TestMain.pasajeData;
import static Vista.TestMain.pasajeroData;
import static Vista.VistaMain.viajeData;
import static Vista.VistaMain.vistaMain;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class VistaPasajeModificar extends javax.swing.JInternalFrame {

    public Pasaje pasaje = null;
    private LocalTime hVenta = LocalTime.of(0,0,0);
    private RutaViaje ruta = null;
    private Pasajero pasajero = null;
    private int asientoIndex = 0;
    public int estate = 0;
    
    public VistaPasajeModificar() {
        initComponents();
    }
    
    public void start(int type) {
        estate = type;
        
       var cmbPasajeroIndex = 0; cmbPasajero.removeAllItems();
        for (Pasajero p : pasajeroData.getList()) {
            cmbPasajero.addItem(p.getDni() + " " + p.getNombre() + " " + p.getApellido());
            if (estate == 2 && pasaje.getPasajero().getId_pasajero() == p.getId_pasajero()) {
                cmbPasajeroIndex = cmbPasajero.getItemCount() - 1;
            }
        }
        if (cmbPasajero.getItemCount() > 0) {cmbPasajero.setSelectedIndex(cmbPasajeroIndex);}
        
        boolean rutaEnd = false;
        int rutaIndex = -1;
        cmbRuta.removeAllItems();
        for (RutaViaje r : viajeData.getList()) {
            cmbRuta.addItem(r.getOrigen() + " - " + r.getDestino() + " - " + r.getColectivo().getMatricula() + " - " + r.getHora_salida());
            if (!rutaEnd) {
                rutaIndex++;
                if (estate == 2) {
                    if (pasaje.getRuta().getId_ruta() == r.getId_ruta()) {rutaEnd = true;}
                }else{
                    rutaIndex = 0;
                }
            }
        }
        cmbRuta.setSelectedIndex(rutaIndex);
        
        cmbUpdate();
        
        if (estate == 1) {
            lblTitulo.setText("AGREGAR PASAJE");
            dateFVenta.setDate(java.sql.Date.valueOf(LocalDate.now()));
            txtHVenta.setText("");
            txtPrecio.setText("");
        }else{
            lblTitulo.setText("MODIFICAR PASAJE");
            dateFVenta.setDate(java.sql.Date.valueOf(pasaje.getFecha_venta()));
            txtHVenta.setText(String.valueOf(pasaje.getHora_venta()));
            txtPrecio.setText(String.valueOf(pasaje.getPrecio()));
        }
        
        lblMsjFVenta.setText("");
        lblMsjHVenta.setText("");
    }
    
    private void cmbUpdate() {
        if (cmbRuta.getSelectedIndex() >= 0) {
            ruta = viajeData.getList().get(cmbRuta.getSelectedIndex());
            if (ruta != null) {
                asientoIndex = 0;
                cmbAsiento.removeAllItems();
                for (int i = 0; i < ruta.getColectivo().getCapacidad(); i++) {
                    boolean me = (estate == 2 && pasaje.getLugar().getNumero_asiento() == i+1);
                    ArrayList<Asiento> ocupado = asientoData.SQL("SELECT * FROM `lugares` WHERE id_colectivo = "+ruta.getColectivo().getId_colectivo()+" and numero_asiento = "+i+1+";");
                    if (!ocupado.isEmpty() && !me) {continue;}
                    cmbAsiento.addItem(String.valueOf(i+1));
                    if (me) {asientoIndex = cmbAsiento.getItemCount() - 1;}
                }
                cmbAsiento.setSelectedIndex(asientoIndex);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlDni = new javax.swing.JPanel();
        pnlDniInput = new javax.swing.JPanel();
        lblDni = new javax.swing.JLabel();
        cmbPasajero = new javax.swing.JComboBox<>();
        pnlNombre = new javax.swing.JPanel();
        pnlNombreInput = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        cmbAsiento = new javax.swing.JComboBox<>();
        pnlApellido = new javax.swing.JPanel();
        pnlApellidoInput = new javax.swing.JPanel();
        lblApellido = new javax.swing.JLabel();
        cmbRuta = new javax.swing.JComboBox<>();
        pnlCorreo = new javax.swing.JPanel();
        pnlCorreoInput = new javax.swing.JPanel();
        lblCorreo = new javax.swing.JLabel();
        dateFVenta = new com.toedter.calendar.JDateChooser();
        lblMsjFVenta = new javax.swing.JLabel();
        pnlTelefono = new javax.swing.JPanel();
        pnlTelefonoInput = new javax.swing.JPanel();
        txtHVenta = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblMsjHVenta = new javax.swing.JLabel();
        lblMsjPrecio = new javax.swing.JLabel();
        pnlTelefonoInput1 = new javax.swing.JPanel();
        txtPrecio = new javax.swing.JTextField();
        lblTelefono1 = new javax.swing.JLabel();
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

        lblDni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni.setText("PSAJERO:");

        cmbPasajero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPasajero.addActionListener(this::cmbPasajeroActionPerformed);

        javax.swing.GroupLayout pnlDniInputLayout = new javax.swing.GroupLayout(pnlDniInput);
        pnlDniInput.setLayout(pnlDniInputLayout);
        pnlDniInputLayout.setHorizontalGroup(
            pnlDniInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDniInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDni, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDniInputLayout.setVerticalGroup(
            pnlDniInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDniInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblDni)
                .addComponent(cmbPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlDniLayout = new javax.swing.GroupLayout(pnlDni);
        pnlDni.setLayout(pnlDniLayout);
        pnlDniLayout.setHorizontalGroup(
            pnlDniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDniInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDniLayout.setVerticalGroup(
            pnlDniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDniLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDniInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pnlNombreInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("ASIENTO:");

        cmbAsiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlNombreInputLayout = new javax.swing.GroupLayout(pnlNombreInput);
        pnlNombreInput.setLayout(pnlNombreInputLayout);
        pnlNombreInputLayout.setHorizontalGroup(
            pnlNombreInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNombreInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlNombreInputLayout.setVerticalGroup(
            pnlNombreInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNombreInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNombre)
                .addComponent(cmbAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlNombreLayout = new javax.swing.GroupLayout(pnlNombre);
        pnlNombre.setLayout(pnlNombreLayout);
        pnlNombreLayout.setHorizontalGroup(
            pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNombreInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlNombreLayout.setVerticalGroup(
            pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNombreLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlNombreInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pnlApellidoInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellido.setText("RUTA:");

        cmbRuta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbRuta.addActionListener(this::cmbRutaActionPerformed);

        javax.swing.GroupLayout pnlApellidoInputLayout = new javax.swing.GroupLayout(pnlApellidoInput);
        pnlApellidoInput.setLayout(pnlApellidoInputLayout);
        pnlApellidoInputLayout.setHorizontalGroup(
            pnlApellidoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlApellidoInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlApellidoInputLayout.setVerticalGroup(
            pnlApellidoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlApellidoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblApellido)
                .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlApellidoLayout = new javax.swing.GroupLayout(pnlApellido);
        pnlApellido.setLayout(pnlApellidoLayout);
        pnlApellidoLayout.setHorizontalGroup(
            pnlApellidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlApellidoInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlApellidoLayout.setVerticalGroup(
            pnlApellidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlApellidoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlApellidoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pnlCorreoInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCorreo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorreo.setText("FECHA VENTA:");

        javax.swing.GroupLayout pnlCorreoInputLayout = new javax.swing.GroupLayout(pnlCorreoInput);
        pnlCorreoInput.setLayout(pnlCorreoInputLayout);
        pnlCorreoInputLayout.setHorizontalGroup(
            pnlCorreoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCorreoInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateFVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlCorreoInputLayout.setVerticalGroup(
            pnlCorreoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(lblCorreo)
            .addComponent(dateFVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblMsjFVenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjFVenta.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjFVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlCorreoLayout = new javax.swing.GroupLayout(pnlCorreo);
        pnlCorreo.setLayout(pnlCorreoLayout);
        pnlCorreoLayout.setHorizontalGroup(
            pnlCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCorreoInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCorreoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjFVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlCorreoLayout.setVerticalGroup(
            pnlCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCorreoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlCorreoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjFVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlTelefonoInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtHVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHVentaKeyReleased(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTelefono.setText("HORA VENTA:");

        javax.swing.GroupLayout pnlTelefonoInputLayout = new javax.swing.GroupLayout(pnlTelefonoInput);
        pnlTelefonoInput.setLayout(pnlTelefonoInputLayout);
        pnlTelefonoInputLayout.setHorizontalGroup(
            pnlTelefonoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelefonoInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtHVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlTelefonoInputLayout.setVerticalGroup(
            pnlTelefonoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelefonoInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtHVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTelefono))
        );

        lblMsjHVenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjHVenta.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjHVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblMsjPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjPrecio.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        pnlTelefonoInput1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
        });

        lblTelefono1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefono1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTelefono1.setText("PRECIO:");

        javax.swing.GroupLayout pnlTelefonoInput1Layout = new javax.swing.GroupLayout(pnlTelefonoInput1);
        pnlTelefonoInput1.setLayout(pnlTelefonoInput1Layout);
        pnlTelefonoInput1Layout.setHorizontalGroup(
            pnlTelefonoInput1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelefonoInput1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblTelefono1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlTelefonoInput1Layout.setVerticalGroup(
            pnlTelefonoInput1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelefonoInput1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTelefono1))
        );

        javax.swing.GroupLayout pnlTelefonoLayout = new javax.swing.GroupLayout(pnlTelefono);
        pnlTelefono.setLayout(pnlTelefonoLayout);
        pnlTelefonoLayout.setHorizontalGroup(
            pnlTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTelefonoInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTelefonoInput1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelefonoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMsjHVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMsjPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
        pnlTelefonoLayout.setVerticalGroup(
            pnlTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelefonoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlTelefonoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjHVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlTelefonoInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnlTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
        if (txtHVenta.getText().length() < 1) {
            lblMsjHVenta.setText("Ingrese una hora!!");
        }
        if (txtPrecio.getText().length() < 1) {
            lblMsjPrecio.setText("Ingrese un precio!!");
        }
        
        if (
            lblMsjFVenta.getText().length() < 1 &&
            lblMsjHVenta.getText().length() < 1 &&
            lblMsjPrecio.getText().length() < 1
        ) {
            int id = (pasaje != null) ? pasaje.getId_pasaje() : 0;
            Asiento asiento = (pasaje != null) ? pasaje.getLugar() : new Asiento(0,ruta,asientoIndex,true);
            //Asiento asiento = pasaje.getLugar();
            LocalDate fVenta = dateFVenta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            double precio = Double.parseDouble(txtPrecio.getText());
            
            Pasaje p = new Pasaje(id,pasajero,asiento,ruta,fVenta,hVenta,precio,true);
            
            if (estate == 1) {
                pasajeData.insert(p);
                vistaMain.pasaje("INSERT",id);
            } else {
                pasajeData.update(p);
                vistaMain.pasaje("MODIFY",pasaje.getId_pasaje());
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtHVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHVentaKeyReleased
        String txt = txtHVenta.getText();
        lblMsjHVenta.setText("");
        if (txt.length() > 0) {
            try {
                String[] hsplit = txt.split(":");
                int h = (hsplit.length > 0) ? Integer.parseInt(hsplit[0]) : 0;
                int m = (hsplit.length > 1) ? Integer.parseInt(hsplit[1]) : 0;
                int s = (hsplit.length > 2) ? Integer.parseInt(hsplit[2]) : 0;
                if (hsplit.length > 3) {throw new Exception();}
                hVenta = LocalTime.of(h, m, s);
            } catch (Exception e) {
                lblMsjHVenta.setText("Ingrese una hora válida!!");
            }
        }
    }//GEN-LAST:event_txtHVentaKeyReleased

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        String txt = txtPrecio.getText();
        lblMsjPrecio.setText("");
        if (txt.length() > 0) {
            try {
                double precio = Double.parseDouble(txt);
            }catch(Exception e) {
                lblMsjPrecio.setText("Ingrese un precio válido!!");
            }
        }
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void cmbRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRutaActionPerformed
        cmbUpdate();
    }//GEN-LAST:event_cmbRutaActionPerformed

    private void cmbPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPasajeroActionPerformed
        if (cmbPasajero.getSelectedIndex() >= 0) {
            pasajero = pasajeroData.getList().get(cmbPasajero.getSelectedIndex());
        }
    }//GEN-LAST:event_cmbPasajeroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbAsiento;
    private javax.swing.JComboBox<String> cmbPasajero;
    private javax.swing.JComboBox<String> cmbRuta;
    private com.toedter.calendar.JDateChooser dateFVenta;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblMsjFVenta;
    private javax.swing.JLabel lblMsjHVenta;
    private javax.swing.JLabel lblMsjPrecio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
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
    private javax.swing.JPanel pnlTelefonoInput1;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTextField txtHVenta;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void pasajeroConfig(String insert) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
