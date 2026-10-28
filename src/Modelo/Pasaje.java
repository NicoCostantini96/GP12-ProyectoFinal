package Modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class Pasaje {
    
    private int id_pasaje;
    private Pasajero pasajero;
    private Asiento lugar;
    private RutaViaje ruta;
    private LocalDate fecha_venta;
    private LocalTime hora_venta;
    private double precio;
    private boolean estado;

    public Pasaje(int id_pasaje, Pasajero pasajero, Asiento lugar, RutaViaje ruta, LocalDate fecha_venta, LocalTime hora_venta, double precio, boolean estado) {
        this.id_pasaje = id_pasaje;
        this.pasajero = pasajero;
        this.lugar = lugar;
        this.ruta = ruta;
        this.fecha_venta = fecha_venta;
        this.hora_venta = hora_venta;
        this.precio = precio;
        this.estado = estado;
    }

    public int getId_pasaje() {
        return id_pasaje;
    }

    public void setId_pasaje(int id_pasaje) {
        this.id_pasaje = id_pasaje;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Asiento getLugar() {
        return lugar;
    }

    public void setLugar(Asiento lugar) {
        this.lugar = lugar;
    }

    public RutaViaje getRuta() {
        return ruta;
    }

    public void setRuta(RutaViaje ruta) {
        this.ruta = ruta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public LocalTime getHora_venta() {
        return hora_venta;
    }

    public void setHora_venta(LocalTime hora_venta) {
        this.hora_venta = hora_venta;
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
}
