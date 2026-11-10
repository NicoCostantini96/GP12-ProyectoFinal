package Modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class RutaViaje {
    
    private int id_ruta;
    private String origen;
    private String destino;
    private LocalTime hora_salida;
    private LocalTime hora_llegada;
    private Colectivo colectivo;
    private double precio;
    private boolean estado;
    private LocalDate fecha_viaje;

    public RutaViaje(int id_ruta, String origen, String destino, LocalTime hora_salida, LocalTime hora_llegada, Colectivo colectivo, double precio, boolean estado, LocalDate fecha_viaje) {
        this.id_ruta = id_ruta;
        this.origen = origen;
        this.destino = destino;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.colectivo = colectivo;
        this.precio = precio;
        this.estado = estado;
        this.fecha_viaje = fecha_viaje;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public LocalTime getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(LocalTime hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFecha_viaje() {
        return fecha_viaje;
    }
    
    public void setFecha_viaje(LocalDate fecha_viaje) {
        this.fecha_viaje = fecha_viaje;
    }

    
}
