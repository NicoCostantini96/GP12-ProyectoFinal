package Modelo;

public class Asiento {
    
    private int id_lugar;
    private RutaViaje ruta;
    private int numero_asiento;
    private boolean estado;

    public Asiento(int id_lugar, RutaViaje ruta, int numero_asiento, boolean estado) {
        this.id_lugar = id_lugar;
        this.ruta = ruta;
        this.numero_asiento = numero_asiento;
        this.estado = estado;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    public RutaViaje getRuta() {
        return ruta;
    }

    public void setRuta(RutaViaje id_ruta) {
        this.ruta = id_ruta;
    }

    public int getNumero_asiento() {
        return numero_asiento;
    }

    public void setNumero_asiento(int numero_asiento) {
        this.numero_asiento = numero_asiento;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
