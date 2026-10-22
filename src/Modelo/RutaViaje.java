package Modelo;

import java.util.Date;

public class RutaViaje {
    
    private int id_ruta;
    private String origen;
    private String destino;
    private Date hora_salida;
    private Date hora_llegada;
    private int id_colectivo;
    private double precio;
    private boolean estado;

    public RutaViaje(int id_ruta, String origen, String destino, Date hora_salida, Date hora_llegada, int id_colectivo, double precio, boolean estado) {
        this.id_ruta = id_ruta;
        this.origen = origen;
        this.destino = destino;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.id_colectivo = id_colectivo;
        this.precio = precio;
        this.estado = estado;
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

    public Date getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Date hora_salida) {
        this.hora_salida = hora_salida;
    }

    public Date getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(Date hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public int getId_colectivo() {
        return id_colectivo;
    }

    public void setId_colectivo(int id_colectivo) {
        this.id_colectivo = id_colectivo;
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
