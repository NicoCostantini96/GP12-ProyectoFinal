package Modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class Pasaje {
    
    private int id_pasaje;
    private int id_pasajero;
    private int id_lugar;
    private int id_ruta;
    private LocalDate fecha_venta;
    private LocalTime hora_venta;
    private double precio;
    private boolean estado;

    public Pasaje(int id_pasaje, int id_pasajero, int id_lugar, int id_ruta, LocalDate fecha_venta, LocalTime hora_venta, double precio, boolean estado) {
        this.id_pasaje = id_pasaje;
        this.id_pasajero = id_pasajero;
        this.id_lugar = id_lugar;
        this.id_ruta = id_ruta;
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

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
