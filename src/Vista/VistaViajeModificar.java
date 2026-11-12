package Vista;

import Modelo.Colectivo;
import Modelo.Pasajero;
import Modelo.RutaViaje;
import static Vista.TestMain.colectivoData;
import static Vista.TestMain.pasajeroData;
import static Vista.VistaMain.viajeData;
import static Vista.VistaMain.vistaMain;
import static Vista.VistaMain.vistaViaje;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;

public class VistaViajeModificar extends javax.swing.JInternalFrame {

    public ArrayList<Colectivo> cmbList = new ArrayList<>();
    public int cmbIndex = 0;
    public RutaViaje ruta = null;
    public int estate = 0;
    private LocalTime hsalida = LocalTime.of(0, 0, 0);
    private LocalTime hllegada = LocalTime.of(0, 0, 0);
    private LocalDate fechaViaje;

    public VistaViajeModificar() {
        initComponents();
    }

    public void update() {
        var end = false;
        cmbIndex = 0;
        cmbColectivo.removeAllItems();
        cmbList.clear();
        for (Colectivo c : colectivoData.getList()) {
            cmbColectivo.addItem(c.getMatricula() + " - " + c.getMarca() + " - " + c.getModelo());
            cmbList.add(c);
            if (estate == 2 && ruta.getColectivo().getId_colectivo() == c.getId_colectivo()) {
                end = true;
            }
            if (!end) {
                cmbIndex++;
            }
        }
        if (estate == 1) {
            cmbIndex = 0;
        }
        cmbColectivo.setSelectedIndex(cmbIndex);
    }

    public void start(int type) {
        if (type == 1) {
            lblTitulo.setText("AGREGAR RUTA");
            txtOrigen.setText("");
            txtDestino.setText("");
            txtHSalida.setText("");
            txtHLlegada.setText("");
            txtPrecio.setText("");
        } else {
            lblTitulo.setText("MODIFICAR RUTA");
            txtOrigen.setText(ruta.getOrigen());
            txtDestino.setText(ruta.getDestino());
            txtHSalida.setText(String.valueOf(ruta.getHora_salida()));
            txtHLlegada.setText(String.valueOf(ruta.getHora_llegada()));
            txtPrecio.setText(String.valueOf(ruta.getPrecio()));
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu");
            dateFViaje.setDate(java.sql.Date.valueOf(ruta.getFecha_viaje()));
        }
        lblOrigen.setText("");
        lblDestino.setText("");
        lblHoras.setText("");
        lblHoras.setText("");
        lblPrecio.setText("");
        estate = type;
        update();
    }

    public void delHideWindow() {
        RutaViaje r = null;
        if (ruta != null) {r = viajeData.getById(ruta.getId_ruta());}
        if (r == null) {
            this.hide();
        }
    }
    
    public void hVerify() {
        lblHoras.setText("");
        int errors = 0;
        for (int i = 0; i < 2; i++) {
            String type = "salida";
            String txt = txtHSalida.getText();
            if (i == 1) {
                type = "llegada";
                txt = txtHLlegada.getText();
            }
            if (txt.length() > 0) {
                try {
                    String[] hsplit = txt.split(":");
                    int h = (hsplit.length > 0) ? Integer.parseInt(hsplit[0]) : 0;
                    int m = (hsplit.length > 1) ? Integer.parseInt(hsplit[1]) : 0;
                    int s = (hsplit.length > 2) ? Integer.parseInt(hsplit[2]) : 0;
                    if (hsplit.length > 3) {
                        throw new Exception();
                    }
                    if (i == 0) {
                        hsalida = LocalTime.of(h, m, s);
                    } else {
                        hllegada = LocalTime.of(h, m, s);
                    }
                } catch (Exception e) {
                    String connect = lblHoras.getText().isEmpty() ? "" : " y ";
                    lblHoras.setText(lblHoras.getText() + connect + "hora de " + type);
                    errors++;
                }
            }
        }
        if (!lblHoras.getText().isEmpty()) {
            String error = "inválida";
            if (errors >= 2) {
                error = "inválidos";
            }
            lblHoras.setText(lblHoras.getText() + " " + error + "!!");
        }
    }

