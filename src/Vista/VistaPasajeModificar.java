package Vista;

import Modelo.Asiento;
import Modelo.Pasaje;
import Modelo.Pasajero;
import Modelo.RutaViaje;
import static Vista.TestMain.asientoData;
import static Vista.TestMain.pasajeData;
import static Vista.TestMain.pasajeroData;
import static Vista.VistaMain.viajeData;
import static Vista.VistaMain.vistaPasaje;
import static Vista.VistaMain.vistaAsiento;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VistaPasajeModificar extends javax.swing.JInternalFrame {

    private Pasaje pasaje = null;
    private Pasajero pasajero = null;
    private RutaViaje ruta = null;
    private Asiento lugar = null;
    private boolean initChanges = false;
    private ArrayList<RutaViaje> rutas = new ArrayList();
    private LocalTime hVenta = LocalTime.of(0,0,0);
    private LocalDate fVenta = LocalDate.now();
    private int estate = 0;
    
    public VistaPasajeModificar() {
        initComponents();
        dchFVenta.addPropertyChangeListener("date", evt -> {
            if (dchFVenta.getDate() != null) {
                fVenta = dchFVenta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                cmbRutaUpdate();
            }
        });
    }
    
    public void start(int type) {
        estate = type;
        initChanges = false;
        
        var cmbPasajeroIndex = 0; cmbPasajero.removeAllItems();
        for (Pasajero p : pasajeroData.getList()) {
            cmbPasajero.addItem(p.getDni() + " " + p.getNombre() + " " + p.getApellido());
            if (estate == 2 && pasaje.getPasajero().getId_pasajero() == p.getId_pasajero()) {
                cmbPasajeroIndex = cmbPasajero.getItemCount() - 1;
            }
        }
        if (cmbPasajero.getItemCount() > 0) {
            cmbPasajero.setSelectedIndex(cmbPasajeroIndex);
            pasajero = pasajeroData.getList().get(cmbPasajeroIndex);
        }
        
        if (estate == 1) {
            fVenta = LocalDate.now();
            hVenta = LocalTime.now().withSecond(0).withNano(0);
        }else{
            fVenta = pasaje.getFecha_venta();
            hVenta = pasaje.getHora_venta();
        }
        
        cmbRutaUpdate();
        
        if (estate == 1) {
            lblTitulo.setText("AGREGAR PASAJE");
            if (ruta != null) {txtPrecio.setText(String.valueOf(ruta.getPrecio()));}else{txtPrecio.setText("0");}
        }else{
            lblTitulo.setText("MODIFICAR PASAJE");
            txtPrecio.setText(String.valueOf(pasaje.getPrecio()));
        }
        
        dchFVenta.setDate(java.sql.Date.valueOf(fVenta));
        txtHVenta.setText(hVenta.format(DateTimeFormatter.ofPattern(hVenta.getSecond() > 0 ? "HH:mm:ss" : "HH:mm")));
        
        lblMsjAsiento.setText("");
        lblMsjRuta.setText("");
        lblMsjFVenta.setText("");
        lblMsjHVenta.setText("");
        lblMsjPrecio.setText("");
        initChanges = true;
    }
    
    public void delHideWindow() {
        Pasaje p = null;
        if (pasaje != null) {p = pasajeData.getById(pasaje.getId_pasaje());}
        if (p == null) {
            this.hide();
        }
    }
    
    private void cmbRutaUpdate() {
        var cmbRutaIndex = 0; cmbRuta.removeAllItems();
        rutas.clear();
        for (RutaViaje r : viajeData.getList()) {
                if (r.getFecha_viaje().isAfter(fVenta) || (r.getFecha_viaje().isEqual(fVenta) && r.getHora_salida().isAfter(hVenta))) {
                cmbRuta.addItem(r.getColectivo().getMatricula() + " - (" + r.getOrigen() + " - " + r.getDestino() + ") - (" +r.getFecha_viaje()+ ") - (" + r.getHora_salida()+" - "+r.getHora_llegada()+")");
                rutas.add(r);
                if (estate == 2 && ruta.getId_ruta() == r.getId_ruta()) {
                    cmbRutaIndex = cmbRuta.getItemCount() - 1;
                }
            }
        }
        if (cmbRuta.getItemCount() > 0) {
            cmbRuta.setSelectedIndex(cmbRutaIndex);
            if (estate == 1) {ruta = viajeData.getList().getFirst();}
        }else{
            ruta = null;
            lblMsjRuta.setText("No hay ninguna ruta!!");
            lblMsjAsiento.setText("No hay ningún asiento!!");
        }
        cmbAsientoUpdate();
    }
    
    private void cmbAsientoUpdate() {
        int asientoIndex = 0;
        cmbAsiento.removeAllItems();
        if (ruta != null) {
            for (int i = 0; i < ruta.getColectivo().getCapacidad(); i++) {
                boolean me = (estate == 2 && lugar.getNumero_asiento() == i+1);
                ArrayList<Asiento> ocupado = new ArrayList<>();
                if (ruta != null) {ocupado = asientoData.SQL("SELECT * FROM `lugares` JOIN rutas ON rutas.id_ruta = lugares.id_ruta WHERE rutas.id_ruta = "+ruta.getId_ruta()+" and lugares.numero_asiento = "+(i+1)+";");}
                if (!ocupado.isEmpty() && !me) {continue;}
                cmbAsiento.addItem(String.valueOf(i+1));
                if (me) {asientoIndex = cmbAsiento.getItemCount() - 1;}
            }
            if (cmbAsiento.getItemCount() > 0) {cmbAsiento.setSelectedIndex(asientoIndex);}else{
                lblMsjAsiento.setText("No hay ningún asiento!!");
            }
        }
    }

    public Pasaje getPasaje() {
        return pasaje;
    }

    public void setPasaje(Pasaje pasaje) {
        this.pasaje = pasaje;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public RutaViaje getRuta() {
        return ruta;
    }

    public void setRuta(RutaViaje ruta) {
        this.ruta = ruta;
    }

    public Asiento getLugar() {
        return lugar;
    }

    public void setLugar(Asiento lugar) {
        this.lugar = lugar;
    }

    public int getEstate() {
        return estate;
    }

    public void setEstate(int estate) {
        this.estate = estate;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlPasajero = new javax.swing.JPanel();
        pnlPasajeroInput = new javax.swing.JPanel();
        lblPasajero = new javax.swing.JLabel();
        cmbPasajero = new javax.swing.JComboBox<>();
        pnlAsiento = new javax.swing.JPanel();
        pnlAsientoInput = new javax.swing.JPanel();
        lblAsiento = new javax.swing.JLabel();
        cmbAsiento = new javax.swing.JComboBox<>();
        lblMsjAsiento = new javax.swing.JLabel();
        pnlRuta = new javax.swing.JPanel();
        pnlRutaInput = new javax.swing.JPanel();
        lblRuta = new javax.swing.JLabel();
        cmbRuta = new javax.swing.JComboBox<>();
        lblMsjRuta = new javax.swing.JLabel();
        pnlFecha = new javax.swing.JPanel();
        pnlFechaInput = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        dchFVenta = new com.toedter.calendar.JDateChooser();
        lblMsjFVenta = new javax.swing.JLabel();
        pnlHoraPrecio = new javax.swing.JPanel();
        pnlHoraInput = new javax.swing.JPanel();
        txtHVenta = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblMsjHVenta = new javax.swing.JLabel();
        lblMsjPrecio = new javax.swing.JLabel();
        pnlPrecioInput = new javax.swing.JPanel();
        txtPrecio = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Flecha Flash S.A.: Pasajes");

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

        pnlPasajeroInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblPasajero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPasajero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPasajero.setText("PASAJERO:");

        cmbPasajero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPasajero.addActionListener(this::cmbPasajeroActionPerformed);

        javax.swing.GroupLayout pnlPasajeroInputLayout = new javax.swing.GroupLayout(pnlPasajeroInput);
        pnlPasajeroInput.setLayout(pnlPasajeroInputLayout);
        pnlPasajeroInputLayout.setHorizontalGroup(
            pnlPasajeroInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPasajeroInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblPasajero, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlPasajeroInputLayout.setVerticalGroup(
            pnlPasajeroInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasajeroInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblPasajero)
                .addComponent(cmbPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlPasajeroLayout = new javax.swing.GroupLayout(pnlPasajero);
        pnlPasajero.setLayout(pnlPasajeroLayout);
        pnlPasajeroLayout.setHorizontalGroup(
            pnlPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPasajeroInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPasajeroLayout.setVerticalGroup(
            pnlPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasajeroLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlPasajeroInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pnlAsientoInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAsiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAsiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAsiento.setText("ASIENTO:");

        cmbAsiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        lblMsjAsiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjAsiento.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjAsiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlAsientoLayout = new javax.swing.GroupLayout(pnlAsiento);
        pnlAsiento.setLayout(pnlAsientoLayout);
        pnlAsientoLayout.setHorizontalGroup(
            pnlAsientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAsientoInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlAsientoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblMsjAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlAsientoLayout.setVerticalGroup(
            pnlAsientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsientoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlAsientoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlRutaInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblRuta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRuta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRuta.setText("RUTA:");

        cmbRuta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbRuta.addActionListener(this::cmbRutaActionPerformed);

        javax.swing.GroupLayout pnlRutaInputLayout = new javax.swing.GroupLayout(pnlRutaInput);
        pnlRutaInput.setLayout(pnlRutaInputLayout);
        pnlRutaInputLayout.setHorizontalGroup(
            pnlRutaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbRuta, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlRutaInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        pnlRutaInputLayout.setVerticalGroup(
            pnlRutaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRutaInputLayout.createSequentialGroup()
                .addComponent(lblRuta)
                .addGap(5, 5, 5)
                .addComponent(cmbRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblMsjRuta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjRuta.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjRuta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlRutaLayout = new javax.swing.GroupLayout(pnlRuta);
        pnlRuta.setLayout(pnlRutaLayout);
        pnlRutaLayout.setHorizontalGroup(
            pnlRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRutaInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlRutaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblMsjRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlRutaLayout.setVerticalGroup(
            pnlRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRutaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlRutaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlFechaInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("FECHA VENTA:");

        javax.swing.GroupLayout pnlFechaInputLayout = new javax.swing.GroupLayout(pnlFechaInput);
        pnlFechaInput.setLayout(pnlFechaInputLayout);
        pnlFechaInputLayout.setHorizontalGroup(
            pnlFechaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFechaInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dchFVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlFechaInputLayout.setVerticalGroup(
            pnlFechaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(lblFecha)
            .addComponent(dchFVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblMsjFVenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjFVenta.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjFVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlFechaLayout = new javax.swing.GroupLayout(pnlFecha);
        pnlFecha.setLayout(pnlFechaLayout);
        pnlFechaLayout.setHorizontalGroup(
            pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFechaLayout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(lblMsjFVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
            .addComponent(pnlFechaInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFechaLayout.setVerticalGroup(
            pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFechaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlFechaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjFVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlHoraInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtHVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHVentaKeyReleased(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTelefono.setText("HORA VENTA:");

        javax.swing.GroupLayout pnlHoraInputLayout = new javax.swing.GroupLayout(pnlHoraInput);
        pnlHoraInput.setLayout(pnlHoraInputLayout);
        pnlHoraInputLayout.setHorizontalGroup(
            pnlHoraInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoraInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtHVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlHoraInputLayout.setVerticalGroup(
            pnlHoraInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoraInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtHVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTelefono))
        );

        lblMsjHVenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjHVenta.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjHVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblMsjPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMsjPrecio.setForeground(new java.awt.Color(230, 0, 0));
        lblMsjPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        pnlPrecioInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
        });

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecio.setText("PRECIO:");

        javax.swing.GroupLayout pnlPrecioInputLayout = new javax.swing.GroupLayout(pnlPrecioInput);
        pnlPrecioInput.setLayout(pnlPrecioInputLayout);
        pnlPrecioInputLayout.setHorizontalGroup(
            pnlPrecioInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrecioInputLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlPrecioInputLayout.setVerticalGroup(
            pnlPrecioInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrecioInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblPrecio))
        );

        javax.swing.GroupLayout pnlHoraPrecioLayout = new javax.swing.GroupLayout(pnlHoraPrecio);
        pnlHoraPrecio.setLayout(pnlHoraPrecioLayout);
        pnlHoraPrecioLayout.setHorizontalGroup(
            pnlHoraPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHoraInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPrecioInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoraPrecioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlHoraPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMsjHVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMsjPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
        pnlHoraPrecioLayout.setVerticalGroup(
            pnlHoraPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoraPrecioLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlHoraInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblMsjHVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlPrecioInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addContainerGap(7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnlRuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlHoraPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlHoraPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            lblMsjAsiento.getText().length() < 1 &&
            lblMsjRuta.getText().length() < 1 &&
            lblMsjFVenta.getText().length() < 1 &&
            lblMsjHVenta.getText().length() < 1 &&
            lblMsjPrecio.getText().length() < 1
        ) {
            int id = (pasaje != null) ? pasaje.getId_pasaje() : 0;
            LocalDate fVenta = dchFVenta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            double precio = Double.parseDouble(txtPrecio.getText());
            
            int asiento = Integer.parseInt(cmbAsiento.getSelectedItem().toString());
            
            if (estate == 1) {
                lugar = new Asiento(0, ruta, asiento, true);
                asientoData.insert(lugar);
            } else {
                lugar.setNumero_asiento(asiento);
                lugar.setRuta(ruta);
                asientoData.update(lugar);
            }
            
            vistaAsiento.updateAll();
            
            Pasaje p = new Pasaje(id,pasajero,lugar,ruta,fVenta,hVenta,precio,true);
            
            if (estate == 1) {
                pasajeData.insert(p);
                vistaPasaje.setTableIndex(vistaPasaje.getTableList().size());
            } else {
                pasajeData.update(p);
                int index = -1;
                for (Pasaje pl : pasajeData.getList()) {
                    index++;
                    if (pl.getId_pasaje() == id) {break;}
                }
                vistaPasaje.setTableIndex(index);
            }
            vistaPasaje.updateAll();
            this.hide();
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
        if (initChanges && cmbRuta.getSelectedIndex() >= 0) {
            ruta = rutas.get(cmbRuta.getSelectedIndex());
            txtPrecio.setText(String.valueOf(ruta.getPrecio()));
            cmbAsientoUpdate();
        }
        lblMsjRuta.setText("");
        lblMsjAsiento.setText("");
    }//GEN-LAST:event_cmbRutaActionPerformed

    private void cmbPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPasajeroActionPerformed
        if (initChanges && cmbPasajero.getSelectedIndex() >= 0) {
            pasajero = pasajeroData.getList().get(cmbPasajero.getSelectedIndex());
        }
    }//GEN-LAST:event_cmbPasajeroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbAsiento;
    private javax.swing.JComboBox<String> cmbPasajero;
    private javax.swing.JComboBox<String> cmbRuta;
    private com.toedter.calendar.JDateChooser dchFVenta;
    private javax.swing.JLabel lblAsiento;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMsjAsiento;
    private javax.swing.JLabel lblMsjFVenta;
    private javax.swing.JLabel lblMsjHVenta;
    private javax.swing.JLabel lblMsjPrecio;
    private javax.swing.JLabel lblMsjRuta;
    private javax.swing.JLabel lblPasajero;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAsiento;
    private javax.swing.JPanel pnlAsientoInput;
    private javax.swing.JPanel pnlFecha;
    private javax.swing.JPanel pnlFechaInput;
    private javax.swing.JPanel pnlHoraInput;
    private javax.swing.JPanel pnlHoraPrecio;
    private javax.swing.JPanel pnlPasajero;
    private javax.swing.JPanel pnlPasajeroInput;
    private javax.swing.JPanel pnlPrecioInput;
    private javax.swing.JPanel pnlRuta;
    private javax.swing.JPanel pnlRutaInput;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTextField txtHVenta;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void pasajeroConfig(String insert) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
