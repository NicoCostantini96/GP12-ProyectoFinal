package Modelo;

public class Asiento {
    
    private int id_lugar;
    private Colectivo colectivo;
    private int numero_asiento;
    private boolean estado;

    public Asiento(int id_lugar, Colectivo colectivo, int numero_asiento, boolean estado) {
        this.id_lugar = id_lugar;
        this.colectivo = colectivo;
        this.numero_asiento = numero_asiento;
        this.estado = estado;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo id_colectivo) {
        this.colectivo = id_colectivo;
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