    public void fVerify() {
        try {
            DateTimeFormatter formato = DateTimeFormatter
                    .ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

            fechaViaje = dateFViaje.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            if (fechaViaje.isBefore(LocalDate.now())) {
                lblFViaje.setText("La fecha no puede ser anterior a hoy!!");
            }

        } catch (DateTimeParseException e) {
            lblFViaje.setText("Ingrese una fecha válida (dd/MM/yyyy)!!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pnlDni2 = new javax.swing.JPanel();
        txtOrigen = new javax.swing.JTextField();
        lblDni2 = new javax.swing.JLabel();
        lblOrigen = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pnlDni4 = new javax.swing.JPanel();
        txtDestino = new javax.swing.JTextField();
        lblDni4 = new javax.swing.JLabel();
        lblDestino = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pnlDni5 = new javax.swing.JPanel();
        txtHSalida = new javax.swing.JTextField();
        lblDni5 = new javax.swing.JLabel();
        lblDni6 = new javax.swing.JLabel();
        txtHLlegada = new javax.swing.JTextField();
        lblHoras = new javax.swing.JLabel();
        pnlDni9 = new javax.swing.JPanel();
        lblDni9 = new javax.swing.JLabel();
        dateFViaje = new com.toedter.calendar.JDateChooser();
        lblFViaje = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        pnlDni7 = new javax.swing.JPanel();
        lblDni7 = new javax.swing.JLabel();
        cmbColectivo = new javax.swing.JComboBox<>();
        lblColectivo = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        pnlDni8 = new javax.swing.JPanel();
        txtPrecio = new javax.swing.JTextField();
        lblDni8 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
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

        txtOrigen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOrigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOrigenKeyReleased(evt);
            }
        });

        lblDni2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni2.setText("ORIGEN:");

