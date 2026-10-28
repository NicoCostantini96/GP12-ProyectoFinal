package Modelo;

public class Asiento {
    
    private int id_lugar;
    private Colectivo id_colectivo;
    private int numero_asiento;
    private boolean estado;

    public Asiento(int id_lugar, Colectivo id_colectivo, int numero_asiento, boolean estado) {
        this.id_lugar = id_lugar;
        this.id_colectivo = id_colectivo;
        this.numero_asiento = numero_asiento;
        this.estado = estado;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    public Colectivo getId_colectivo() {
        return id_colectivo;
    }

    public void setId_colectivo(Colectivo id_colectivo) {
        this.id_colectivo = id_colectivo;
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