        javax.swing.GroupLayout pnlDni2Layout = new javax.swing.GroupLayout(pnlDni2);
        pnlDni2.setLayout(pnlDni2Layout);
        pnlDni2Layout.setHorizontalGroup(
            pnlDni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDni2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDni2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlDni2Layout.setVerticalGroup(
            pnlDni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblDni2))
        );

        lblOrigen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblOrigen.setForeground(new java.awt.Color(230, 0, 0));
        lblOrigen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDni2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDni2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlDni4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtDestino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDestinoKeyReleased(evt);
            }
        });

        lblDni4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni4.setText("DESTINO:");

        javax.swing.GroupLayout pnlDni4Layout = new javax.swing.GroupLayout(pnlDni4);
        pnlDni4.setLayout(pnlDni4Layout);
        pnlDni4Layout.setHorizontalGroup(
            pnlDni4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDni4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDni4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlDni4Layout.setVerticalGroup(
            pnlDni4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDni4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblDni4))
        );

        lblDestino.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDestino.setForeground(new java.awt.Color(230, 0, 0));
        lblDestino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDni4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDni4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlDni5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtHSalida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHSalidaKeyReleased(evt);
            }
        });

        lblDni5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni5.setText("HORA SALIDA:");

        lblDni6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni6.setText("HORA LLEGADA:");

        txtHLlegada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHLlegada.addActionListener(this::txtHLlegadaActionPerformed);
        txtHLlegada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHLlegadaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlDni5Layout = new javax.swing.GroupLayout(pnlDni5);
        pnlDni5.setLayout(pnlDni5Layout);
        pnlDni5Layout.setHorizontalGroup(
            pnlDni5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDni5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDni5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDni6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtHLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDni5Layout.setVerticalGroup(
            pnlDni5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDni5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblDni5)
                .addComponent(lblDni6)
                .addComponent(txtHLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblHoras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblHoras.setForeground(new java.awt.Color(230, 0, 0));
        lblHoras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        pnlDni9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDni9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni9.setText("FECHA VIAJE");

        javax.swing.GroupLayout pnlDni9Layout = new javax.swing.GroupLayout(pnlDni9);
        pnlDni9.setLayout(pnlDni9Layout);
        pnlDni9Layout.setHorizontalGroup(
            pnlDni9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDni9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDni9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateFViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlDni9Layout.setVerticalGroup(
            pnlDni9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDni9)
            .addGroup(pnlDni9Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(dateFViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblFViaje.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFViaje.setForeground(new java.awt.Color(230, 0, 0));
        lblFViaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDni5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlDni9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDni5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlDni9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblFViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlDni7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDni7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni7.setText("COLECTIVO:");

        cmbColectivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbColectivo.addActionListener(this::cmbColectivoActionPerformed);

        javax.swing.GroupLayout pnlDni7Layout = new javax.swing.GroupLayout(pnlDni7);
        pnlDni7.setLayout(pnlDni7Layout);
        pnlDni7Layout.setHorizontalGroup(
            pnlDni7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDni7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDni7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(cmbColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDni7Layout.setVerticalGroup(
            pnlDni7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDni7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblDni7)
                .addComponent(cmbColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblColectivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblColectivo.setForeground(new java.awt.Color(230, 0, 0));
        lblColectivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDni7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDni7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlDni8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
        });

        lblDni8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDni8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDni8.setText("PRECIO:");

        javax.swing.GroupLayout pnlDni8Layout = new javax.swing.GroupLayout(pnlDni8);
        pnlDni8.setLayout(pnlDni8Layout);
        pnlDni8Layout.setHorizontalGroup(
            pnlDni8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDni8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDni8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlDni8Layout.setVerticalGroup(
            pnlDni8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDni8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblDni8))
        );

        lblPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(230, 0, 0));
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDni8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDni8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(this::btnConfirmarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.hide();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        fVerify();

        if (txtOrigen.getText().length() < 1) {
            lblOrigen.setText("Ingrese un origen!!");
        }
        if (txtDestino.getText().length() < 1) {
            lblDestino.setText("Ingrese un destino!!");
        }
        int her = 0;
        if (txtHSalida.getText().length() < 1) {
            lblHoras.setText("ingrese una hora de salida!!");
            her++;
        }
        if (txtHLlegada.getText().length() < 1) {
            lblHoras.setText("Ingrese una hora de llegada!!");
            her++;
        }

        if (her >= 2) {
            lblHoras.setText("Ingrese una hora de salida y de llegada!!");
        }
        if (txtPrecio.getText().length() < 1) {
            lblPrecio.setText("Ingrese un precio!!");
        }

        if (lblOrigen.getText().length() < 1
                && lblDestino.getText().length() < 1
                && lblHoras.getText().length() < 1
                && lblFViaje.getText().length() < 1
                && lblPrecio.getText().length() < 1) {
            int id = (ruta != null) ? ruta.getId_ruta() : 0;
            String origen = txtOrigen.getText();
            String destino = txtDestino.getText();
            double precio = Double.parseDouble(txtPrecio.getText());

            RutaViaje r = new RutaViaje(id, origen, destino, fechaViaje, hsalida, hllegada, cmbList.get(cmbIndex), precio, true);

            if (estate == 1) {
                viajeData.insert(r);
                vistaViaje.tableIndex = vistaViaje.tableList.size();
            } else {
                viajeData.update(r);
                int index = -1;
                for (RutaViaje rl : viajeData.getList()) {
                    index++;
                    if (rl.getId_ruta() == id) {break;}
                }
                vistaViaje.tableIndex = index;
            }
            vistaViaje.updateAll();
            this.hide();
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtOrigenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrigenKeyReleased
        String txt = txtOrigen.getText();
        lblOrigen.setText("");
        if (txt.length() > 0) {
            if (txt.length() > 33) {
                lblOrigen.setText("Solo se permiten 33 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtOrigenKeyReleased

    private void txtDestinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDestinoKeyReleased
        String txt = txtDestino.getText();
        lblDestino.setText("");
        if (txt.length() > 0) {
            if (txt.length() > 33) {
                lblDestino.setText("Solo se permiten 33 caracteres!!");
            }
        }
    }//GEN-LAST:event_txtDestinoKeyReleased

    private void txtHSalidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHSalidaKeyReleased
        hVerify();
    }//GEN-LAST:event_txtHSalidaKeyReleased

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        String txt = txtPrecio.getText();
        lblPrecio.setText("");
        if (txt.length() > 0) {
            try {
                double precio = Double.parseDouble(txt);
            } catch (Exception e) {
                lblPrecio.setText("Ingrese un precio válido!!");
            }
        }
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void txtHLlegadaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHLlegadaKeyReleased
        hVerify();
    }//GEN-LAST:event_txtHLlegadaKeyReleased

    private void cmbColectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbColectivoActionPerformed
        int selected = cmbColectivo.getSelectedIndex();
        if (selected != -1) {
            cmbIndex = selected;
        }
    }//GEN-LAST:event_cmbColectivoActionPerformed

    private void txtHLlegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHLlegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHLlegadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbColectivo;
    private com.toedter.calendar.JDateChooser dateFViaje;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblColectivo;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblDni2;
    private javax.swing.JLabel lblDni4;
    private javax.swing.JLabel lblDni5;
    private javax.swing.JLabel lblDni6;
    private javax.swing.JLabel lblDni7;
    private javax.swing.JLabel lblDni8;
    private javax.swing.JLabel lblDni9;
    private javax.swing.JLabel lblFViaje;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblOrigen;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlDni2;
    private javax.swing.JPanel pnlDni4;
    private javax.swing.JPanel pnlDni5;
    private javax.swing.JPanel pnlDni7;
    private javax.swing.JPanel pnlDni8;
    private javax.swing.JPanel pnlDni9;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtHLlegada;
    private javax.swing.JTextField txtHSalida;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void pasajeroConfig(String insert) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
